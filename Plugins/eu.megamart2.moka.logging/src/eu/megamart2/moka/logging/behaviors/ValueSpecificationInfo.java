package eu.megamart2.moka.logging.behaviors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.ValueSpecificationActionImpl;

import eu.megamart2.moka.logging.format.MegamartFormatFacade;
import eu.megamart2.moka.logging.format.MegamartInfoFormat;
import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartInOutInfoObject;
import eu.megamart2.moka.logging.nodes.NodeInfo;
import eu.megamart2.moka.logging.output.MegamartOutput;
import eu.megamart2.moka.logging.output.MegamartViewOutput;

@SuppressWarnings("restriction")
public class ValueSpecificationInfo extends ValueInformationCollector implements NodeInfo {

	private ValueSpecificationActionActivation activation;
	
	private MegamartInOutInfoObject info;
	
	private String name;
	
	private String time;
	
	public ValueSpecificationInfo(ISemanticVisitor nodeVisitor,ILaunch launcher) {
			
		  DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		  time = dateFormat.format(new Date());
		  
		  List<MegamartAbstractInfoObject> output = 
				   new LinkedList<MegamartAbstractInfoObject>();
		
			activation = (ValueSpecificationActionActivation)nodeVisitor;
			
			// general info
			name = "";
		    if(activation.getNode().isSetName()) 
		    	name = activation.getNode().getName();
		    
                    IPinActivation pin = activation.pinActivations.get(0);
   				 ValueSpecification valueSpe  = 
						 ((ValueSpecificationActionImpl)pin.getNode().eContainer()).getValue();
					      output.add(generateValue(valueSpe));
						
				info = new MegamartInOutInfoObject(name,"Value specification",
						new LinkedList<MegamartAbstractInfoObject>(),output,true,true);			
			// TODO type
	}

	public String getName() { return name; }

	public String getType() { return "Value specification"; }

	@Override
	public boolean isComplete() { return true; }

	@Override
	public void completeInfo(ISemanticVisitor nodeVisitor) { 
		// Unnecessary 
		}

	@Override
	public boolean isOnePhase() { return true; }

	@Override
	public void printSummary() {
		MegamartFormatFacade format = 
				new MegamartFormatFacade(MegamartInfoFormat.JSON_FORMAT);
		format.setInnerFormat(new MegamartInfoFormat("{ type = %t, value = %v }"));
	   String line = format.format(info);
       MegamartOutput.getInstance().write(line);
       MegamartOutput.getInstance().write("\n");
       MegamartViewOutput.getInstance().releaseEntry(time, info);
	}

	@Override
	public List<MegamartAbstractInfoObject> getInputInfo() { 
		return info.getInput();
	}

	@Override
	public List<MegamartAbstractInfoObject> getOutputInfo() {
		return info.getOutput();
	}

	@Override
	public String getTime() { return time; }

	@Override
	public MegamartAbstractInfoObject generateInfoObject() { return info; }

}
