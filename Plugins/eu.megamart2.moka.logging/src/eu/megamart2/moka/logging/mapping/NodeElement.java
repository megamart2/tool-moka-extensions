package eu.megamart2.moka.logging.mapping;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartInOutInfoObject;

public class NodeElement implements MapElement, Comparable<NodeElement>{
 
	private List<PinElement> pins;
	
	private final int place;
	
	private ActionActivation node;
	
	protected final String time;
	
	public NodeElement(ActionActivation node, int place) {
		this.place = place;
		this.node = node;
		List<IPinActivation> pinActivations = node.pinActivations;
		if(pinActivations != null && !pinActivations.isEmpty()) {
		pins = new LinkedList<PinElement>();
		ModelMap modelMap = ModelMap.getInstance();
		for(IPinActivation activation : pinActivations) {
			PinElement element = new PinElement(activation);
			pins.add(element);
		    modelMap.addPin(element);
		}
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		time = format.format(new Date());
	}
	
	protected NodeElement(int place) {
		this.place = place;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		time = format.format(new Date());
	}
	
	public String getTime() { return time; }

	@Override
	public boolean isReady() {
		if(pins == null) return true;
		for(PinElement pin : pins)if(pin == null || !pin.isReady())return false;
		return true;
	}

	@Override
	public void update() {
	    List<IPinActivation> activations = node.pinActivations;
	    if((pins == null || pins.isEmpty()) && 
	    		(activations == null || activations.isEmpty())) return;
	    
		if(pins.isEmpty()) return;
		for(PinElement pin : pins)if(pin != null)pin.update();
	}
	
	public Object getNode() { return node; }
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof NodeElement)
			return node.equals(((NodeElement) other).node);
		return false;
	}

	@Override
	public int compareTo(NodeElement o) { return place - o.place; }
	
	public MegamartAbstractInfoObject getInfoObject() {
		List<MegamartAbstractInfoObject> in = new LinkedList<MegamartAbstractInfoObject>();
	    List<MegamartAbstractInfoObject> out = new LinkedList<MegamartAbstractInfoObject>();
	    if(pins != null)for(PinElement pin : pins) {
	    	if(pin.isInput()) in.add(pin.getInfo());
	    	else out.add(pin.getInfo());
	    }
	    MegamartAbstractInfoObject result = new MegamartInOutInfoObject(node.getNode().getName(),
	    		node.getClass().getName(),in,out,false,true);
	    result.setTime(time);
	    return result;
	}
}
