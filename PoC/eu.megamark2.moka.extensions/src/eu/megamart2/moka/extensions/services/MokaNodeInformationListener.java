package eu.megamart2.moka.extensions.services;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;

import eu.megamart2.moka.extensions.nodes.NodeInfo;
import eu.megamart2.moka.extensions.utils.MegamartUtils;
import eu.megamart2.moka.extensions.utils.StartControl;

public class MokaNodeInformationListener 
extends AbstractMokaService implements IMokaExecutionListener {
	
	private MegamartUtils utils;

	private StartControl control;

	@Override
	public void init(ILaunch launcher, EObject modelElement){
		control = new StartControl();
	}
	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		if(utils == null) utils = new MegamartUtils();
		NodeInfo info = new NodeInfo(nodeVisitor,control);
		info.printSummary(utils);
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
	}

	@Override
	public void valueCreated(IValue value) {	
	}

	@Override
	public void valueDestroyed(IValue value) {	
	}

}
