/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import java.util.HashMap;
import java.util.List;

import rice.view.MSVisitor;
import rice.view.SOVisitor;
import rice.view.TOVisitor;
import rice.view.UOVisitor;
import rice.view.ViewableModel;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableStructure;
import rice.view.ViewableTech;
import rice.view.ViewableUnit;

/**
 *
 * @author spock
 */
public class Model implements ViewableModel {

	
	
	public Model() {
      MapInitializer mi = new MapInitializer();
      mi.parse();
		//make map initializer
		//make new map
		//set map stuff from initializer
		//make players
		//set player stuff
	}

    public void tick(){
        
    }

	@Override
	public List<ViewableStructure> getAllStructures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewableTech> getAllTechnology() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewableUnit> getAllUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentlySelectedCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentlySelectedInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentlySelectedMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewableRallyPoint getCurrentlySelectedRallyPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewableStructure getCurrentlySelectedStructure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentlySelectedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewableUnit getCurrentlySelectedUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Integer> getPlayerResources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void receiveMainScreenVisitor(MSVisitor m) {
		// TODO Auto-generated method stub
		
	}

	

}
