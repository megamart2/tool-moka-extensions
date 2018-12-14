package eu.megamart2.moka.logging.format;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartInOutInfoObject;

public class MegamartFormatFacade {
	
	private final MegamartInfoFormat format;
	
	public MegamartFormatFacade(String formatString) {
		format = new MegamartInfoFormat(formatString);
	}
	
	public MegamartFormatFacade(MegamartInfoFormat format) {
		this.format = format;
	}

	public void setFormat(String formatString) {
        format.setFormat(formatString);
	}
	
	public void setArrayFormat(String arrayFormat) {
		format.setArrayFormat(arrayFormat);
	}
	
	public void setArraySeparator(String arraySeparator) {
		format.setArraySeparator(arraySeparator);
	}
	
	public void setSeparatorAfterInOutTitle(boolean putSeparator) {
		format.setSeparatorAfterInOutTitle(putSeparator);
	}
	
	public void setInnerFormat(MegamartInfoFormat innerFormat) {
		format.setInnerFormat(innerFormat);
	}

	public String format(MegamartAbstractInfoObject info) {
		
		if(info instanceof MegamartInOutInfoObject) {
			
			MegamartInOutInfoObject inOutObject = 
					(MegamartInOutInfoObject)info;
			
			//if(inOutObject.isOnePhase())
				return format.formatOnePhaseInOut(inOutObject);
			
			//if(inOutObject.isComplete())
				//return format.formatOnePhaseInOut(inOutObject);
			
			//return format.formatInOutObject(inOutObject, true);
		}
		return format.format(info);
	}

}
