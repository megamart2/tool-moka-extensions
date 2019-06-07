package eu.megamart2.moka.logging.mapping;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.StateMachineSemanticVisitor;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;

public class StateElement extends NodeElement {
	
	private final StateMachineSemanticVisitor state;

	public StateElement(StateMachineSemanticVisitor state,int place) {
		super(place);
		this.state = state;
	}
	
	@Override
	public MegamartAbstractInfoObject getInfoObject() {
		String type = state.getClass().getName();
		if(type.contains("."))type = type.substring(type.lastIndexOf(".")+1);
		MegamartAbstractInfoObject result = new MegamartPrimitiveInfoObject(
				state.getNode().getName(),"State machine action",type);
		result.setTime(time);
		return result;
	}
	
	@Override
	public boolean isReady() { return true; }
	
	@Override
	public void update() {}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof StateElement) {
			return state.equals(((StateElement) other).state);
		}
		return false;
	}
}
