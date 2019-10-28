package eu.megamart2.moka.logging.mapping;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartComplexInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;
import eu.megamart2.moka.logging.utils.HierarchyExplorer;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.EnumerationValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.uml2.uml.Classifier;

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
			 
			 if(token instanceof ObjectToken) {  
				MegamartAbstractInfoObject info = 
						getReferenceValueInfo((ObjectToken)token);
				if(info != null) return info;
			 }
			 
			 if(token.getValue() instanceof IStructuredValue) {
				 return getStructuredValueInfo(
						 (IStructuredValue)token.getValue(),name); 
			 }
		 return null; 
	 }
	 
		private MegamartAbstractInfoObject getReferenceValueInfo(ObjectToken token) {
			
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
			return new MegamartPrimitiveInfoObject(name,type,value); 
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
			
			List<IValue> values = feature.getValues();
			

			if(values == null) {
				String type = feature.getFeature().getType().getName(); 
				return new MegamartPrimitiveInfoObject(name,type,"null",visibility);
			}
			if(values.isEmpty()) {
				String type = feature.getFeature().getType().getName(); 
				return new MegamartPrimitiveInfoObject(name,type,"null",visibility);
			}
			        
			        FeatureInfoCreator infoCreator = new FeatureInfoCreator();
					return infoCreator.examineFeature(feature);
			}	
			
		
		private class FeatureInfoCreator {
			
			List<Integer> hashes;
			
			
			FeatureInfoCreator(){
				hashes = new LinkedList<Integer>();
			}
			
			MegamartAbstractInfoObject examineValue(IValue value,String name) {
				
				
				 // boolean
				 if(value instanceof BooleanValue) {
					 return new MegamartPrimitiveInfoObject(name,"Boolean",
							 String.valueOf(((BooleanValue)value).value));
				 }
				 
				 // integer
				 if(value instanceof IntegerValue) {
					 return new MegamartPrimitiveInfoObject(name,"Integer",
							 String.valueOf((((IntegerValue)value).value.intValue())));
				 }
				 
				 // real
				 if(value instanceof RealValue) {
					 return new MegamartPrimitiveInfoObject(name,"Real",
							 String.valueOf(((RealValue)value).getValue()));
				 }
				 
				 // string
				 if(value instanceof StringValue) {
					 return new MegamartPrimitiveInfoObject(name,"String",
							 String.valueOf(((StringValue)value).getValue()));
				 }
				 
				 // unlimited natural
				 if(value instanceof UnlimitedNaturalValue) {
					 return new MegamartPrimitiveInfoObject(name,"Unlimited Natural",
							 String.valueOf(((UnlimitedNaturalValue)value).getValue()));
				 }
				 
				 if(value instanceof Reference) {
					 hashes.add(new Integer(value.hashCode())); // add to the hashes list
					 IObject_ referent = ((Reference)value).referent;
					 List<IFeatureValue> features = referent.getFeatureValues();
					 List<MegamartAbstractInfoObject> innerObjects = new LinkedList<MegamartAbstractInfoObject>();
					 MegamartAbstractInfoObject infoObject;
					 for(IFeatureValue feature : features) {
						 infoObject = examineFeature(feature);
						 if(infoObject != null)innerObjects.add(infoObject);
					 }
					return new MegamartComplexInfoObject(name,referent.getTypes().get(0).getName(),innerObjects);
				 }
				
				 if(value instanceof EnumerationValue) {
					return new MegamartPrimitiveInfoObject(name,value.getTypes().get(0).getName(),
							((EnumerationValue)value).toString());
				 }
				 
				return new MegamartPrimitiveInfoObject(name,value.getTypes().get(0).getName(),"Unknown");
			}		
			
			MegamartAbstractInfoObject examineFeature(IFeatureValue feature) {
				     
				// check hash
				int featureHash = feature.hashCode();
				for(Integer hash : hashes)if(hash.intValue() == featureHash) return null;
				
				// create new info object
				hashes.add(new Integer(featureHash)); // add to hashes list
				if(feature.getValues() == null || feature.getValues().isEmpty())
					  return new MegamartPrimitiveInfoObject(feature.getFeature().getName(),
							                       feature.getFeature().getType().getName(),"null");
			    return examineValue(feature.getValues().get(0),feature.getFeature().getName());
			}
			
		}
}
