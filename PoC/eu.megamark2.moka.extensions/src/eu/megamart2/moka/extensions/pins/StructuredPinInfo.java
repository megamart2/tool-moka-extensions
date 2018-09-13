package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;

public class StructuredPinInfo extends PinInfo{

	public StructuredPinInfo(PinActivation pin) {
		super(pin);
	}

	// TODO all 
	@Override
	protected String getValueInfo() {
		return "Object";
	}

	@Override
	protected String getTypeInfo() {
		return "Class";
	}

}
