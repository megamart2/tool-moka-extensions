package eu.megamart2.moka.extensions.queue;

import java.util.HashMap;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.ActivityNode;

import eu.megamart2.moka.extensions.nodes.NodeInfo;

public class InfoQueue {

	HashMap<ActivityNode,NodeInfo> map;
	
	public InfoQueue() { 
		map = new HashMap<ActivityNode,NodeInfo>(); 
		}
	
	public void addToQueue(ActivityNode key,NodeInfo value) { 
		map.put(key, value);
		}
	
	public void complete(ActivityNode key,ISemanticVisitor nodeVisitor) {
		NodeInfo nodeInfo = map.get(key);
		if(nodeInfo != null) nodeInfo.completeInfo(nodeVisitor);
	}
	public NodeInfo getNext() {
		NodeInfo result = null;
		for(ActivityNode key : map.keySet())if(map.get(key).isComplete()) {
			// TODO
		}
		return result;
	}
}
