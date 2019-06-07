package eu.megamart2.moka.logging.services;

import java.util.List;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.DecisionNodeActivation;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.StateMachineSemanticVisitor;

import eu.megamart2.moka.logging.format.MegamartFormatFacade;
import eu.megamart2.moka.logging.format.MegamartInfoFormat;
import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.mapping.DecisionNode;
import eu.megamart2.moka.logging.mapping.ModelMap;
import eu.megamart2.moka.logging.mapping.NodeElement;
import eu.megamart2.moka.logging.mapping.StateElement;
import eu.megamart2.moka.logging.output.MegamartOutput;
import eu.megamart2.moka.logging.output.MegamartViewOutput;

public class MokaNodeInformationListener 
extends AbstractMokaService implements IMokaExecutionListener {

	private int index;
	
	@Override
	public void init(ILaunch launcher, EObject modelElement){
		ModelMap.getInstance().reset();
		MegamartViewOutput.getInstance().clean();
	}
	
	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		NodeElement nodeElement = null;
		if(nodeVisitor instanceof ActionActivation) {
		 ActionActivation actionActivation = (ActionActivation)nodeVisitor;
		 nodeElement = new NodeElement(actionActivation,index);
	 } else if(nodeVisitor instanceof DecisionNodeActivation) {
		nodeElement = new DecisionNode((DecisionNodeActivation)nodeVisitor,index);
	 } else if(nodeVisitor instanceof StateMachineSemanticVisitor) {
		 nodeElement = new StateElement((StateMachineSemanticVisitor)nodeVisitor,index);
	 }
	if(nodeElement != null) {
		index++;
		ModelMap.getInstance().addNode(nodeElement);
	}
	     ModelMap.getInstance().update();
	     List<MegamartAbstractInfoObject> infos = ModelMap.getInstance().getCompleteNodes();
	     for(MegamartAbstractInfoObject info : infos) printSummary(info.getTime(),info);
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
		ModelMap.getInstance().update();
		List<MegamartAbstractInfoObject> infos = ModelMap.getInstance().getCompleteNodes();
	    for(MegamartAbstractInfoObject info : infos) printSummary(info.getTime(),info);
	}

	@Override
	public void valueCreated(IValue value) {	
		ModelMap.getInstance().update();
	}

	@Override
	public void valueDestroyed(IValue value) {}
	
	private void printSummary(String time,MegamartAbstractInfoObject info) {  
		
		MegamartOutput utils = MegamartOutput.getInstance();
		MegamartViewOutput viewOut = MegamartViewOutput.getInstance();
		
		MegamartFormatFacade consoleFormat = 
				new MegamartFormatFacade(MegamartInfoFormat.JSON_FORMAT);
		
		utils.write(consoleFormat.format(info));
		viewOut.releaseEntry(time, info);
	}
	
	
	@Override
	public void dispose() {
		ModelMap.getInstance().update();
		List<MegamartAbstractInfoObject> infos = ModelMap.getInstance().getAllNodes();
	    for(MegamartAbstractInfoObject info : infos) printSummary(info.getTime(),info);
	}
	
	
	
	/*
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
		try {
		System.out.println(nodeVisitor.getClass().toString());
	    if(MegamartOutput.getInstance().isDisposed())
	    	MegamartOutput.getInstance().init(modelElement);
		
        generator.addToQueue(nodeVisitor);
        
        // write first line for  nodes
        //if(info != null)if(!info.isOnePhase()) printInfo(info);
        
       // if there is completed nodes
       List<NodeInfo> infos = queue.getCompleteNodes();

		for(NodeInfo in : infos)if(in != null) printInfo(in);
		} catch(Exception e) {
		//	e.printStackTrace();
			System.out.println("ERROR *****");
			return;
		}
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
        try {
		if(nodeVisitor instanceof ActionActivation) {
		
			if(queue.getNodeInfo((ActivityNode)((ActionActivation)nodeVisitor).getNode()) != null)
		if(!(queue.getNodeInfo((ActivityNode)((ActionActivation)nodeVisitor).getNode()).isOnePhase()))
		generator.complete(nodeVisitor);
		
		List<NodeInfo> infos = queue.getCompleteNodes();
		
		// TODO Experiment
		for(NodeInfo info : infos) printInfo(info);
		}
        }catch(Exception e) {
        //	e.printStackTrace();
        	System.out.println("ERROR *****");
        	return;
        }
	}

	@Override
	public void valueCreated(IValue value) {}

	@Override
	public void valueDestroyed(IValue value) {}
	
	private void printInfo(NodeInfo info) {
    	info.printSummary();
	}
	*/
}
