package eu.megamart2.moka.extensions.behaviors;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.PinActivationVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.OutputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ReadStructuralFeatureActionActivation;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.StructuralFeature;

import eu.megamart2.moka.extensions.nodes.NodeInfo;
import eu.megamart2.moka.extensions.utils.MegamartUtils;

public class ReadFeatureInfo extends ValueInformationCollector implements NodeInfo {

    private final ReadStructuralFeatureActionActivation activation;
	
	@SuppressWarnings("restriction")
	public ReadFeatureInfo(ISemanticVisitor nodeVisitor,ILaunch launcher) {
		
       activation = (ReadStructuralFeatureActionActivation)nodeVisitor;
       if(activation.getNode() instanceof ReadStructuralFeatureAction) {
    	   ReadStructuralFeatureAction action = 
    			   (ReadStructuralFeatureAction)activation.getNode();
           IPinActivation pin =  activation.getPinActivation(action.getResult());
           
           MokaDebugTarget target = new MokaDebugTarget(launcher);
          PinActivationVariableAdapter adapter = new PinActivationVariableAdapter(target,pin); 
          try {
			System.out.println(adapter.getName() + " " + adapter.getReferenceTypeName() + " " +
			  adapter.getValue().getValueString());
		} catch (DebugException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       

       
       System.out.println(); 
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() { return "Read Structured Feature"; }

	@Override
	public String getBehavior() { return null; }

	@Override
	public String getInputInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOutputInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isComplete() { return true; }

	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCompletable() { return true; }

	@Override
	public void printSummary(MegamartUtils utils) {
		// TODO Auto-generated method stub

	}

}
