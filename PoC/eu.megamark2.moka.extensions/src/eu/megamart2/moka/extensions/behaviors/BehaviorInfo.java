package eu.megamart2.moka.extensions.behaviors;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallBehaviorActionActivation;
import org.eclipse.uml2.uml.internal.impl.CallBehaviorActionImpl;

import eu.megamart2.moka.extensions.nodes.InOutInfo;

@SuppressWarnings("restriction")
public class BehaviorInfo {
	
	private String info;
	
	private InOutInfo inOutInfo;
	
	private CallBehaviorActionActivation cba;
	
	public BehaviorInfo(ISemanticVisitor nodeVisitor) {
		
		// General info
		info = ">> Call Behavior\n";
		cba = ((CallBehaviorActionActivation)nodeVisitor);
		CallBehaviorActionImpl cb = 
				(CallBehaviorActionImpl)cba.getNode();
		if(cb.isSetName()) addInfo("   Name : " + cb.getName() + "\n");
		if(cb.getBehavior().getName() != null) 
			addInfo("   Behavior : " + cb.getBehavior().getName() + "\n"); // TODO improve Strings management
		
		// inOut info 
		inOutInfo = new InOutInfo(cba);
		addInfo("   Inputs :\n");
		addInfo(inOutInfo.getInputsInfo());
	}
	 public void completeInfo() {
		 addInfo(" Outputs :\n");  // Output info
		 inOutInfo.completeInfo(cba);
		 addInfo(inOutInfo.getOutputsInfo());
	 }
     private void addInfo(String sr) {  info = info + sr; }
     
     public String getInfo() { return info; }
}
