package eu.megamart2.moka.extensions.nodes;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public interface NodeInfo {

	public String getName();
	
	public String getType();
	
	public String getBehavior();
	
	public String getInputInfo();
	
	public String getOutputInfo();
	
	public boolean isComplete();
	
	public void completeInfo(ISemanticVisitor nodeVisitor);	
}