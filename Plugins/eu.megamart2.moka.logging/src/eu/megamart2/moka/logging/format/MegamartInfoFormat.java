package eu.megamart2.moka.logging.format;

import java.util.List;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartComplexInfoObject;
import eu.megamart2.moka.logging.info.MegamartInOutInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;

public class MegamartInfoFormat {
	
	public static final String JSON_FORMAT = 
			"{ name = %n, type = %t, value = %v }";
	
	public static final String UML_FORMAT =  "%n : %t = %v";
	
	private String formatString;
	
	private String arrayFormat;
	
	private String arraySeparator;
	
	private boolean separatorAfterInOutTitle;
	
	private MegamartInfoFormat innerFormat;
	
	
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
		innerFormat = this; // default
	}
	
	public void setInnerFormat(MegamartInfoFormat innerFormat) {
		this.innerFormat = innerFormat;
	}
	
	public void setSeparatorAfterInOutTitle(boolean putSeparator) {
		separatorAfterInOutTitle = putSeparator;
	}
	
	public void setFormat(String formatString) {
		this.formatString = formatString;
	}
	
	public void setArrayFormat(String arrayFormat) {
		this.arrayFormat = arrayFormat;
	}
	
	public void setArraySeparator(String arraySeparator) {
		this.arraySeparator = arraySeparator;
	}
	
	private String baseFormat(MegamartAbstractInfoObject info, boolean inOut) {
		
		String infoName = "No name";
		if(info.getName() != null) infoName = info.getName();
		String infoType = "Undefined";
		if(info.getType() != null) infoType = info.getType();

		if(infoType.contains("Reference to")) {
			infoType = infoType.split("@")[0];
			infoType = infoType.replaceAll("\\$","::");
		}
		
		// logging
		System.out.println(infoName);
		System.out.println(infoType);
		System.out.println();
		
		String result = formatString
                .replaceAll("%n", infoName)
				.replaceAll("%t", infoType);
		
		if(inOut) result = result.replaceAll("value = ", "");
		return result;
	}
	
	public String format(MegamartAbstractInfoObject info) {
		
		if(info == null) return null;
		
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
		if(result.replaceAll(" ","").charAt(0) == ':')
			result = result.replaceFirst(":",""); // this is for no name objects
		
		return result;
	}
	
	public String formatOnePhaseInOut(MegamartInOutInfoObject info) {
		
		if(info == null) return "";
		
		String result = baseFormat(info,true);
		
		String arrayString;
		if(separatorAfterInOutTitle) arrayString = "Input : " + arraySeparator;
		else arrayString = "Input : ";
	    arrayString += formatArray(info.getInput()) + arraySeparator + "Output : ";
	    if(separatorAfterInOutTitle) arrayString += arraySeparator;
		arrayString += formatArray(info.getOutput());
		
		return result.replaceAll("%v",arrayString);
	}
	
	private String formatArray(List<MegamartAbstractInfoObject> innerObjects) {
		
		String arrayString = "";
		boolean first = true;
		for(MegamartAbstractInfoObject innerObject : innerObjects) {
           if(first && innerObject != null) {
        	   arrayString = innerFormat.format(innerObject);
        	   first = false;
           }
           else if(innerObject != null) 
        	   arrayString += arraySeparator + innerFormat.format(innerObject);
		}	
		arrayString = arrayFormat.replaceAll("%a",arrayString);
		return arrayString;
	}
}
