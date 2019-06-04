package eu.megamart2.moka.logging.mapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;

public class ModelMap {

	private static ModelMap INSTANCE;

	private Map<IPinActivation,PinElement> pinMap;
	
	private List<NodeElement> nodes;
	
	private ModelMap() { reset(); }
	
	public static ModelMap getInstance() {
		if(INSTANCE == null) INSTANCE = new ModelMap();
		return INSTANCE;
	}
	
	public void reset() {
		pinMap = new HashMap<IPinActivation,PinElement>();
		nodes = new LinkedList<NodeElement>();
	}
	
	public void addNode(NodeElement node) {
		for(NodeElement aNode : nodes)if(aNode.equals(node)) return;
		nodes.add(node);
		Collections.sort(nodes);
	}
	
	public void removeNode(NodeElement node) { nodes.remove(node); }
	
	public void update() {
		for(NodeElement node : nodes)node.update();
	}
	
	public void addPin(PinElement pin) { pinMap.put(pin.getActivation(),pin); }
	
	public List<MegamartAbstractInfoObject> getCompleteNodes(){
		List<MegamartAbstractInfoObject> result = new LinkedList<MegamartAbstractInfoObject>();
		List<NodeElement> toRemove = new LinkedList<NodeElement>();
	    for(NodeElement element : nodes) {
	    	if(element.isReady()) {
	    	result.add(element.getInfoObject());
	    	toRemove.add(element);
	    	}
	    	else break;
	    }
	    for(NodeElement element : toRemove) nodes.remove(element);
		return result;
	}
	
	public List<MegamartAbstractInfoObject> getAllNodes(){
		List<MegamartAbstractInfoObject> result = new LinkedList<MegamartAbstractInfoObject>();
		List<NodeElement> toRemove = new LinkedList<NodeElement>();
	    for(NodeElement element : nodes) {
	    	result.add(element.getInfoObject());
	    	toRemove.add(element);
	    	}
	    for(NodeElement element : toRemove) nodes.remove(element);
		return result;
	}
	
	public PinElement getPinElement(IPinActivation activation) {
		return pinMap.get(activation);
	}
}
