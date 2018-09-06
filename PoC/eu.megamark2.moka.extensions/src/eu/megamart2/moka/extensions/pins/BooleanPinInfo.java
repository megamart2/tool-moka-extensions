package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;

public class BooleanPinInfo extends PinInfo {
	
	private BooleanValue booleanValue;

	public BooleanPinInfo(PinActivation pin) {
		super(pin);
        booleanValue = (BooleanValue)pin.heldTokens
      		   .get(0).getValue();
	}

	@Override
	protected String getValueInfo() {
		return booleanValue.getValue().toString();
	}

	@Override
	protected String getTypeInfo() {
		return "Boolean";
	}

}
