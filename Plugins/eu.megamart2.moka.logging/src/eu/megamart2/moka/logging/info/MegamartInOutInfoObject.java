package eu.megamart2.moka.logging.info;

import java.util.LinkedList;
import java.util.List;

public class MegamartInOutInfoObject extends MegamartAbstractInfoObject {

	private List<MegamartAbstractInfoObject> in;
	
	private List<MegamartAbstractInfoObject> out;
	
	private final boolean onePhase;
	
	private boolean complete;
	
	public MegamartInOutInfoObject(String name, String type,
			List<MegamartAbstractInfoObject> in, List<MegamartAbstractInfoObject> out,
			boolean completable,boolean complete) {
		this(name,type,in,out,completable,complete,null);
	}
	
	public MegamartInOutInfoObject(String name, String type,
			List<MegamartAbstractInfoObject> in, List<MegamartAbstractInfoObject> out,
			boolean completable,boolean complete,String visibility) {
		super(name, type,visibility);
		this.in = in;
		this.out = out;
		this.onePhase = completable;
		this.complete = complete;
	}
	
	public List<MegamartAbstractInfoObject> getInput(){ 
		if(in == null) return new LinkedList<MegamartAbstractInfoObject>(); // returns empty list
		return in; 
		}
	
	public List<MegamartAbstractInfoObject> getOutput(){ 
		if(out == null) return new LinkedList<MegamartAbstractInfoObject>(); // returns empty list
		return out; 
		}
	
	public boolean isOnePhase() { return onePhase; }
	
	public boolean isComplete() { return complete; }
	
	public void setComplete(boolean complete) { this.complete = complete; }
}
