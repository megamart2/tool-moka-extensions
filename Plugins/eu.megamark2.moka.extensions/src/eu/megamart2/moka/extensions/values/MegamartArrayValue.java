package eu.megamart2.moka.extensions.values;

import java.util.List;

public class MegamartArrayValue extends MegamartComplexValue {

	public MegamartArrayValue(String name, String type,
			List<MegamartAbstractValue> innerValues) {
		super(name, type, innerValues);
		type += "[]";
	}
	@Override
	public String getSummary() {
		return super.getSummary().replaceAll(", fields","");
	}
}
