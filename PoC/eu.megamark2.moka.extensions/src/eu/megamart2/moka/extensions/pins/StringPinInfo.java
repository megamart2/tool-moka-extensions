package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;

public class StringPinInfo extends PinInfo{

	private StringValue stringValue;
	
	public StringPinInfo(PinActivation pin) {
		super(pin);
        stringValue = (StringValue)pin.heldTokens
      		   .get(0).getValue();
	}

	@Override
	protected String getValueInfo() {
		return stringValue.getValue();
	}

	@Override
	protected String getTypeInfo() {
		return "String";
	}

}
