package eu.megamart2.moka.logging.mapping;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;

public class ComplexNodeFinish extends NodeElement {

	public ComplexNodeFinish(ActionActivation node) { super(node, -1); }

	public void setPlace(int place) { this.place = place; }
}
