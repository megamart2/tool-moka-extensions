package eu.megamart2.moka.extensions.format;

import java.util.List;

import eu.megamart2.moka.extensions.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.extensions.info.MegamartComplexInfoObject;
import eu.megamart2.moka.extensions.info.MegamartInOutInfoObject;
import eu.megamart2.moka.extensions.info.MegamartPrimitiveInfoObject;

public class MegamartInfoFormat {
	
	public static final String JSON_FORMAT = 
			"{ name = %n, type = %t, value = %v }";
	
	public static final String UML_FORMAT =  "%n:%t=%v";
	
	private String formatString;
	
	private final String arrayFormat;
	
	private final String arraySeparator;
	
	public MegamartInfoFormat(String formatString) {
		this(formatString,"[ %a ]",", ");
	}
	
	public MegamartInfoFormat(String formatString,String arrayFormat) {
		this(formatString,arrayFormat,", ");
	}
	
	public MegamartInfoFormat(String formatString
			,String arrayFormat,String arraySeparator) {
		this.formatString = formatString;
		this.arrayFormat = arrayFormat;
		this.arraySeparator = arraySeparator;
	}
	
	public void setFormat(String formatString) {
		this.formatString = formatString;
	}
	
	private String baseFormat(MegamartAbstractInfoObject info, boolean inOut) {
		
		String infoName = "No name";
		if(info.getName() != null) infoName = info.getName();
		String infoType = "Undefined";
		if(info.getType() != null) infoType = info.getType();
		
		String result = formatString
                .replaceAll("%n", infoName)
				.replaceAll("%t", infoType);
		
		if(inOut) result = result.replaceAll("value = ", "");
		return result;
	}
	
	public String format(MegamartAbstractInfoObject info) {
		
		if(info == null) return "";
		
		String result = baseFormat(info,false);
		
		if(info instanceof MegamartPrimitiveInfoObject)
			result = result.replaceAll("%v",
					((MegamartPrimitiveInfoObject) info).getValue());
		
		else if(info instanceof MegamartComplexInfoObject) {
			
			List<MegamartAbstractInfoObject> innerObjects =
					((MegamartComplexInfoObject)info).getInnerObjects();
		    	
			String arrayString = formatArray(innerObjects);
			result = result.replaceAll("%v",arrayString);
			
		}
		
		return result;
	}
	
	public String formatInOutObject(MegamartInOutInfoObject info, boolean firstPart) {
		
		if(info == null) return "";
		
		String result = baseFormat(info,true);
		
		if(firstPart) {
			String arrayString = "Input : " + formatArray(info.getInput());
		    return result.replaceAll("%v", arrayString);
		}
		
		String arrayString = "Output : " + formatArray(info.getOutput());
		return result.replaceAll("%v", arrayString);
	}
	
	public String formatCompletableInOut(MegamartInOutInfoObject info) {
		
		if(info == null) return "";
		
		String result = baseFormat(info,true);
		
		String arrayString = "Input : " +
		formatArray(info.getInput()) + arraySeparator + "Output : " + 
				formatArray(info.getOutput());
		
		return result.replaceAll("%v",arrayString);
	}
	
	private String formatArray(List<MegamartAbstractInfoObject> innerObjects) {
		
		String arrayString = "";
		boolean first = true;
		for(MegamartAbstractInfoObject innerObject : innerObjects) {
           if(first && innerObject != null) {
        	   arrayString = format(innerObject);
        	   first = false;
           }
           else if(innerObject != null) 
        	   arrayString += arraySeparator + format(innerObject);
		}	
		arrayString = arrayFormat.replaceAll("%a",arrayString);
		return arrayString;
	}
}
