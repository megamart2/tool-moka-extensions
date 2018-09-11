package eu.megamart2.moka.extensions.utils;

public class StringUtils {
	
	public boolean noString(String sr) {
		if(sr == null) return true;
		sr = sr.replaceAll(" ","").replaceAll("\n","");
		return sr.isEmpty();
	}
}
