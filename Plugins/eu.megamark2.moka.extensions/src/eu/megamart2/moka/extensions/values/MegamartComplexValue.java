package eu.megamart2.moka.extensions.values;

import java.util.List;

public class MegamartComplexValue extends MegamartAbstractValue{

	private List<MegamartAbstractValue> innerValues;
	
	public MegamartComplexValue(String name, String type, 
			List<MegamartAbstractValue> innerValues) {
		super(name, type);
		this.innerValues = innerValues;
	}

	@Override
	protected String getSummary() {
		String result = "{ name : " + name + ", type : " + type +
				", fields : [ ";
		
		for(MegamartAbstractValue value : innerValues)
			result += value.getSummary();
		// TODO check
		if(result.endsWith(",")) result.substring(0, result.length() - 1);
		
		result += " ]}";
		return result;
	}

}
