package eu.megamart2.moka.logging.mapping;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartComplexInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StructuredValue;;

public class InfoFactory {
	
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
		return null; // TODO
	}
	
	
	private MegamartAbstractInfoObject getFeatureInfo(IFeatureValue feature) {
		
		String name = feature.getFeature().getName();
		String visibility = feature.getFeature().getVisibility().toString();
		
		List<org.eclipse.papyrus.moka.fuml.Semantics
		.Classes.Kernel.IValue> values = feature.getValues();
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
}
