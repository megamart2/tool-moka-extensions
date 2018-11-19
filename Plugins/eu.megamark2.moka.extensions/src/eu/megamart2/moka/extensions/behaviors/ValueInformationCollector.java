package eu.megamart2.moka.extensions.behaviors;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.ObjectTokenValueAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
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
import org.eclipse.uml2.uml.internal.impl.LiteralUnlimitedNaturalImpl;

import eu.megamart2.moka.extensions.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.extensions.info.MegamartComplexInfoObject;
import eu.megamart2.moka.extensions.info.MegamartPrimitiveInfoObject;
import eu.megamart2.moka.extensions.utils.HierarchyExplorer;
import eu.megamart2.moka.extensions.utils.ValueDescription;

@SuppressWarnings("restriction")
public abstract class ValueInformationCollector {
	
	 protected MegamartAbstractInfoObject getValueInfo(IValue value,String name) {
		 
		 if(value instanceof ObjectTokenValueAdapter) {
			 IToken token = ((ObjectTokenValueAdapter)value).getAdapted();
			 
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
		 }
		 else if(value instanceof IStructuredValue) {
			return getStructuredValueInfo(
					 (IStructuredValue)value,name);
		 }
		 /*
		 else if(value instanceof DefaultValueAdapter) {
			DefaultValueAdapter adapter = (DefaultValueAdapter)value;
			try {
				IVariable[] variables = adapter.getVariables();
		        if(variables == null) return "";
		        if(variables.length < 1) return "";
				return " type : " + variables[0].getReferenceTypeName() + ", value : " ;
			} catch (DebugException e) {
				e.printStackTrace();
			}
		 }*/
		 return null; 
	 }
		protected ValueDescription generateValue(ValueSpecification specification) {
			
			if(specification instanceof LiteralBooleanImpl) {
				boolean boo = ((LiteralBooleanImpl)specification).booleanValue();
                return new ValueDescription("Boolean",String.valueOf(boo));
			}	
			if(specification instanceof LiteralIntegerImpl) {
				int v = ((LiteralIntegerImpl)specification).getValue();
                return new ValueDescription("Integer",String.valueOf(v));
			}
			if(specification instanceof LiteralRealImpl) {
				double v = ((LiteralRealImpl)specification).getValue();
				return new ValueDescription("Real",String.valueOf(v));
			}	
			if(specification instanceof LiteralStringImpl)
				return new ValueDescription
						("String",((LiteralStringImpl)specification).getValue());

			if(specification instanceof LiteralUnlimitedNaturalImpl) {
				int v = ((LiteralUnlimitedNaturalImpl)specification).integerValue();
		        return new ValueDescription("Unlimited natural",String.valueOf(v));
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
			 type = sr2.substring(0,n2);	 
			
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
			
			List<org.eclipse.papyrus.moka.fuml.Semantics
			.Classes.Kernel.IValue> values = feature.getValues();
			// TODO
			if(values == null) return null;
			if(values.isEmpty()) return null;
			
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
            
           // TODO value.specify().getVisibility();
            
            for(String primitiveType : primitiveTypes)if(type.equalsIgnoreCase(primitiveType))
            	return new MegamartPrimitiveInfoObject(name,type,value.specify().stringValue());
		    
			return null;
		}
		/*
		private String getFeatureInfo(IFeatureValue feature) {
			
			// TODO 
			String result = "{ " + feature.getFeature().getName();
            
			List<org.eclipse.papyrus.moka.fuml.Semantics
			.Classes.Kernel.IValue> values = feature.getValues();
			
			if(values.size() == 1)if(values.get(0).specify() != null){
				if(values.get(0).specify().getType() != null) {
				result += ", type : " 
			+ values.get(0).specify().getType().getName();
				}
			result += ", value : " + values.get(0).specify().stringValue();
				return result + " }";  
			}
			
			boolean first = true;
			if(values.size() > 1) {
				result += ", values : [";
				for(org.eclipse.papyrus.moka.fuml.Semantics.Classes
						.Kernel.IValue value : values) {
					if(first) {
						result += "{ type : ";
						first = false;
					}
					else result += ",{ type : ";
					result +=
						value.specify().getType().getName()
						+ " value : "
						+ value.specify().stringValue() + " }";
				}
				result += "]";
			}
		    
			return result + "}";
		}*/
}
