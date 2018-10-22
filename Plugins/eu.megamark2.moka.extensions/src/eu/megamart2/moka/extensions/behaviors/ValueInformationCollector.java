package eu.megamart2.moka.extensions.behaviors;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.DefaultValueAdapter;
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


import eu.megamart2.moka.extensions.utils.HierarchyExplorer;
import eu.megamart2.moka.extensions.utils.ValueDescription;

@SuppressWarnings("restriction")
public abstract class ValueInformationCollector {
	
	 protected String getValueInfo(IValue value) {
		 
		 if(value instanceof ObjectTokenValueAdapter) {
			 IToken token = ((ObjectTokenValueAdapter)value).getAdapted();
			 
			 // boolean
			 if(token.getValue() instanceof BooleanValue) {
				 return " type : Boolean, value : "
						 + String.valueOf(((BooleanValue)token.getValue()).value);
			 }
			 
			 // integer
			 if(token.getValue() instanceof IntegerValue) {
				 return " type : Integer, value : " 
			 + String.valueOf((((IntegerValue)token.getValue()).value.intValue()));
			 }
			 
			 // real
			 if(token.getValue() instanceof RealValue) {
				 return " type : Real, value : "
						 + String.valueOf(((RealValue)token.getValue()).getValue());
			 }
			 
			 // string
			 if(token.getValue() instanceof StringValue) {
				 return " type String, value : "
						 + ((StringValue)token.getValue()).getValue();
			 }
			 
			 // unlimited natural
			 if(token.getValue() instanceof UnlimitedNaturalValue) {
				 return " type : Unlimited natural, value : "
						 + String.valueOf(((UnlimitedNaturalValue)token.getValue())
								 .getValue().intValue());
			 }
			 
			 if(token instanceof ObjectToken) {  // TODO check
				String info = getReferenceValueInfo((ObjectToken)token);
				if(info != null) return info;
			 }
			 
			 if(token.getValue() instanceof IStructuredValue) {
				 String line = getStructuredValueInfo(
						 (IStructuredValue)token.getValue()); 
				      if(line.contains("type") && line.contains("value"))
						return line;
			 }
		 }
		 else if(value instanceof IStructuredValue) {
			return getStructuredValueInfo(
					 (IStructuredValue)value);
		 }
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
		 }
		 return ""; 
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
		
		protected String getReferenceValueInfo(ObjectToken token) {
			
			if(!(token.getValue() instanceof CS_Reference))
				return null;
			 
			 String sr = 
					 ((CS_Reference)token.getValue()).toString();
			 int n1 = sr.indexOf('(') + 1;
			 String sr2 = sr.substring(n1);
			 int n2 = sr2.indexOf('\n');
			 sr = "{ " + token.getHolder().getNode().getName() +
					 " type : " + sr2.substring(0,n2);	 
			
			 
			 List<IFeatureValue> features = 
					 ((CS_Reference)token.getValue()).getFeatureValues();
			if(features != null)if(features.size() > 0) {
			sr += ", value : [";
			boolean first = true;
			for(IFeatureValue feature : features) {
				if(first) first = false;
				else sr += ", ";
			sr += getFeatureInfo(feature);
			}
			}
			return sr + "]}";
		}
		
		protected String getStructuredValueInfo(IStructuredValue structure) {
			
			List<IFeatureValue> features = structure.getFeatureValues();
			
			String result = getStructuredTypeInfo(structure) 
			+ ", value : ["; 
			
			boolean first = true;
			for(IFeatureValue feature : features) {
				if(first) first = false;
				else result += ", ";
			result += getFeatureInfo(feature);
			}
			return result + "]";
		}
		
		protected String getStructuredTypeInfo(IStructuredValue structure) {
			
			String result = "type : ";
			
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
		
		protected String getFeatureInfo(IFeatureValue feature) {
			
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
		}
}
