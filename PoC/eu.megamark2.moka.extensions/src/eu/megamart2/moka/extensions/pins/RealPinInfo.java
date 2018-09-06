package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;

public class RealPinInfo extends PinInfo {

	private RealValue realValue;
	
	public RealPinInfo(PinActivation pin) {
		super(pin);
        realValue = (RealValue)pin.heldTokens.get(0).getValue();
	}

	@Override
	protected String getValueInfo() {
		return realValue.getValue().toString();
	}

	@Override
	protected String getTypeInfo() {
		return "Real";
	}
	
	
}
