package eu.megamart2.moka.extensions.info;

public abstract class MegamartAbstractInfoObject {
	
	protected final String name;
	
	protected final String type;
	
	protected MegamartAbstractInfoObject(String name,String type){
		this.name = name;
		this.type = type;
	}
	
	public String getName() { return name; }

	public String getType() { return type; }
}
