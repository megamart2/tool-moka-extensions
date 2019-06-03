package eu.megamart2.moka.logging.mapping;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.InputPinActivation;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;

public class PinElement implements MapElement{
	
	private IActivityNodeActivation target,source;
	
	private final IPinActivation activation;
	
	private MegamartAbstractInfoObject object;
	
	private boolean ready; // if true the pin is updated
	
	public PinElement(IPinActivation activation) {
		this.activation = activation;
		List<IActivityEdgeInstance> edges = activation.getOutgoingEdges();
	    if(!edges.isEmpty()) {
	    	target = edges.get(0).getTarget();
	    	source = edges.get(0).getSource();
	    }
	}
	
	public boolean isInput() {
		return activation instanceof InputPinActivation;
	}
	
	public boolean targetIsPin() { return target instanceof IPinActivation; }
	
	public IActivityNodeActivation getTarget() { return target; }
	
	public boolean sourceIsPin() { return source instanceof IPinActivation; }
	
	public IActivityNodeActivation getSource() { return source; }

	@Override
	public boolean isReady() {
		if(object == null) ready = false;
		return ready;
	}

	@Override
	public void update() {
		List<IToken> tokens = activation.getTokens();
		if(tokens.isEmpty()) {
			ready = false;
			return;
		}
		IValue v = tokens.get(0).getValue();
		InfoFactory infoFactory = new InfoFactory();
		object = infoFactory.createInfoObject(v,activation.getNode().getName());
	    if(object != null) {
	    	ready = true;
	        if(source instanceof IPinActivation) ModelMap.getInstance()
	        .getPinElement((IPinActivation)source).update(object);
	        if(target instanceof IPinActivation) {
	         ModelMap.getInstance()
	        .getPinElement((IPinActivation)target);
	        }
	        
	    } else ready = false;
	}
	
	private void update(MegamartAbstractInfoObject object) {
		this.object = object;
		ready = true;
	}
	
	public IPinActivation getActivation() { return activation; }
	
	public MegamartAbstractInfoObject getInfo() { return object; }
	
	@Override
	public boolean equals(Object element) {
		if(element instanceof PinElement) 
			return this.activation.equals(
					((PinElement) element).activation);
		return false;
	}
}
