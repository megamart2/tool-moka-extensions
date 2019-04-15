package eu.megamart2.moka.logging.services;

import java.util.List;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.uml2.uml.ActivityNode;

import eu.megamart2.moka.logging.nodes.NodeInfo;
import eu.megamart2.moka.logging.nodes.NodeInfoGenerator;
import eu.megamart2.moka.logging.output.MegamartOutput;
import eu.megamart2.moka.logging.output.MegamartViewOutput;
import eu.megamart2.moka.logging.queue.InfoQueue;

public class MokaNodeInformationListener 
extends AbstractMokaService implements IMokaExecutionListener {
	
	private NodeInfoGenerator generator; 
	
	private InfoQueue queue;
	
	private EObject modelElement;

	@Override
	public void init(ILaunch launcher, EObject modelElement){
		queue = new InfoQueue();
		generator = new NodeInfoGenerator(queue,launcher);
        
		this.modelElement = modelElement;
		MegamartViewOutput.getInstance().clean();
	}
	
	@Override
	public void dispose() {
		MegamartOutput.getInstance().dispose();
	}
	
	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		
	    if(MegamartOutput.getInstance().isDisposed())
	    	MegamartOutput.getInstance().init(modelElement);
		
        generator.addToQueue(nodeVisitor);
        
        // write first line for  nodes
        //if(info != null)if(!info.isOnePhase()) printInfo(info);
        
       // if there is completed nodes
       List<NodeInfo> infos = queue.getCompleteNodes();
		
		// TODO Experiment
		for(NodeInfo in : infos)if(in != null) printInfo(in);
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {

		if(nodeVisitor instanceof ActionActivation) {
		
			if(queue.getNodeInfo((ActivityNode)((ActionActivation)nodeVisitor).getNode()) != null)
		if(!(queue.getNodeInfo((ActivityNode)((ActionActivation)nodeVisitor).getNode()).isOnePhase()))
		generator.complete(nodeVisitor);
		
		List<NodeInfo> infos = queue.getCompleteNodes();
		
		// TODO Experiment
		for(NodeInfo info : infos) printInfo(info);
		}
	}

	@Override
	public void valueCreated(IValue value) {}

	@Override
	public void valueDestroyed(IValue value) {}
	
	private void printInfo(NodeInfo info) {
    	info.printSummary();
	}
}
