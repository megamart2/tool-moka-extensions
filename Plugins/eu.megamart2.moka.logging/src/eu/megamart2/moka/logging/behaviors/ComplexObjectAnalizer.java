package eu.megamart2.moka.logging.behaviors;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;

public class ComplexObjectAnalizer {

	private ClassImpl clazz;
	
	public void doIt() {
		List<Property> attributes = clazz.allAttributes();
		for(Property attribute : attributes) {
			TreeIterator<EObject> objects = attribute.eAllContents();
			System.out.println(objects.toString());
		}
	}
  
}
