package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;

public class UnlimitednaturalPinInfo extends PinInfo {

	private UnlimitedNaturalValue naturalValue;
	
	public UnlimitednaturalPinInfo(PinActivation pin,IValue value) {
		super(pin);
		naturalValue = (UnlimitedNaturalValue)value;
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
