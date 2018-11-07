package eu.megamart2.moka.extensions.values;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.DefaultValueAdapter;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.ObjectTokenValueAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;

import eu.megamart2.moka.extensions.utils.HierarchyExplorer;

public class InOutInfoFactory {

	private MegamartAbstractValue createMegamartValue(IValue value,String name) {
		
		 if(value instanceof ObjectTokenValueAdapter) {
			 IToken token = ((ObjectTokenValueAdapter)value).getAdapted(); 
			 
			 // boolean
			 if(token.getValue() instanceof BooleanValue) {
               return new MegamartPrimitiveValue(name,"Boolean",
            	 String.valueOf(((BooleanValue)token.getValue()).value));
			 }
			 
			 // integer
			 if(token.getValue() instanceof IntegerValue) {
               return new MegamartPrimitiveValue(name,"Integer",
                  String.valueOf(((IntegerValue)token.getValue()).value));
			 }
			 
			 // real
			 if(token.getValue() instanceof RealValue) {
	            return new MegamartPrimitiveValue(name,"Real",
	               String.valueOf(((RealValue)token.getValue()).value));
			 }
			 
			 // string
			 if(token.getValue() instanceof StringValue) {
	            return new MegamartPrimitiveValue(name,"String",
	                		String.valueOf(((StringValue)token.getValue()).value));
			 }
			 
			 // unlimited natural
			 if(token.getValue() instanceof UnlimitedNaturalValue) {
	            return new MegamartPrimitiveValue(name,"Unlimited natural",
	               String.valueOf(((UnlimitedNaturalValue)token.getValue()).value));   
			 }
			 /*
			 if(token instanceof ObjectToken) {  // TODO check
				String info = getReferenceValueInfo((ObjectToken)token);
				if(info != null) return info;
			 }*/
			 
			 if(token.getValue() instanceof IStructuredValue) {
                 return getStructuredValueObject((IStructuredValue)token.getValue());
			 }
		 }
		 else if(value instanceof IStructuredValue) {
			 return getStructuredValueObject((IStructuredValue)value);
		 }
		 return null;
		/* else if(value instanceof DefaultValueAdapter) {
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
   }	
	
	private MegamartAbstractValue getStructuredValueObject(IStructuredValue value) {	
		
		List<IFeatureValue> features = value.getFeatureValues();
		List<MegamartAbstractValue> innerValues = 
				new ArrayList<MegamartAbstractValue>(features.size());
		for(IFeatureValue feature : features)
			innerValues.add(getValueObjectFromFeature(feature));
		System.out.println(value.toString()); // TODO check
		return new MegamartComplexValue(value.specify().getName(),
				value.specify().getType().getName(),innerValues);			
	}
	
	private MegamartAbstractValue getValueObjectFromFeature(IFeatureValue value) {
		
		List<org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue> 
		values = value.getValues();
		
		if(values == null) return null;
		if(values.isEmpty()) return null;
			
		if(values.size() == 1)
            return getMegamartValueFromFumlValue(values.get(0));

			List<MegamartAbstractValue> innerValues = 
					new ArrayList<MegamartAbstractValue>(values.size());
		for(int i = 0; i < innerValues.size(); i++)
			innerValues.add(getMegamartValueFromFumlValue(values.get(i)));
		String name = value.getFeature().getName();
		String type = value.getFeature().getType().getName();
		return new MegamartArrayValue(name,type,innerValues);
	}
	
	private MegamartAbstractValue getMegamartValueFromFumlValue(
			org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue value) {
		String name = value.specify().getName();
		HierarchyExplorer explorer = new HierarchyExplorer();
		String type = explorer.getFinalClassifier(value.getTypes()).getName();
		String stringValue = value.specify().stringValue();
	    return new MegamartPrimitiveValue(name,type,stringValue);
	}

}
