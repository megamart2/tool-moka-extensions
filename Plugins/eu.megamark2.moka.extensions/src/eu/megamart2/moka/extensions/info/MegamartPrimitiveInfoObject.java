package eu.megamart2.moka.extensions.info;

public class MegamartPrimitiveInfoObject extends MegamartAbstractInfoObject {

	private String value;
	
	public MegamartPrimitiveInfoObject(String name, String type,String value) {
		super(name, type);
		this.value = value;
	}
	
	public String getValue() { return value; }
}
