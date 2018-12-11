package eu.megamart2.moka.logging.behaviors;

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

import eu.megamart2.moka.logging.format.MegamartFormatFacade;
import eu.megamart2.moka.logging.format.MegamartInfoFormat;
import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartInOutInfoObject;
import eu.megamart2.moka.logging.nodes.NodeInfo;
import eu.megamart2.moka.logging.output.MegamartOutput;
import eu.megamart2.moka.logging.output.MegamartViewOutput;

@SuppressWarnings("restriction")
public class ActionInfo extends ValueInformationCollector implements NodeInfo{

	private String name; 
	private String type;
	private String behavior;
	private final String time;
	
	private final MegamartInOutInfoObject info;
	
	private List<IPinActivation> pins;
	private MokaDebugTarget target;
	
	public ActionInfo(ISemanticVisitor nodeVisitor,ILaunch Launcher) {
		
		DateFormat format = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		Date date = new Date();
		time = format.format(date);
		
		List<MegamartAbstractInfoObject> inputInfo = 
				new LinkedList<MegamartAbstractInfoObject>();
		
		List<MegamartAbstractInfoObject> outputInfo = 
				new LinkedList<MegamartAbstractInfoObject>();
		
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
		int n = 0;
		for(IPinActivation pin : pins)if(pin instanceof InputPinActivation) n++;
        
		ArrayList<IPinActivation> inputPins = new ArrayList<IPinActivation>(n);
		
		for(IPinActivation pin : pins)if(pin instanceof InputPinActivation)
			inputPins.add(pin);
		
		try {
		for(int i = 0; i < n; i++){
			
			PinActivationVariableAdapter adapter  = 
					new PinActivationVariableAdapter(target,inputPins.get(i));
			
				inputInfo.add(getValueInfo(adapter.getValue(),adapter.getName()));
					
		}
		} catch (DebugException e) { e.printStackTrace(); }
		
		info = new MegamartInOutInfoObject(name,type,inputInfo,outputInfo,
				isCompletable(),false);
		
		if(isCompletable()) completeInfo(nodeVisitor);
        
		}

	@Override
	public boolean isComplete() { return info.isComplete(); }

	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) {
     if(info.isComplete()) return;
     
     // outputs
     
     int n = 0;
     for(IPinActivation pin : pins)if(pin instanceof OutputPinActivation) n++;
     
     ArrayList<IPinActivation> outputPins = new ArrayList<IPinActivation>(n);
     for(IPinActivation pin : pins)if(pin instanceof OutputPinActivation)
    	 outputPins.add(pin);
     
     try {
     
     for(int i = 0; i < n; i++) {
    	 
    	 PinActivationVariableAdapter adapter = 
    			 new PinActivationVariableAdapter(target,outputPins.get(i));
    	 
    	 info.getOutput().add(getValueInfo(adapter.getValue(),adapter.getName()));
    	
     }
     } catch(DebugException e) { e.printStackTrace(); }
    	 
     info.setComplete(true);
	 
	} 
	
	@Override
	public void printSummary() {  
		
		MegamartOutput utils = MegamartOutput.getInstance();
		MegamartViewOutput viewOut = MegamartViewOutput.getInstance();
		
		MegamartFormatFacade consoleFormat = 
				new MegamartFormatFacade(MegamartInfoFormat.JSON_FORMAT);
		
		utils.write(consoleFormat.format(info));
		viewOut.releaseEntry(time, info);
	}

	@Override
	public boolean isCompletable() {
		if(type.contains("CallBehavior")) return false;
		return true;
	}

	@Override
	public String getName() { return name; }

	@Override
	public String getType() { return type; }

	@Override
	public List<MegamartAbstractInfoObject> getInputInfo() { return info.getInput(); }

	@Override
	public List<MegamartAbstractInfoObject> getOutputInfo() { return info.getOutput(); }
	
	// Action has a Behavior
	public String getBehavior() { return behavior; }

	@Override
	public String getTime() { return time; }

	@Override
	public MegamartAbstractInfoObject generateInfoObject() {
	 return info;
	}
}
