package eu.megamart2.moka.extensions.values;

public class MegamartPrimitiveValue extends MegamartAbstractValue {

	private final String value;
	
	public MegamartPrimitiveValue(String name, String type, String value) {
		super(name, type);
		this.value = value;
	}

	@Override
	public String getSummary() {
		return "{ name : " + name + ", type : " + type
				+ ", value : " + value + " }";
	}

}
