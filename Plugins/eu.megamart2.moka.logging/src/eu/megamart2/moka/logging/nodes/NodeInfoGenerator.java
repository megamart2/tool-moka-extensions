package eu.megamart2.moka.logging.nodes;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.StartObjectBehaviorActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;

import eu.megamart2.moka.logging.behaviors.ActionInfo;
import eu.megamart2.moka.logging.behaviors.ValueSpecificationInfo;
import eu.megamart2.moka.logging.queue.InfoQueue;
import eu.megamart2.moka.logging.utils.StartControl;

public class NodeInfoGenerator {
	
	private final StartControl control;
	
	private final InfoQueue queue;
	
	private final ILaunch launcher; 
	
	public NodeInfoGenerator(StartControl control,InfoQueue queue,ILaunch launcher) {
        this.control = control;
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

			control.setStarted(true);
			return null;
		}
		if(!control.getStarted()) return null;
		NodeInfo info = null;
		boolean stop = true;

		if(nodeVisitor instanceof ValueSpecificationActionActivation && stop) {
			info = new ValueSpecificationInfo(nodeVisitor,launcher);
			stop = false;
		}
		if(nodeVisitor instanceof ActionActivation && stop) {
			info = new ActionInfo(nodeVisitor, launcher); 
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
