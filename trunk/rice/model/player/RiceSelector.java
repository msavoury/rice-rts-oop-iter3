package rice.model.player;

import rice.model.unit.Colonist;
import rice.model.unit.Explorer;
import rice.model.unit.Melee;
import rice.model.unit.Ranged;

public class RiceSelector extends Selector {
	
	private SelectorNode ranged;
	private SelectorNode melee;
	private SelectorNode colonist;
	private SelectorNode explorer;
	
	public RiceSelector() {
		super();
		
		addNode("Main", "Unit");
		addNode("Main", "Structure");
		addNode("Main", "Rally");
		addNode("Main", "Army");
		
		ranged = addNode("Unit","Ranged");
		melee = addNode("Unit","Melee");
		colonist = addNode("Unit","Colonist");
		explorer = addNode("Unit","Explorer");
	}
	
	public void addRanged(Ranged r){
		ranged.addChild(new SelectorNode<Ranged>(r));
	}
	
	public void addColonist(Colonist c){
		colonist.addChild(new SelectorNode<Colonist>(c));
	}
	
	public void addExplorer(Explorer e){
		explorer.addChild(new SelectorNode<Explorer>(e));
	}
	
	public void addMelee(Melee m){
		melee.addChild(new SelectorNode<Melee>(m));
	}

}
