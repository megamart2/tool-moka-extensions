package eu.megamart2.moka.extensions.nodes;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;

public interface NodeInfo {
	
	public boolean isComplete();
	
	public void completeInfo(ISemanticVisitor nodeVisitor);	
	
	public boolean isCompletable(); 
	
	public void printSummary();
	
	public String getName();
	
	public String getType();
	
	public List<String> getInputInfo();
	
	public List<String> getOutputInfo();
	
	public String getTime();
}
