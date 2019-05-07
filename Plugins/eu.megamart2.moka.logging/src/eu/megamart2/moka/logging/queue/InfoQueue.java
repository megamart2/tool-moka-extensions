package eu.megamart2.moka.logging.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.ActivityNode;

import eu.megamart2.moka.logging.nodes.NodeInfo;

public class InfoQueue {

	private HashMap<Object,NodeInfo> map; 
	
	public InfoQueue() { map = new HashMap<Object,NodeInfo>(); }
	
	public void addToQueue(Object key,NodeInfo value) { 
		if(value != null) map.put(key, value);
		}
	
	public void complete(Object key,ISemanticVisitor nodeVisitor) {
		NodeInfo nodeInfo = map.get(key);
		if(nodeInfo != null) nodeInfo.completeInfo(nodeVisitor);
	}
	
	public List<NodeInfo> getCompleteNodes() {
		List<NodeInfo> result = new LinkedList<NodeInfo>();
		List<Object> toRemove = new LinkedList<Object>();
		for(Object key : map.keySet())if(map.get(key).isComplete()) {
			result.add(map.get(key));
			toRemove.add(key);
		}
		for(Object key : toRemove) map.remove(key);
		return result;
	}
	
	public NodeInfo getNodeInfo(ActivityNode nodeVisitor) { 
		return map.get(nodeVisitor);
	}
}
