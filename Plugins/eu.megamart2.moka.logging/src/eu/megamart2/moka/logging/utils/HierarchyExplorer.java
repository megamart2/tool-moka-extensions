package eu.megamart2.moka.logging.utils;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.uml2.uml.Classifier;

public class HierarchyExplorer {
	
	public Classifier getFinalClassifier(List<Classifier> classifiers) {
		
		if(classifiers.size() == 1) return classifiers.get(0);
		
		for(Classifier classifier : classifiers)
			   if(classifier.isFinalSpecialization())
				    return classifier;
		
        for(int i = 0; i < 500; i++) { // maximun iterations allowed 500
        	
        	if(classifiers.size() == 1) return classifiers.get(0);
        	classifiers = removeFirstElementParents(classifiers);
        	classifiers = changePlace(classifiers);
        }
		return null;
	}
	
	private List<Classifier> changePlace(List<Classifier> classifiers){
		
		Classifier element = classifiers.get(0);
		element = classifiers.set(classifiers.size() - 1, element);
		classifiers.set(0, element);
		return classifiers;
	}
	
	private List<Classifier> removeFirstElementParents(List<Classifier> classifiers){
		
		List<Classifier> result = new LinkedList<Classifier>();
		Classifier firstElement = classifiers.get(0);
		result.add(firstElement);
		
		List<Classifier> parents = firstElement.allParents();
		
		boolean first = true;
		for(Classifier classifier : classifiers) {
			if(first) first = false;
			else {
				if(notInList(parents,classifier))
					result.add(classifier);
			}
		}
		return result;
	}
	
	private boolean notInList(List<Classifier> list,Classifier target) {
		
		for(Classifier classifier : list)
			if(classifier.getName().equalsIgnoreCase(target.getName()))
				return false;
		
		return true;
	}

}
