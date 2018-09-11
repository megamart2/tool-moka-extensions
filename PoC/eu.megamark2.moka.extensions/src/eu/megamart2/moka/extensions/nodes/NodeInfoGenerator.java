package eu.megamart2.moka.extensions.nodes;

import java.util.LinkedList;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_ReadSelfActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallBehaviorActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.InputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.StartObjectBehaviorActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ReadStructuralFeatureActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ForkNodeActivation;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Actions.BasicActions.ObjectNodeActivationWrapper;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralIntegerImpl;
import org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl;
import org.eclipse.uml2.uml.internal.impl.PropertyImpl;
import org.eclipse.uml2.uml.internal.impl.ReadStructuralFeatureActionImpl;
import org.eclipse.uml2.uml.internal.impl.ValueSpecificationActionImpl;

import eu.megamart2.moka.extensions.behaviors.ActionInfo;
import eu.megamart2.moka.extensions.queue.InfoQueue;
import eu.megamart2.moka.extensions.utils.MegamartUtils;
import eu.megamart2.moka.extensions.utils.StartControl;

@SuppressWarnings("restriction")
public class NodeInfoGenerator {
	
	//private LinkedList<String> summary;
	
	//private final ISemanticVisitor nodeVisitor;
	
	private final StartControl control;
	
	private final InfoQueue queue;
	
	public NodeInfoGenerator(StartControl control,InfoQueue queue) {
		//this.nodeVisitor = nodeVisitor;
        this.control = control;
        this.queue = queue;
		//summary = new LinkedList<String>();
       // addToQueue();
	}
    public NodeInfo addToQueue(ISemanticVisitor nodeVisitor) { 
    	 return performAction(nodeVisitor,true); 
    	}
    
    public void complete(ISemanticVisitor nodeVisitor) { 
    	performAction(nodeVisitor,false); 
    	}
    
    public NodeInfo performAction(ISemanticVisitor nodeVisitor,boolean add) {
    	if(nodeVisitor instanceof StartObjectBehaviorActionActivation) {

			/*summary.add("**** Start Object Behaviour ****");
			summary.add("");*/
			control.setStarted(true);
			return null;
		}
		if(!control.getStarted()) return null;
		if(nodeVisitor instanceof ActivityEdgeInstance) {
		/*	ActivityEdge edge = ((ActivityEdgeInstance) nodeVisitor).edge;
			if(edge == null) {
				summary.add(">> Edge \n");
				return;
			}
			sr = edge.getName();
			summary.add(">> " + sr);
			summary.add("");*/
		//	return;
			}
		if(nodeVisitor instanceof ForkNodeActivation) {
			//summary.add(">> Fork activation \n");
		//	return;
		}
		if(nodeVisitor instanceof InputPinActivation) {
			//summary.add(">> InputPinActivation \n");
		//	return;
		}

		if(nodeVisitor instanceof ActionActivation) {
			
			NodeInfo bInfo = new ActionInfo(nodeVisitor);
			if(add) {
			queue.addToQueue(((ActionActivation) nodeVisitor).getNode(),bInfo);
			return bInfo;
			}
			else
			queue.complete(((ActionActivation) nodeVisitor).getNode(), nodeVisitor);
			//summary.add(bInfo.getInfo());
		    //summary.add("");
			
    }
		return null;
		}
}
