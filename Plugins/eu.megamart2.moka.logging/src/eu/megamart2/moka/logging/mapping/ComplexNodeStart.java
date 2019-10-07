package eu.megamart2.moka.logging.mapping;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;

public class ComplexNodeStart extends NodeElement {

	public ComplexNodeStart(ActionActivation node, int place) {
		super(node, place);	
	}
	
	@Override
	public boolean isReady() { return true; }
	
	public ComplexNodeFinish getFinishInfo() {
		return new ComplexNodeFinish(node);
	}
}
