package eu.megamart2.moka.extensions.utils;

public class ValueDescription {

	private String description;
	
    public ValueDescription(String type,String value) {
    	description = "type : " + type + ", value : " + value; 
    }
	public String getDescription() { return description; } 
}
