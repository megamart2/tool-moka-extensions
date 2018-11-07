package eu.megamart2.moka.extensions.values;

public abstract class MegamartAbstractValue {

	protected final String name;
	
	protected final String type;
	
	public MegamartAbstractValue(String name,String type) {
		this.name = name;
		this.type = type;
	}
	
	protected abstract String getSummary();
}
