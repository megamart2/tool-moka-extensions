package eu.megamart2.moka.extensions.behaviors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList; 
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.PinActivationVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.InputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.OutputPinActivation;
import org.eclipse.uml2.uml.internal.impl.ActionImpl;
import org.eclipse.uml2.uml.internal.impl.CallBehaviorActionImpl;

import eu.megamart2.moka.extensions.nodes.NodeInfo;
import eu.megamart2.moka.extensions.output.MegamartOutput;
import eu.megamart2.moka.extensions.ui.MokaEntry;

@SuppressWarnings("restriction")
public class ActionInfo extends ValueInformationCollector implements NodeInfo{

	private String name; 
	private String type;
	private String behavior;
	private final String time;
	
	private final LinkedList <String> inputInfo;
	private final LinkedList <String> outputInfo;
	
	private List<IPinActivation> pins;
	private MokaDebugTarget target;
	private boolean complete;
	
	private final MokaEntry entry;
	
	public ActionInfo(ISemanticVisitor nodeVisitor,ILaunch Launcher) {
		
		DateFormat format = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		Date date = new Date();
		time = format.format(date);
		
		complete = false;
		
		inputInfo = new LinkedList<String>();
		outputInfo = new LinkedList<String>();
		
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
		
		target = new MokaDebugTarget(Launcher);
        
		pins = cba.pinActivations;
		
		// inputs 
		inputInfo.add(", Inputs : [ ");
		
		int n = 0;
		for(IPinActivation pin : pins)if(pin instanceof InputPinActivation) n++;
        
		ArrayList<IPinActivation> inputPins = new ArrayList<IPinActivation>(n);
		
		for(IPinActivation pin : pins)if(pin instanceof InputPinActivation)
			inputPins.add(pin);
		
		try {
		for(int i = 0; i < n; i++){
			
			PinActivationVariableAdapter adapter  = 
					new PinActivationVariableAdapter(target,inputPins.get(i));
			
				inputInfo.add("{ name : " + adapter.getName() + ", " +
						getValueInfo(adapter.getValue())+ "}");
				
				if(i < (n - 1)) inputInfo.add(", ");	
		}
		} catch (DebugException e) { e.printStackTrace(); }
		inputInfo.add(" ]");
		
		entry = new MokaEntry(this);
		
		if(isCompletable()) completeInfo(nodeVisitor);

		}

	@Override
	public boolean isComplete() { return complete; }

	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) {
     if(complete) return;
     
     // outputs
     outputInfo.add(", Outputs : [ ");
     
     int n = 0;
     for(IPinActivation pin : pins)if(pin instanceof OutputPinActivation) n++;
     
     ArrayList<IPinActivation> outputPins = new ArrayList<IPinActivation>(n);
     for(IPinActivation pin : pins)if(pin instanceof OutputPinActivation)
    	 outputPins.add(pin);
     
     try {
     
     for(int i = 0; i < n; i++) {
    	 
    	 PinActivationVariableAdapter adapter = 
    			 new PinActivationVariableAdapter(target,outputPins.get(i));
    	 
    	 outputInfo.add(getValueInfo(adapter.getValue()));
    	 
    	// String line = "{name : " + adapter.getName();
    	 
    		 

    	 
    	 if(i < (n-1)) outputInfo.add(", ");
     }
     } catch(DebugException e) { e.printStackTrace(); }
    	 
     outputInfo.add(" ]");
     
	 complete = true;	
	 
	} 
	
	@Override
	public void printSummary() {  
		
		MegamartOutput utils = MegamartOutput.getInstance();
		
		// completable nodes write all in one line
		if(isCompletable()) {
	    printPart(true);
	    String line = "";
		for(String sr : outputInfo) line = line + sr;
		utils.write(line);
		utils.write("]\n");
		entry.addInfo(line + "]");
		utils.releaseEntry(entry);
		return;
		}
		// first part
		if(!complete) {
            printPart(true);
			utils.write("]\n");
			entry.addInfo("]");
			utils.releaseEntry(entry);
			return;
		}
		// second part
		printPart(false);
		entry.addInfo("]");
		utils.write("]\n");
		utils.releaseEntry(entry);
	}

	@Override
	public boolean isCompletable() {
		if(type.contains("CallBehavior")) return false;
		return true;
	}
	private void printPart(boolean firstPart) {
		String line = type + " [ name = " + name + ", ";
		if(behavior != null) {
           line = line + "behavior = " + behavior;
           entry.addInfo("behavior = " + behavior);
		}

		if(firstPart) {
			for(String sr : inputInfo) {
				line = line + sr;
				entry.addInfo(sr);
			}
		} else {
			for(String sr : outputInfo) {
				line = line + sr;
				entry.addInfo(sr);
			}
		}
		MegamartOutput.getInstance().write(line);
	}

	@Override
	public String getName() { return name; }

	@Override
	public String getType() { return type; }

	@Override
	public List<String> getInputInfo() { return inputInfo; }

	@Override
	public List<String> getOutputInfo() { return outputInfo; }
	
	// Action has a Behavior
	public String getBehavior() { return behavior; }

	@Override
	public String getTime() { return time; }
}
