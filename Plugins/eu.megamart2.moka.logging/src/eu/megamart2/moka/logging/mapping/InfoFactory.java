package eu.megamart2.moka.logging.mapping;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartComplexInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;
import eu.megamart2.moka.logging.utils.HierarchyExplorer;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.LiteralBooleanImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralIntegerImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralRealImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralStringImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralUnlimitedNaturalImpl;;

@SuppressWarnings("restriction")
public class InfoFactory {
	
	
	 public MegamartAbstractInfoObject getValueInfo(IToken token,String name) {
			 
			 // boolean
			 if(token.getValue() instanceof BooleanValue) {
				 return new MegamartPrimitiveInfoObject(name,"Boolean",
						 String.valueOf(((BooleanValue)token.getValue()).value));
			 }
			 
			 // integer
			 if(token.getValue() instanceof IntegerValue) {
				 return new MegamartPrimitiveInfoObject(name,"Integer",
						 String.valueOf((((IntegerValue)token.getValue()).value.intValue())));
			 }
			 
			 // real
			 if(token.getValue() instanceof RealValue) {
				 return new MegamartPrimitiveInfoObject(name,"Real",
						 String.valueOf(((RealValue)token.getValue()).getValue()));
			 }
			 
			 // string
			 if(token.getValue() instanceof StringValue) {
				 return new MegamartPrimitiveInfoObject(name,"String",
						 String.valueOf(((StringValue)token.getValue()).getValue()));
			 }
			 
			 // unlimited natural
			 if(token.getValue() instanceof UnlimitedNaturalValue) {
				 return new MegamartPrimitiveInfoObject(name,"Unlimited Natural",
						 String.valueOf(((UnlimitedNaturalValue)token.getValue()).getValue()));
			 }
			 
			 if(token instanceof ObjectToken) {  // TODO check
				MegamartAbstractInfoObject info = 
						getReferenceValueInfo((ObjectToken)token);
				if(info != null) return info;
			 }
			 
			 if(token.getValue() instanceof IStructuredValue) {
				 return getStructuredValueInfo(
						 (IStructuredValue)token.getValue(),name); 
			 }
		/* else if(value instanceof IStructuredValue) {
			return getStructuredValueInfo(
					 (IStructuredValue)value,name);
		 }*/
		 return null; 
	 }
		protected MegamartAbstractInfoObject generateValue(ValueSpecification specification) {
			
			if(specification instanceof LiteralBooleanImpl) {
				boolean boo = ((LiteralBooleanImpl)specification).booleanValue();
                return new MegamartPrimitiveInfoObject("","Boolean",String.valueOf(boo));
			}	
			if(specification instanceof LiteralIntegerImpl) {
				int v = ((LiteralIntegerImpl)specification).getValue();
				return new MegamartPrimitiveInfoObject("","Integer",String.valueOf(v));
			}
			if(specification instanceof LiteralRealImpl) {
				double v = ((LiteralRealImpl)specification).getValue();
				return new MegamartPrimitiveInfoObject("","Real",String.valueOf(v));
			}	
			if(specification instanceof LiteralStringImpl)
				return new MegamartPrimitiveInfoObject("",
						"String",((LiteralStringImpl)specification).getValue());

			if(specification instanceof LiteralUnlimitedNaturalImpl) {
				int v = ((LiteralUnlimitedNaturalImpl)specification).integerValue();
				return new MegamartPrimitiveInfoObject("","Unlimited natural",String.valueOf(v));
			}
			return null;
		}
		
		private MegamartAbstractInfoObject getReferenceValueInfo(ObjectToken token) {
			
			// TODO use complex object instead primitive
			if(!(token.getValue() instanceof CS_Reference))
				return null;
			 
			 String type = 
					 ((CS_Reference)token.getValue()).toString();
			 int n1 = type.indexOf('(') + 1;
			 String sr2 = type.substring(n1);
			 int n2 = sr2.indexOf('\n');
			 if(n2 > -1) type = sr2.substring(0,n2);	 
			
			 List<MegamartAbstractInfoObject> innerObjects = 
					 new LinkedList<MegamartAbstractInfoObject>();
			 List<IFeatureValue> features = 
					 ((CS_Reference)token.getValue()).getFeatureValues();
			if(features != null)if(features.size() > 0)
			for(IFeatureValue feature : features)
                innerObjects.add(getFeatureInfo(feature));
	
			return new MegamartComplexInfoObject(
					token.getHolder().getNode().getName(),type,innerObjects);
		}
		
