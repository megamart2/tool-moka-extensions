package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;

public class IntegerPinInfo extends PinInfo{
	
	private IntegerValue integerValue;
	
	public IntegerPinInfo(PinActivation pin,IValue value) {
		super(pin);
        integerValue = (IntegerValue)value;
		}

	@Override
	protected String getValueInfo() { 
		return integerValue.value.toString(); 
		}

	@Override
	protected String getTypeInfo() { 
		return "Integer";
	}
	
}
