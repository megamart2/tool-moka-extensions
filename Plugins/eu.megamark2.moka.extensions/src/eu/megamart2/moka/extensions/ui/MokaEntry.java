package eu.megamart2.moka.extensions.ui;

import eu.megamart2.moka.extensions.nodes.NodeInfo;

public class MokaEntry {
	
	private NodeInfo info;
	
	private final String component;
	
	private String message;
	
	private final String time;
	
	public MokaEntry(NodeInfo info) {
		component = "type : " + info.getType() + ", name : " + info.getName();
		time = info.getTime();
		message = "";
	}
	
	public void addInfo(String info) {
		message += info;
	}
	
	public String getComponent() { return component; }
	
	public String getmessage() { return message; }
	
	public String getTime() { return time; }
	
}