		private MegamartAbstractInfoObject getStructuredValueInfo(IStructuredValue structure,String name) {
			
			List<IFeatureValue> features = structure.getFeatureValues();
			
			String type = getStructuredTypeInfo(structure);  
			
			String value = "";		
			boolean first = true;
			for(IFeatureValue feature : features) {
				if(first) first = false;
				else value += ", ";
			value += getFeatureInfo(feature);
			}
			return new MegamartPrimitiveInfoObject(name,type,value); // TODO
		}
		
		private String getStructuredTypeInfo(IStructuredValue structure) {
			
			String result = "";
			
			List<Classifier> classifiers = structure.getTypes();
			
			if(classifiers.size() == 1)
				return result + classifiers.get(0).getName();
			else { // there are super classes in the list
				HierarchyExplorer hierarchyExplorer =
						new HierarchyExplorer();
				Classifier finalClassifier = 
						hierarchyExplorer.getFinalClassifier(classifiers);
				return result  + finalClassifier.getName();
			}
		}
		
		private MegamartAbstractInfoObject getFeatureInfo(IFeatureValue feature) {
			
			String name = feature.getFeature().getName();
			String visibility = feature.getFeature().getVisibility().toString();
			
			List<org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue> values = feature.getValues();
			
			// TODO
			if(values == null) {
				String type = feature.getFeature().getType().getName(); // TODO add null checking
				return new MegamartPrimitiveInfoObject(name,type,"null",visibility);
			}
			if(values.isEmpty()) {
				String type = feature.getFeature().getType().getName(); // TODO add null checking
				return new MegamartPrimitiveInfoObject(name,type,"null",visibility);
			}
			
			if(values.size() == 1) {
				MegamartAbstractInfoObject result = getFumlValueInfo(values.get(0),name);
				if(result != null)
				result.setVisibility(visibility);
				return result;
			}
			     List<MegamartAbstractInfoObject> innerObjects =
			    		 new LinkedList<MegamartAbstractInfoObject>();
			     for(org.eclipse.papyrus.moka.fuml.Semantics
			.Classes.Kernel.IValue value : values)
			    	 innerObjects.add(getFumlValueInfo(value));
			     String type = feature.getFeature().getType().getName(); // TODO add null checking
			     return new MegamartComplexInfoObject(name,type,innerObjects,visibility);
			}
		
		private MegamartAbstractInfoObject getFumlValueInfo(
				org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue value) {
			
			if(value == null) return null;
			return null;
		   // if(value.specify() == null) return null;
		   // return getFumlValueInfo(value,value.specify().getName());
		}
		
		private MegamartAbstractInfoObject getFumlValueInfo(
				org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue value,String name) {
			return null;
			/*
			if(value == null) return null;
		    if(value.specify() == null) return null;
		    if(value.specify().getType() == null) return null;
		    
		    String type = value.specify().getType().getName();
            String[] primitiveTypes = {"Boolean","Integer","Real","String","Unlimited natural"};
            
            String visibility = value.specify().getVisibility().getName();
            
            for(String primitiveType : primitiveTypes)if(type.equalsIgnoreCase(primitiveType))
            	return new MegamartPrimitiveInfoObject(name,type,value.specify().stringValue(),visibility);
		    
			return null;*/
		}
		
		private class RecurssionChecker {
			int level;
			boolean finish;
			List<IValue> step;
			
			RecurssionChecker(IValue value){
				List<IValue> list = new LinkedList<IValue>();
				list.add(value);
				this.step = list;
				level = 0;
				finish = false;
			}
			
			boolean check() {
				while(!finish){
					try {
						nextStep();
					} catch (DebugException e) {
						e.printStackTrace();
						return false;
					}
					if(finish) return true;
					if(level > 100) return false;
				}
				return true;
			}
			
