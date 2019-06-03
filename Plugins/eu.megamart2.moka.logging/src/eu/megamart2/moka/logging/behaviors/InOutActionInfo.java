package eu.megamart2.moka.logging.behaviors;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public class InOutActionInfo extends ActionInfo {

	public InOutActionInfo(ISemanticVisitor nodeVisitor, ILaunch Launcher) {
		super(nodeVisitor, Launcher);
	}

}
