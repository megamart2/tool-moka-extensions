package eu.megamart2.moka.extensions.behaviors;

import java.util.LinkedList;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ValueSpecificationActionImpl;

import eu.megamart2.moka.extensions.nodes.NodeInfo;
import eu.megamart2.moka.extensions.output.MegamartOutput;

@SuppressWarnings("restriction")
public class ValueSpecificationInfo extends ValueInformationCollector implements NodeInfo {

	private ValueSpecificationActionActivation activation;
	
	private LinkedList<String> info; 
	
	public ValueSpecificationInfo(ISemanticVisitor nodeVisitor,ILaunch launcher) {
			
			activation = (ValueSpecificationActionActivation)nodeVisitor;
			info = new LinkedList<String>();
			
			// general info
			info.add("Value Specification { ");
		    if(activation.getNode().isSetName()) 
		    	info.add("name = " + activation.getNode().getName() + " Outputs : [");
		    
                    IPinActivation pin = activation.pinActivations.get(0);
   				 ValueSpecification valueSpe  = 
						 ((ValueSpecificationActionImpl)pin.getNode().eContainer()).getValue();
					info.add(" value : " 
							+ generateValue(valueSpe).getDescription());
					// TODO type
		info.add("]}");
	}

	public String getName() {
		return null;
	}


	public String getType() { return "Value specification"; }

	@Override
	public boolean isComplete() { return true; }

	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) { 
		// Unnecessary 
		}

	@Override
	public boolean isCompletable() { return true; }

	@Override
	public void printSummary() {
	   String line = "";
       for(String sr : info) line = line + sr;
       MegamartOutput.getInstance().write(line);
       MegamartOutput.getInstance().write("\n");
	}

}
