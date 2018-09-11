package eu.megamart2.moka.extensions.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.InputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.OutputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;

import eu.megamart2.moka.extensions.pins.BooleanPinInfo;
import eu.megamart2.moka.extensions.pins.IntegerPinInfo;
import eu.megamart2.moka.extensions.pins.PinInfo;
import eu.megamart2.moka.extensions.pins.RealPinInfo;
import eu.megamart2.moka.extensions.pins.StringPinInfo;
import eu.megamart2.moka.extensions.pins.UnlimitednaturalPinInfo;

public class InOutInfo {

	private ArrayList<PinInfo> inputs;
	private ArrayList<PinInfo> outputs;
	
	public InOutInfo(ActionActivation visitor) {
		
		inputs = new ArrayList<PinInfo>();  // create the lists
		outputs = new ArrayList<PinInfo>();
		
		List<IPinActivation> pins = visitor.pinActivations;
		for(IPinActivation pin : pins) {
			// inputs
			if(pin instanceof InputPinActivation){
				createInfoObject((PinActivation)pin,true);
			}
		}
	}
	
	public void completeInfo(ActionActivation visitor) {
		List<IPinActivation> pins = visitor.pinActivations;
		for(IPinActivation pin : pins) {
			// outputs
			if(pin instanceof OutputPinActivation){
				createInfoObject((PinActivation)pin,false);
			}
		}
	}
	
	public String getInputsInfo() {
		String info = "";
	    for(int i = 0; i < inputs.size() - 1; i++) 
	    	info = info + inputs.get(i).getInfo() + ", ";
	    if(inputs.size() > 0) info = info + inputs.get(inputs.size()-1).getInfo();
		return info;
	}
	
	public String getOutputsInfo() {
		String info = "";
		for(int i = 0; i < outputs.size()-1; i++) 
			info = info + outputs.get(i).getInfo() + ", ";
		if(outputs.size() > 0) info = info + outputs.get(outputs.size()-1).getInfo();
		return info;
	}
	
	private void createInfoObject (PinActivation pin, boolean input) {
		
		if(!pin.heldTokens.isEmpty()) {
			
			IValue value = pin.heldTokens.get(0).getValue();
			 // Boolean
			   if(value instanceof BooleanValue) {
				   addToList(new BooleanPinInfo(pin),input);
				   return;
			   }
			 // Integer
	     	   if(value instanceof IntegerValue) {
	     		   addToList(new IntegerPinInfo(pin),input);
	     		   return;
	     	   } 
	     	  // Real
	     	   if(value instanceof RealValue) {
	     		   addToList(new RealPinInfo(pin),input);
	     		   return;
	     	   }
	     	  // String
	     	   if(value instanceof StringValue) {
	     		   addToList(new StringPinInfo(pin),input);
	     		   return;
	     	   }
	     	   if(value instanceof UnlimitedNaturalValue) {
	     		   addToList(new UnlimitednaturalPinInfo(pin),input);
	     		   return;
	     	   }
	     	  // TODO other types 
		}
	}
	private void addToList(PinInfo pinInfo,boolean input) {
	  if(input) inputs.add(pinInfo);
	  else outputs.add(pinInfo);		 
	}
}
