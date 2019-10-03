package eu.megamart2.moka.logging.behaviors;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public class StartComplexActionInfo extends ActionInfo {
	
	private final ISemanticVisitor nodeVisitor;
	
	private final ILaunch launcher;

	public StartComplexActionInfo(ISemanticVisitor nodeVisitor, ILaunch Launcher) {
		super(nodeVisitor, Launcher);
		this.nodeVisitor = nodeVisitor;
		this.launcher = Launcher;
		
		// TODO remove logs
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println(" >>>>>>>    START CREATED");
		System.out.println("---------------------------------------------");
		System.out.println();
	}
	
	@Override
	public boolean isOnePhase() { return true; }
	
	@Override
	public boolean isComplete() { return true; }
	
	public FinishComplexActionInfo getFinishInfo() {
		return new FinishComplexActionInfo(nodeVisitor,launcher);
	}
}