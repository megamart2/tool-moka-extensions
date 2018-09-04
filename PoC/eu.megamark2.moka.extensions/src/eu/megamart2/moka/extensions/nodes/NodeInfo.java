package eu.megamart2.moka.extensions.nodes;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_ReadSelfActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallBehaviorActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.InputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.StartObjectBehaviorActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ReadStructuralFeatureActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ValueSpecificationActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ForkNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Actions.BasicActions.ObjectNodeActivationWrapper;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.internal.impl.CallBehaviorActionImpl;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralIntegerImpl;
import org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl;
import org.eclipse.uml2.uml.internal.impl.PropertyImpl;
import org.eclipse.uml2.uml.internal.impl.ReadStructuralFeatureActionImpl;
import org.eclipse.uml2.uml.internal.impl.ValueSpecificationActionImpl;

import eu.megamart2.moka.extensions.utils.MegamartUtils;
import eu.megamart2.moka.extensions.utils.StartControl;

@SuppressWarnings("restriction")
public class NodeInfo {
	
	private LinkedList<String> summary;
	
	private final ISemanticVisitor nodeVisitor;
	
	private StartControl control;
	
	public NodeInfo(ISemanticVisitor nodeVisitor,StartControl control) {
		this.nodeVisitor = nodeVisitor;
		this.control = control;
		summary = new LinkedList<String>();
        computeSummary();
	}

    private void computeSummary() {
    	if(nodeVisitor instanceof StartObjectBehaviorActionActivation) {

			summary.add("**** Start Object Behaviour ****");
			summary.add("");
			control.setStarted(true);
			return;
		}
		if(!control.getStarted()) return;
		if(nodeVisitor instanceof CS_ReadSelfActionActivation) {
			summary.add(">> Read self action activation \n");
			((CS_ReadSelfActionActivation) nodeVisitor).getNode();
			return;
		}
		String sr;
		if(nodeVisitor instanceof ReadStructuralFeatureActionActivation) {
			summary.add(">> Read structural feature");
			ReadStructuralFeatureActionImpl node = 
					(ReadStructuralFeatureActionImpl)((ReadStructuralFeatureActionActivation)nodeVisitor).node;
			if(node.isSetName()) summary.add("   Name : " + node.getName());
			if(node.getStructuralFeature() instanceof PropertyImpl) {
				PropertyImpl pr = (PropertyImpl) node.getStructuralFeature();
				summary.add("     Feature");
				if(pr.isSetName()) summary.add("     Name : " + pr.getName());
		        if(pr.getType() instanceof PrimitiveTypeImpl) {
		        	PrimitiveTypeImpl pri = (PrimitiveTypeImpl) pr.getType();
		        	if(pri.isSetName()) summary.add(" Type : " + pri.getName());
		        }
	            if(pr.eContainer() instanceof ClassImpl) { 
	            	ClassImpl cl = (ClassImpl)pr.eContainer();
	            	if(cl.isSetName())summary.add("     In class : " + cl.getName());
			}   
			return;
		}
			return;
		}
		if(nodeVisitor instanceof ValueSpecificationActionActivation) {
			summary.add(">> Value Specification ");
			ValueSpecificationActionImpl vs = (ValueSpecificationActionImpl) 
					((ValueSpecificationActionActivation) nodeVisitor).node;
			if(vs.isSetName()) summary.add("   Name : " + vs.getName());
			if(vs.getValue() instanceof LiteralIntegerImpl) {
				summary.add("   Type : Integer");
				summary.add("   Value : " + 
				String.valueOf(((LiteralIntegerImpl) vs.getValue()).getValue()));
				summary.add("");
				return;
			}
			// TODO complete value cases
			return;
		}
		if(nodeVisitor instanceof ActivityEdgeInstance) {
			ActivityEdge edge = ((ActivityEdgeInstance) nodeVisitor).edge;
			if(edge == null) {
				summary.add(">> Edge \n");
				return;
			}
			sr = edge.getName();
			summary.add(">> " + sr);
			summary.add("");
			return;
			}
		if(nodeVisitor instanceof ForkNodeActivation) {
			summary.add(">> Fork activation \n");
			return;
		}
		if(nodeVisitor instanceof InputPinActivation) {
			summary.add(">> InputPinActivation \n");
			return;
		}
		if(nodeVisitor instanceof ObjectNodeActivationWrapper) {
			summary.add(">> Object node activation wrapper \n");
			return;
		}
		if(nodeVisitor instanceof CallBehaviorActionActivation) {
			summary.add(">> Call Behavior ");
			CallBehaviorActionActivation cba = ((CallBehaviorActionActivation)nodeVisitor);
			CallBehaviorActionImpl cb = 
					(CallBehaviorActionImpl)cba.getNode();
			if(cb.isSetName()) summary.add("   Name : " + cb.getName());
			if(cb.getBehavior().getName() != null) summary.add("   Behavior : " + cb.getBehavior().getName());
			// get input parameters
		
           List<Parameter> parameters = cb.inputParameters();
           summary.add("   Input : ");
           String line = "";
		   for(Parameter parameter : parameters) {
			   if(parameter.isSetName())line = "   " + parameter.getName() + " / ";
			   line = line + "Type : " + parameter.getType().getName() + " / ";
               // TODO look for values
               summary.add(line);
		   }
			}
			/*
			if(!cb.getArguments().isEmpty()) {
				summary.add("    Input :");
				String line = "";
				for(InputPin pin : cb.getArguments()) {
					if(pin.isSetName()) line = line + pin.getName() + "  / ";
					if(pin.getType() instanceof PrimitiveTypeImpl) {
						PrimitiveTypeImpl impl = (PrimitiveTypeImpl)pin.getType();
						if(impl.isSetName()) line = line + "Type : " + impl.getName() + " / ";
					if(pin.getUpperBound() instanceof LiteralIntegerImpl) 
						line = line + "value : " + pin.getUpperBound().integerValue();
					}
					line = line + "\n";
				}
				summary.add(line);
			}*/
		summary.add("\n");
			return;
		}
    public void printSummary(MegamartUtils utils) {
    	for(String line : summary) utils.writeLine(line);
    }
}
