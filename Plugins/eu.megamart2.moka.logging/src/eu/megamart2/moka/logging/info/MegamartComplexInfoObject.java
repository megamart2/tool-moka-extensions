package eu.megamart2.moka.logging.info;

import java.util.List;

public class MegamartComplexInfoObject extends MegamartAbstractInfoObject {
	
	private List<MegamartAbstractInfoObject> innerObjects;
	
	public MegamartComplexInfoObject(String name, String type,
			List<MegamartAbstractInfoObject> innerObjects) {
		this(name,type,innerObjects,null);
	}
	
	public MegamartComplexInfoObject(String name, String type,
			List<MegamartAbstractInfoObject> innerObjects,String visibility) {
		super(name, type,visibility);
		this.innerObjects = innerObjects;
	}

	public List<MegamartAbstractInfoObject> getInnerObjects(){
		return innerObjects;
	}
}
