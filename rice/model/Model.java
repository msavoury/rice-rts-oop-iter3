/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rice.model.map.AreaMap;
import rice.model.player.Player;
import rice.util.Position;
import rice.view.MSVisitor;
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

	private Player[] players;
	private Player mainPlayer;
	
	
	public Model() {
      MapInitializer mi = new MapInitializer();
      mi.parse();
      
      AreaMap.setTerrain(mi.getTerrain());
      AreaMap.setTranslator(mi.getTranslator());
      
      //start debug
      //this should be changed so that the area map gets its position
      //list from the initializer as well
      List list = new ArrayList<Position>();
      list.add(new Position());
      list.add(new Position());
      AreaMap.setPositions(list);
      //end debug
            
      
	  //make players
      players = new Player[2];
      players[0] = new Player();
      players[1] = new Player();
      mainPlayer = players[0];
	  //set player stuff
	}

    public void tick(){
        for(Player p : players){
        	p.tick();
        }
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
