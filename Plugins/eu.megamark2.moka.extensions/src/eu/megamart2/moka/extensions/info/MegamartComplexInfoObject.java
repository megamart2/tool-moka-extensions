package eu.megamart2.moka.extensions.info;

import java.util.List;

public class MegamartComplexInfoObject extends MegamartAbstractInfoObject {
	
	private List<MegamartAbstractInfoObject> innerObjects;
	
	public MegamartComplexInfoObject(String name, String type,List<MegamartAbstractInfoObject> innerObjects) {
		super(name, type);
		this.innerObjects = innerObjects;
	}

	public List<MegamartAbstractInfoObject> getInnerObjects(){
		return innerObjects;
	}
}
