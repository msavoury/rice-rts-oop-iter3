/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import rice.controller.Tickable;
import rice.model.map.AreaMap;
import rice.model.player.Player;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.MSVisitorAcceptor;
import rice.view.ViewableModel;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableStructure;
import rice.view.ViewableTech;
import rice.view.ViewableUnit;

/**
 *
 * @author spock
 */
public class Model implements ViewableModel, Tickable, MSVisitorAcceptor {

	private Player[] players;
	private Player mainPlayer;
	
	
	public Model() {
      MapInitializer mi = new MapInitializer();
      mi.parse();
      
      //probably should just call getInstance instead of having 
      //these static methods
      AreaMap.setTerrain(mi.getTerrain());
      AreaMap.setTranslator(mi.getTranslator());
      AreaMap.setPositions(mi.getStartingPositions());
     
      
	  //make players
      Iterator<Position> iter = mi.getStartingPositions().iterator();
      players = new Player[2];
      
      for(int i = 0; i < players.length; i++){
    	  players[i] = new Player(iter.next());
    	  players[i].initialize();
      }
     
      //set main player
      mainPlayer = players[0];
	  //set player stuff
	}

    public void tick(int tick){
        for(Player p : players){
        	p.tick(tick);
        }
    }

    public void nextMode() {
    	
    }
    public void previousMode(){}
    public void nextSubmode(){}
    public void previousSubmode(){}
    public void nextInstance(){}
    public void previousInstance(){}
    
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
	
	public void processCommand(String command){
	  System.out.println("Model got command: " +command);
	  mainPlayer.processCommand(command);
	}

	@Override
	public void accept(MSVisitor v) {
		mainPlayer.accept(v);
	}

	

}
