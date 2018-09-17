package eu.megamart2.moka.extensions.nodes;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.InputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.StartObjectBehaviorActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ForkNodeActivation;

import eu.megamart2.moka.extensions.behaviors.ActionInfo;
import eu.megamart2.moka.extensions.behaviors.AlternativeActionInfo;
import eu.megamart2.moka.extensions.behaviors.ValueSpecificationInfo;
import eu.megamart2.moka.extensions.queue.InfoQueue;
import eu.megamart2.moka.extensions.utils.StartControl;

public class NodeInfoGenerator {
	
	private final StartControl control;
	
	private final InfoQueue queue;
	
	private final ILaunch launcher;
	
	public NodeInfoGenerator(StartControl control,InfoQueue queue,ILaunch launcher) {
		//this.nodeVisitor = nodeVisitor;
        this.control = control;
        this.queue = queue;
        this.launcher = launcher;
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
		NodeInfo info = null;
		boolean stop = true;
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
		
		if(nodeVisitor instanceof ValueSpecificationActionActivation && stop) {
			info = new ValueSpecificationInfo(nodeVisitor,launcher);
			stop = false;
		}
		if(nodeVisitor instanceof ActionActivation && stop) {
			
			//NodeInfo bInfo = new ActionInfo(nodeVisitor);
			info = new AlternativeActionInfo(nodeVisitor, launcher); // TODO Experiment
			stop = false;
		}
		if(stop)return null;
			if(add) {
			queue.addToQueue(((ActionActivation) nodeVisitor).getNode(),info);
			return info;
			}
			else
			queue.complete(((ActionActivation) nodeVisitor).getNode(), nodeVisitor);
			
		return null;
		}
}
