package eu.megamart2.moka.extensions.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;

import eu.megamart2.moka.extensions.nodes.NodeInfo;
import eu.megamart2.moka.extensions.nodes.NodeInfoGenerator;
import eu.megamart2.moka.extensions.queue.InfoQueue;
import eu.megamart2.moka.extensions.utils.MegamartUtils;
import eu.megamart2.moka.extensions.utils.StartControl;

public class MokaNodeInformationListener 
extends AbstractMokaService implements IMokaExecutionListener {
	
	private MegamartUtils utils;

	private StartControl control;
	
	private NodeInfoGenerator generator;
	
	private InfoQueue queue;
	
	private SimpleDateFormat dateFormat;

	@Override
	public void init(ILaunch launcher, EObject modelElement){
		control = new StartControl();
		queue = new InfoQueue();
		generator = new NodeInfoGenerator(control,queue);
		dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
	}
	
	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		if(utils == null) utils = new MegamartUtils();
        NodeInfo info = generator.addToQueue(nodeVisitor);
        if(info != null) {
        	
        	if(info.getBehavior() != null)
        	utils.writeLine(dateFormat.format(new Date()) + ", " + info.getType() + " [ name = " 
        + info.getName() + ", behavior = " + info.getBehavior() + ", " + info.getInputInfo());
        	
        	else utils.writeLine(dateFormat.format(new Date()) + ", " + info.getType() + " [ name = " 
        	    + info.getName() + ", " + info.getInputInfo());
        	
        utils.writeLine("");
        }
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
		generator.complete(nodeVisitor);
		List<NodeInfo> infos = queue.getCompleteNodes();
		
		for(NodeInfo info : infos) {
			utils.writeLine(dateFormat.format(new Date()) + ", " + info.getType() 
			+ " [ name = " +  info.getName() + ", " + info.getOutputInfo());
			utils.writeLine("");
		}
	}

	@Override
	public void valueCreated(IValue value) {}

	@Override
	public void valueDestroyed(IValue value) {}
}
