package rice.model.accessories;

import rice.model.Controllable;

public abstract class Applyable extends Accessory {

	public Applyable(String typeName) {
		super(typeName);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void apply(Controllable c);

}
