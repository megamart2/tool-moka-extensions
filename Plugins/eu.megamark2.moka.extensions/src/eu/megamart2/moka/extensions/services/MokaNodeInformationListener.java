package eu.megamart2.moka.extensions.services;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.uml2.uml.ActivityNode;

import eu.megamart2.moka.extensions.nodes.NodeInfo;
import eu.megamart2.moka.extensions.nodes.NodeInfoGenerator;
import eu.megamart2.moka.extensions.output.MegamartOutput;
import eu.megamart2.moka.extensions.queue.InfoQueue;
import eu.megamart2.moka.extensions.utils.StartControl;

public class MokaNodeInformationListener 
extends AbstractMokaService implements IMokaExecutionListener {

	private StartControl control;
	
	private NodeInfoGenerator generator; 
	
	private InfoQueue queue;
	
	private SimpleDateFormat dateFormat;
	
	private EObject modelElement;

	@Override
	public void init(ILaunch launcher, EObject modelElement){
		control = new StartControl();
		queue = new InfoQueue();
		generator = new NodeInfoGenerator(control,queue,launcher);
		dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        
		this.modelElement = modelElement;
	}
	
	@Override
	public void dispose() {
		MegamartOutput.getInstance().dispose();
	}
	
	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		
	    if(MegamartOutput.getInstance().isDisposed())
	    	MegamartOutput.getInstance().init(modelElement);
		
        NodeInfo info = generator.addToQueue(nodeVisitor);
        
        // write first line for non completable nodes
        if(info != null)if(!info.isCompletable()) printInfo(info);
        
       // if there is completed nodes
       List<NodeInfo> infos = queue.getCompleteNodes();
		
		// TODO Experiment
		for(NodeInfo in : infos)if(in != null) printInfo(in);
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {

		if(nodeVisitor instanceof ActionActivation) {
		
			if(queue.getNodeInfo((ActivityNode)((ActionActivation)nodeVisitor).getNode()) != null)
		if(!(queue.getNodeInfo((ActivityNode)((ActionActivation)nodeVisitor).getNode()).isCompletable()))
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
    	Date date = new Date();
    	MegamartOutput.getInstance().write(dateFormat.format(date) + " ");
    	info.printSummary();
	}
}
