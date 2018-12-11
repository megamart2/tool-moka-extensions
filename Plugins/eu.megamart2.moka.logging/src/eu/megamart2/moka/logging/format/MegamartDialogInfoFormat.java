package eu.megamart2.moka.logging.format;

import java.util.LinkedList;
import java.util.List;

import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.logging.info.MegamartComplexInfoObject;
import eu.megamart2.moka.logging.info.MegamartInOutInfoObject;
import eu.megamart2.moka.logging.info.MegamartPrimitiveInfoObject;

public class MegamartDialogInfoFormat {
	
	public String format(MegamartAbstractInfoObject info){ 
		
		List<String> results  = format(info,0);
		if(results.isEmpty()) return "";
		
		String result = "";
		for(String sr : results)if(sr != null)if(!sr.isEmpty())
			result += sr + "\n";
		
		return result;
		}
	
	private List<String> format(MegamartAbstractInfoObject info,int level){
		
		if(info == null) return new LinkedList<String>(); // empty list
		
		if(info instanceof MegamartInOutInfoObject)
			return formatInOutObject((MegamartInOutInfoObject)info,level);
		
		if(info instanceof MegamartComplexInfoObject) 
			    return formatComplexObject((MegamartComplexInfoObject)info,level);
		
		else return formatPrimitiveObject((MegamartPrimitiveInfoObject)info,level);
	}
	
	private List<String> formatPrimitiveObject(MegamartPrimitiveInfoObject info,int level){
		
		List<String> result = new LinkedList<String>();
		
		String line = " ";
		String simbol = ">";
		for(int i = 0; i < level; i++) {
			line += "  ";
			simbol += ">";
		}
		line += simbol;
		
		MegamartFormatFacade simpleFormat = 
				new MegamartFormatFacade(MegamartInfoFormat.UML_FORMAT);
		
		String visibility = " ";
		if(info.getVisibility() != null) {
			if(info.getVisibility().equalsIgnoreCase("public"))
			       visibility = " + ";
			else if(info.getVisibility().equalsIgnoreCase("private"))
				visibility = " - ";
			else visibility = " # ";
		}
		
		result.add(line + visibility + simpleFormat.format(info));
		
		return result;
	}
	
	private List<String> formatInOutObject(MegamartInOutInfoObject info, int level){
		
		List<String> result = new LinkedList<String>();
		
		String line = "Input : ";
		for(int i = 0; i < level; i++) line += "  ";
		
		if(!info.getInput().isEmpty())if(info.getInput().get(0) != null){
		result.add(line);
		formatInnerList(info.getInput(),result,level);
		}
		if(!info.getOutput().isEmpty())if(info.getOutput().get(0) != null){
		line = line.replaceFirst("Input","Output");
		result.add(line);
		formatInnerList(info.getOutput(),result,level);
		}
		
		return result;
	}

	private List<String> formatComplexObject(MegamartComplexInfoObject info,int level){
		
		List<String> result = new LinkedList<String>();
        
		String line = " ";
		String simbol = ">";
		for(int i = 0; i < level; i++) {
			line += "  ";
			simbol += ">";
		}
		line += simbol;
		
		String visibility = " ";
		if(info.getVisibility() != null) {
			if(info.getVisibility().equalsIgnoreCase("public"))
			       visibility = " + ";
			else if(info.getVisibility().equalsIgnoreCase("private"))
				visibility = " - ";
			else visibility = " # ";
		}
		
		line += visibility + info.getName() + " : " + info.getType();
		result.add(line);
		
        formatInnerList(info.getInnerObjects(),result,level);
         
		return result;
	}
	
	private void formatInnerList(List<MegamartAbstractInfoObject> innerObjects,List<String> result,int level) {
		for(MegamartAbstractInfoObject innerObject : innerObjects) {
			List<String> provisionalList = format(innerObject, level + 1);
		    for(String sr : provisionalList) result.add(sr);
		}
	}
	
}
