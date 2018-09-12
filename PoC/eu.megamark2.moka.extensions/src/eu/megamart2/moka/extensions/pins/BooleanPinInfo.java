package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;

public class BooleanPinInfo extends PinInfo {
	
	private BooleanValue booleanValue;

	public BooleanPinInfo(PinActivation pin,IValue value) {
		super(pin);
        booleanValue = (BooleanValue)value;
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