			void nextStep() throws DebugException {
				List<IValue> list = new LinkedList<IValue>();
				for(IValue value : step) {
					IVariable[] variables = value.getVariables();
					if(variables != null)for(IVariable variable : variables) {
						list.add(variable.getValue());
					}
				}
				step = list;
				if(step.isEmpty())finish = true;
				level++;
			}
			
		}
	
	
	
	
	/*
	public MegamartAbstractInfoObject createInfoObject(IValue value,String name) {
		if(value instanceof BooleanValue) {
			String stringValue = ((BooleanValue)value).getValue().toString();
			return new MegamartPrimitiveInfoObject(name,"Boolean",stringValue,"");
		}
		if(value instanceof IntegerValue) {
			String stringValue = ((IntegerValue)value).getValue().toString();
			return new MegamartPrimitiveInfoObject(name,"Integer",stringValue,"");
		}
		if(value instanceof RealValue) {
			String stringValue = ((RealValue)value).getValue().toString();
			return new MegamartPrimitiveInfoObject(name,"Real",stringValue,"");
		}
		if(value instanceof StringValue) {
			String stringValue = ((StringValue)value).getValue();
			return new MegamartPrimitiveInfoObject(name,"String",stringValue,"");
		}
		if(value instanceof StructuredValue) {
			List<IFeatureValue> features = ((StructuredValue)value).getFeatureValues();
		    List<MegamartAbstractInfoObject> innerObjects = new ArrayList<MegamartAbstractInfoObject>(features.size());
		    for(IFeatureValue feature : features) innerObjects.add(getFeatureInfo(feature));
		    // TODO recursion checker
		}
		return null;
	}
	
	
	private MegamartAbstractInfoObject getFeatureInfo(IFeatureValue feature) {
		
		String name = feature.getFeature().getName();
		String visibility = feature.getFeature().getVisibility().toString();
		
		List<IValue> values = feature.getValues();
		// TODO
		if(values == null) {
			String type = feature.getFeature().getType().getName(); // TODO add null checking
			return new MegamartPrimitiveInfoObject(name,type,"null",visibility);
		}
		if(values.isEmpty()) {
			String type = feature.getFeature().getType().getName(); // TODO add null checking
			return new MegamartPrimitiveInfoObject(name,type,"null",visibility);
		}
		
		if(values.size() == 1) {
			MegamartAbstractInfoObject result = getFumlValueInfo(values.get(0),name);
			if(result != null)
			result.setVisibility(visibility);
			return result;
		}
		
		     List<MegamartAbstractInfoObject> innerObjects =
		    		 new LinkedList<MegamartAbstractInfoObject>();
		     for(org.eclipse.papyrus.moka.fuml.Semantics
		.Classes.Kernel.IValue value : values)
		    	 innerObjects.add(getFumlValueInfo(value));
		     String type = feature.getFeature().getType().getName(); // TODO add null checking
		     return new MegamartComplexInfoObject(name,type,innerObjects,visibility);
		}
	private MegamartAbstractInfoObject getFumlValueInfo(
			org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue value) {
		
		if(value == null) return null;
	    if(value.specify() == null) return null;
	    
	    return getFumlValueInfo(value,value.specify().getName());
	}
	
	private MegamartAbstractInfoObject getFumlValueInfo(
			org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue value,String name) {
		
		if(value == null) return null;
	    if(value.specify() == null) return null;
	    if(value.specify().getType() == null) return null;
	    
	    String type = value.specify().getType().getName();
        String[] primitiveTypes = {"Boolean","Integer","Real","String","Unlimited natural"};
        
        String visibility = value.specify().getVisibility().getName();
        
        for(String primitiveType : primitiveTypes)if(type.equalsIgnoreCase(primitiveType))
        	return new MegamartPrimitiveInfoObject(name,type,value.specify().stringValue(),visibility);
	    
		return null;
	}
	/*
	private class RecurssionChecker {
		int level;
		boolean finish;
		List<IValue> step;
		
		RecurssionChecker(IValue value){
			List<IValue> list = new LinkedList<IValue>();
			list.add(value);
			this.step = list;
			level = 0;
			finish = false;
		}
		
		boolean check() {
			while(!finish){
				try {
					nextStep();
				} catch (DebugException e) {
					e.printStackTrace();
					return false;
				}
				if(finish) return true;
				if(level > 100) return false;
			}
			return true;
		}
		
		void nextStep() throws DebugException {
			List<IValue> list = new LinkedList<IValue>();
			for(IValue value : step) {
				
				IVariable[] variables = value.getVariables();
				if(variables != null)for(IVariable variable : variables) {
					list.add(variable.getValue());
				}
			}
			step = list;
			if(step.isEmpty())finish = true;
			level++;
		}
		
	}*/
}
