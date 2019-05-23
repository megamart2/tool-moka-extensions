package eu.megamart2.moka.logging.behaviors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.DecisionNodeActivation;

import eu.megamart2.moka.logging.format.MegamartFormatFacade;
import eu.megamart2.moka.logging.format.MegamartInfoFormat;
import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;
import eu.megamart2.moka.logging.nodes.NodeInfo;
import eu.megamart2.moka.logging.output.MegamartOutput;
import eu.megamart2.moka.logging.output.MegamartViewOutput;

public class DecisionInfo implements NodeInfo {
	
	private String name,time,value;
	
	private final MegamartPrimitiveInfoObject info;
	
	public DecisionInfo(ISemanticVisitor visitor) {
		DecisionNodeActivation decision = (DecisionNodeActivation) visitor;
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		time = format.format(new Date());
		name = decision.node.getName();
		value = decision.running.toString();
		info = new MegamartPrimitiveInfoObject(name,"Decision node",value) {};
	}

	@Override
	public boolean isComplete() { return true; }

	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) {}

	@Override
	public boolean isOnePhase() { return true; }

	@Override
	public void printSummary() {
		MegamartOutput utils = MegamartOutput.getInstance();
		MegamartViewOutput viewOut = MegamartViewOutput.getInstance();
		
		MegamartFormatFacade consoleFormat = 
				new MegamartFormatFacade(MegamartInfoFormat.JSON_FORMAT);
		
		utils.write(consoleFormat.format(info));
		viewOut.releaseEntry(time, info);
	}

	@Override
	public String getName() { return name; }

	@Override
	public String getType() { return "Decision node"; }

	@Override
	public List<MegamartAbstractInfoObject> getInputInfo() { return null; }

	@Override
	public List<MegamartAbstractInfoObject> getOutputInfo() { return null; }

	@Override
	public String getTime() { return time; }

	@Override
	public MegamartAbstractInfoObject generateInfoObject() { return info; }
}
