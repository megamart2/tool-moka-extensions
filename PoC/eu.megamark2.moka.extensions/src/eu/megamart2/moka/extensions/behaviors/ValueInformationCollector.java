package eu.megamart2.moka.extensions.behaviors;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.DefaultValueAdapter;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.ObjectTokenValueAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.LiteralBooleanImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralIntegerImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralRealImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralStringImpl;
import org.eclipse.uml2.uml.internal.impl.LiteralUnlimitedNaturalImpl;

import eu.megamart2.moka.extensions.utils.ValueDescription;

@SuppressWarnings("restriction")
public abstract class ValueInformationCollector {
	
	 protected String getValueInfo(IValue value) {
		 
		 if(value instanceof ObjectTokenValueAdapter) {
			 IToken token = ((ObjectTokenValueAdapter)value).getAdapted();
			 
			 // boolean
			 if(token.getValue() instanceof BooleanValue) {
				 return " type : Boolean, value : "
						 + String.valueOf(((BooleanValue)token.getValue()).value);
			 }
			 
			 // integer
			 if(token.getValue() instanceof IntegerValue) {
				 return " type : Integer, value : " 
			 + String.valueOf((((IntegerValue)token.getValue()).value.intValue()));
			 }
			 
			 // real
			 if(token.getValue() instanceof RealValue) {
				 return " type : Real, value : "
						 + String.valueOf(((RealValue)token.getValue()).getValue());
			 }
			 
			 // string
			 if(token.getValue() instanceof StringValue) {
				 return " type String, value : "
						 + ((StringValue)token.getValue()).getValue();
			 }
			 
			 // unlimited natural
			 if(token.getValue() instanceof UnlimitedNaturalValue) {
				 return " type : Unlimited natural, value : "
						 + String.valueOf(((UnlimitedNaturalValue)token.getValue())
								 .getValue().intValue());
			 }
		 }
		 else if(value instanceof DefaultValueAdapter) {
			DefaultValueAdapter adapter = (DefaultValueAdapter)value;
			try {
				IVariable[] variables = adapter.getVariables();
		        if(variables == null) return "";
		        if(variables.length < 1) return "";
				return " type : " + variables[0].getReferenceTypeName() + ", value : " ;
			} catch (DebugException e) {
				e.printStackTrace();
			}
		 }
		 return "";
	 }
		protected ValueDescription generateValue(ValueSpecification specification) {
			
			if(specification instanceof LiteralBooleanImpl) {
				boolean boo = ((LiteralBooleanImpl)specification).booleanValue();
                return new ValueDescription("Boolean",String.valueOf(boo));
			}	
			if(specification instanceof LiteralIntegerImpl) {
				int v = ((LiteralIntegerImpl)specification).getValue();
                return new ValueDescription("Integer",String.valueOf(v));
			}
			if(specification instanceof LiteralRealImpl) {
				double v = ((LiteralRealImpl)specification).getValue();
				return new ValueDescription("Real",String.valueOf(v));
			}	
			if(specification instanceof LiteralStringImpl)
				return new ValueDescription
						("String",((LiteralStringImpl)specification).getValue());

			if(specification instanceof LiteralUnlimitedNaturalImpl) {
				int v = ((LiteralUnlimitedNaturalImpl)specification).integerValue();
		        return new ValueDescription("Unlimited natural",String.valueOf(v));
			}
			return null;
		}
}
