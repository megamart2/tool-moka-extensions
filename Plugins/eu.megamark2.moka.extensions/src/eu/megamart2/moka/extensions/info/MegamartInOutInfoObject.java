package eu.megamart2.moka.extensions.info;

import java.util.List;

public class MegamartInOutInfoObject extends MegamartAbstractInfoObject {

	private List<MegamartAbstractInfoObject> in;
	
	private List<MegamartAbstractInfoObject> out;
	
	private final boolean completable;
	
	private boolean complete;
	
	public MegamartInOutInfoObject(String name, String type,
			List<MegamartAbstractInfoObject> in, List<MegamartAbstractInfoObject> out,
			boolean completable,boolean complete) {
		super(name, type);
		this.in = in;
		this.out = out;
		this.completable = completable;
		this.complete = complete;
	}
	
	public List<MegamartAbstractInfoObject> getInput(){ return in; }
	
	public List<MegamartAbstractInfoObject> getOutput(){ return out; }
	
	public boolean isCompletable() { return completable; }
	
	public boolean isComplete() { return complete; }
	
	public void setComplete(boolean complete) { this.complete = complete; }
}
