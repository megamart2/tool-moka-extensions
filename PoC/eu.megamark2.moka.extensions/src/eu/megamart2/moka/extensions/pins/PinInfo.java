package eu.megamart2.moka.extensions.pins;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.PinActivation;

public abstract class PinInfo {

   private PinActivation pin;
   
   public PinInfo(PinActivation pin) {
	   this.pin = pin;
   }
   public String getInfo() {
	   String info = "   ";
	   if(pin.getNode().isSetName()) info = info + pin.getNode().getName() + " / ";
	   return info + " Type : " + getTypeInfo() + " / Value : " + getValueInfo() + "\n";
   }
   
   protected abstract String getValueInfo();
   
   protected abstract String getTypeInfo();
}
