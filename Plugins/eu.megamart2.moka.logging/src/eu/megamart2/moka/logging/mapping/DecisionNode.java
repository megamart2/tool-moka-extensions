package eu.megamart2.moka.logging.mapping;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.DecisionNodeActivation;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;

public class DecisionNode extends NodeElement {

	private final DecisionNodeActivation decision;
	
	public DecisionNode(DecisionNodeActivation decision, int place) {
		super(place);
		this.decision = decision;
		decision.getNode().getName();
	}
	
	@Override
	public boolean isReady() { return true; }
	
	@Override
	public void update() {}
	
	@Override
	public MegamartAbstractInfoObject  getInfoObject() {
		MegamartAbstractInfoObject result = new MegamartPrimitiveInfoObject(
				decision.getNode().getName(),"Decision node","-");
		result.setTime(time);
		return result;
	}
	
	@Override
    public boolean equals(Object other) {
		if(other instanceof DecisionNode) {
			return ((DecisionNode) other).decision.equals(decision);
		}
		return false;
	}
}
