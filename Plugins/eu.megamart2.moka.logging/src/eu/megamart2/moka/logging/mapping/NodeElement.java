package eu.megamart2.moka.logging.mapping;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.uml2.uml.Node;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartInOutInfoObject;

public class NodeElement implements MapElement, Comparable<NodeElement>{
 
	private PinElement[] pins;
	
	private final int place;
	
	private final Node node;
	
	
	public NodeElement(Node node, int place) {
		this.place = place;
		this.node = node;
	}

	@Override
	public boolean isReady() {
		for(PinElement pin : pins)if(!pin.isReady())return false;
		return true;
	}

	@Override
	public void update() {
		for(PinElement pin : pins)pin.update();
	}
	
	public Node getNode() { return node; }
	
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
	    for(PinElement pin : pins) {
	    	if(pin.isInput()) in.add(pin.getInfo());
	    	else out.add(pin.getInfo());
	    }
	    return new MegamartInOutInfoObject(node.getName(),
	    		node.getClass().getName(),in,out,false,true);
	}
}
