package eu.megamart2.moka.extensions.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.InputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.OutputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.LiteralBooleanImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralIntegerImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralRealImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralStringImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralUnlimitedNaturalImpl;
import org.eclipse.uml2.uml.internal.impl.ValueSpecificationActionImpl;

import eu.megamart2.moka.extensions.pins.BooleanPinInfo;
import eu.megamart2.moka.extensions.pins.IntegerPinInfo;
import eu.megamart2.moka.extensions.pins.PinInfo;
import eu.megamart2.moka.extensions.pins.RealPinInfo;
import eu.megamart2.moka.extensions.pins.StringPinInfo;
import eu.megamart2.moka.extensions.pins.StructuredPinInfo;
import eu.megamart2.moka.extensions.pins.UnlimitednaturalPinInfo;

@SuppressWarnings("restriction")
public class InOutInfo {

	private ArrayList<PinInfo> inputs;
	private ArrayList<PinInfo> outputs;
	
	private boolean stop;     // for internal use
	private boolean complete;
	
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
		complete = false;
	}
	
	public void completeInfo(ActionActivation visitor) {
		if(complete) return; // only one call per inOutInfoObject
		List<IPinActivation> pins = visitor.pinActivations;
		for(IPinActivation pin : pins) {
			// outputs
			if(pin instanceof OutputPinActivation){
				createInfoObject((PinActivation)pin,false);
			}
		}
		complete = true;
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
		
		if(!pin.heldTokens.isEmpty() 
				|| pin.getActionActivation() instanceof ValueSpecificationActionActivation) { 
			// TODO condition
			
			IValue value = findValue(pin);
			
			if(stop) return; // control step
			
			 // Boolean
			   if(value instanceof BooleanValue) {
				   addToList(new BooleanPinInfo(pin,value),input);
				   return;
			   }
			 // Integer
	     	   if(value instanceof IntegerValue) {
	     		   addToList(new IntegerPinInfo(pin,value),input);
	     		   return;
	     	   } 
	     	  // Real
	     	   if(value instanceof RealValue) {
	     		   addToList(new RealPinInfo(pin,value),input);
	     		   return;
	     	   }
	     	  // String
	     	   if(value instanceof StringValue) {
	     		   addToList(new StringPinInfo(pin,value),input);
	     		   return;
	     	   }
	     	   if(value instanceof UnlimitedNaturalValue) {
	     		   addToList(new UnlimitednaturalPinInfo(pin,value),input);
	     		   return;
	     	   }
	     	   addToList(new StructuredPinInfo(pin),input);
	     	  // TODO other types 
		}
	}

	private void addToList(PinInfo pinInfo,boolean input) {
	  if(input) inputs.add(pinInfo);
	  else outputs.add(pinInfo);		 
	}
	private IValue findValue(PinActivation pin) {
		
		IValue value = null;
		
		if(!pin.heldTokens.isEmpty()) value = pin.heldTokens.get(0).getValue(); 
		
		if(pin.getActionActivation() instanceof ValueSpecificationActionActivation)
			if(pin.getNode().eContainer() instanceof ValueSpecificationActionImpl) {
				
				 ValueSpecification valueSpe  = 
						 ((ValueSpecificationActionImpl)pin.getNode().eContainer()).getValue();
				 value = generateValue(valueSpe);
			}
		
		stop = (value == null);
		return value;
	}
	private IValue generateValue(ValueSpecification specification) {
		
		if(specification instanceof LiteralBooleanImpl) {
			boolean boo = ((LiteralBooleanImpl)specification).booleanValue();
			BooleanValue result = new BooleanValue();
			result.setValue(boo);
			return result;
		}
		
		if(specification instanceof LiteralIntegerImpl) {
			int v = ((LiteralIntegerImpl)specification).getValue();
	        IntegerValue result = new IntegerValue();
	        result.setValue(v);
	        return result;
		}
		
		if(specification instanceof LiteralRealImpl) {
			double v = ((LiteralRealImpl)specification).getValue();
			RealValue result = new RealValue();
			result.setValue(v);
			return result;
		}
		
		if(specification instanceof LiteralStringImpl) {
			String v = ((LiteralStringImpl)specification).getValue();
			StringValue result = new StringValue();
			result.setValue(v);
			return result;
		}
		
		if(specification instanceof LiteralUnlimitedNaturalImpl) {
			int v = ((LiteralUnlimitedNaturalImpl)specification).integerValue();
	        UnlimitedNaturalValue result = new UnlimitedNaturalValue();
	        result.setValue(v);
	        return result;
		}
		return null;
	}
}
