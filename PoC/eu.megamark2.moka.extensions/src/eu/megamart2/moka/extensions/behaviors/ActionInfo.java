package eu.megamart2.moka.extensions.behaviors;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.uml2.uml.internal.impl.ActionImpl;
import org.eclipse.uml2.uml.internal.impl.CallBehaviorActionImpl;

import eu.megamart2.moka.extensions.nodes.InOutInfo;
import eu.megamart2.moka.extensions.nodes.NodeInfo;

@SuppressWarnings("restriction")
public class ActionInfo implements NodeInfo{
	
	private String name;
	private String type;
	private String behavior;
	private String inputInfo;
	private String outputInfo;
	
	private InOutInfo inOutInfo;
	
	private boolean complete;
	
	public ActionInfo(ISemanticVisitor nodeVisitor){
		
		complete = false;
		
		// General info
		ActionActivation cba = ((ActionActivation)nodeVisitor);
		ActionImpl callAction = 
				(ActionImpl)cba.getNode();
		type = cba.getClass().getName();
		if(type.contains(".")) type = type.substring(type.lastIndexOf(".") + 1);
		if(callAction.isSetName()) name = callAction.getName();
		if(callAction instanceof CallBehaviorActionImpl) {
			CallBehaviorActionImpl callBehavior = (CallBehaviorActionImpl)callAction;
			if(callBehavior.getBehavior().getName() != null) 
			behavior = callBehavior.getBehavior().getName();
		}
		
		// input info 
		inOutInfo = new InOutInfo(cba);
		inputInfo = "input pins : [" + inOutInfo.getInputsInfo() +"]]";
		
		// look if the node is complete and if it is complete the info
		if(isCompletable()) // TODO check cases 
			completeInfo(nodeVisitor);
	}
     
	@Override
	public boolean isComplete() { return complete; }
	
	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) {
		ActionActivation cba = ((ActionActivation)nodeVisitor);
		inOutInfo.completeInfo(cba);
		outputInfo = "output pins : [" + inOutInfo.getOutputsInfo() + "]";
		complete = true;
	}
	
	@Override
	public String getInputInfo() { return inputInfo; }

	@Override
	public String getOutputInfo() { return outputInfo; }

	@Override
	public String getName() { return name; }

	@Override
	public String getType() { return type; }

	@Override
	public String getBehavior() { return behavior; }
	
	public boolean isCompletable() {
		if(!type.contains("CallBehavior"))if(inOutInfo.getInputsInfo().isEmpty()) return true;
		return false;
	}
}
