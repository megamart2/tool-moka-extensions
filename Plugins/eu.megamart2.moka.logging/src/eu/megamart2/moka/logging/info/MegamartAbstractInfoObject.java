package eu.megamart2.moka.logging.info;

public abstract class MegamartAbstractInfoObject {
	
	protected final String name;
	
	protected final String type;
	
	protected String visibility;
	
	protected String time;
	
	protected MegamartAbstractInfoObject(String name,String type,String visibility){
		this.name = name;
		this.type = type;
		this.visibility = visibility;
	}
	
	public String getName() { return name; }

	public String getType() { return type; }
	
	public String getVisibility() { return visibility; }
	
	public void setTime(String time) { this.time = time; }
	
	public String getTime() { return time; }
	
	public void setVisibility(String visibility) { 
		this.visibility = visibility; 
		}
}
