package eu.megamart2.moka.logging.behaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;

public class FinishComplexActionInfo extends ActionInfo {

	public FinishComplexActionInfo(ISemanticVisitor nodeVisitor, ILaunch Launcher) {
		super(nodeVisitor, Launcher);
		
		// TODO remove logs
		System.out.println();
		System.out.println("-----------------------");
		System.out.println(" ***** Oh no ! THIS IS THE END");
		System.out.println("-----------------------");
		System.out.println();
	}
	
	@Override
	public List<MegamartAbstractInfoObject> getInputInfo() {
		return new ArrayList<MegamartAbstractInfoObject>(1);
	}
}
