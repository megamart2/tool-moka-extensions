package eu.megamart2.moka.logging.info;

public class MegamartPrimitiveInfoObject extends MegamartAbstractInfoObject {

	private String value;
	
	public MegamartPrimitiveInfoObject(String name,String type,String value) {
		this(name,type,value,null);
	}
	
	public MegamartPrimitiveInfoObject(String name, String type,String value,String visibility) {
		super(name, type, visibility);
		this.value = value;
	}
	
	public String getValue() { return value; }
}
