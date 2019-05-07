package eu.megamart2.moka.logging.behaviors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.TransitionActivationWrapper;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.nodes.NodeInfo;

public class StateTransitionInfo implements NodeInfo {
	
	protected TransitionActivationWrapper wrapper;
	
	protected String time;

	public StateTransitionInfo(TransitionActivationWrapper wrapper) {
		this.wrapper = wrapper;
		
		DateFormat format = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		Date date = new Date();
		time = format.format(date);
	}
	
	@Override
	public boolean isComplete() { return true; }

	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) {
		// do nothing
	}

	@Override
	public boolean isOnePhase() { return true; }

	@Override
	public void printSummary() {
		StringBuilder builder = new StringBuilder();
		builder.append(wrapper.getNode().getName());
		builder.append(" transition between states from ");
		builder.append(wrapper.getSourceActivation().getNode().getName());
		builder.append(" to ");
		builder.append(wrapper.getTargetActivation().getNode().getName());
		if(wrapper.getTriggeringEventOccurrence()!= null) {
			builder.append(", trigger : ");
			builder.append(wrapper.getTriggeringEventOccurrence().toString());
		} else builder.append(", no trigger");
		System.out.println(builder.toString());
		// TODO view entry
	}

	@Override
	public String getName() {
		return wrapper.getNode().getName();
	}

	@Override
	public String getType() { return " State transition "; }

	@Override
	public List<MegamartAbstractInfoObject> getInputInfo() {
		return null;
	}

	@Override
	public List<MegamartAbstractInfoObject> getOutputInfo() {
		return null;
	}

	@Override
	public String getTime() {
		return time;
	}

	@Override
	public MegamartAbstractInfoObject generateInfoObject() {
		// TODO Auto-generated method stub
		return null;
	}
}
