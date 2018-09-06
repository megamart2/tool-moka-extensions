package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;

public class UnlimitednaturalPinInfo extends PinInfo {

	private UnlimitedNaturalValue naturalValue;
	
	public UnlimitednaturalPinInfo(PinActivation pin) {
		super(pin);
		naturalValue = (UnlimitedNaturalValue)pin.heldTokens.get(0).getValue();
	}

	@Override
	protected String getValueInfo() {
		return naturalValue.getValue().toString();
	}

	@Override
	protected String getTypeInfo() {
		return "Unlimited Natural";
	}

	
	
}
