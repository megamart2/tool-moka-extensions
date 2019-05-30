package eu.megamart2.moka.logging.nodes;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.StartObjectBehaviorActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.DecisionNodeActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.TransitionActivationWrapper;

import eu.megamart2.moka.logging.behaviors.ActionInfo;
import eu.megamart2.moka.logging.behaviors.DecisionInfo;
import eu.megamart2.moka.logging.behaviors.StateTransitionInfo;
import eu.megamart2.moka.logging.behaviors.ValueSpecificationInfo;
import eu.megamart2.moka.logging.queue.InfoQueue;

public class NodeInfoGenerator {
	
	private final InfoQueue queue;
	
	private final ILaunch launcher; 
	
	public NodeInfoGenerator(InfoQueue queue,ILaunch launcher) {
        this.queue = queue;
        this.launcher = launcher;
	}
    public NodeInfo addToQueue(ISemanticVisitor nodeVisitor) { 
    	 return performAction(nodeVisitor,true); 
    	}
    
    public void complete(ISemanticVisitor nodeVisitor) { 
    	performAction(nodeVisitor,false); 
    	}
    
    public NodeInfo performAction(ISemanticVisitor nodeVisitor,boolean add) {
    	if(nodeVisitor instanceof StartObjectBehaviorActionActivation) {

			// TODO
			return null;
		}

		NodeInfo info = null;
		boolean stop = true;
        if(nodeVisitor instanceof DecisionNodeActivation && stop) {
        	info = new DecisionInfo(nodeVisitor);
        	stop = false;
        }
		if(nodeVisitor instanceof ValueSpecificationActionActivation && stop) {
			info = new ValueSpecificationInfo(nodeVisitor,launcher);
			stop = false;
		}
		if(nodeVisitor instanceof ActionActivation && stop) {
			info = new ActionInfo(nodeVisitor, launcher); 
			stop = false;
		}
		if(nodeVisitor instanceof TransitionActivationWrapper) {
			info = new StateTransitionInfo((TransitionActivationWrapper)nodeVisitor);
			stop = false;
		}
		if(stop)return null;
			if(add) {
			queue.addToQueue(getNode(nodeVisitor),info);
			return info;
			}
			else
			queue.complete(getNode(nodeVisitor), nodeVisitor);
			
		return null;
		}
    private Object getNode (ISemanticVisitor visitor) {
    	if(visitor instanceof ActionActivation)
    		return ((ActionActivation) visitor).getNode();
    	else if(visitor instanceof TransitionActivationWrapper)
    		return ((TransitionActivationWrapper)visitor).getNode();
    	return visitor;
    }
}
