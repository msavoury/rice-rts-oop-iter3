/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import rice.controller.ControllableModel;
import rice.controller.Tickable;
import rice.model.map.AreaMap;
import rice.model.player.Player;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.MSVisitorAcceptor;
import rice.view.ViewableControllable;
import rice.view.ViewableModel;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableStructure;
import rice.view.ViewableTech;
import rice.view.ViewableUnit;

/**
 *
 * @author spock
 */
public class Model implements ViewableModel, ControllableModel, Tickable, MSVisitorAcceptor {

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
    	  //players[i].initialize();
    	  //TODO: change this back to initialize
    	  players[i].testInitialize();
      }
     
      //set main player
      mainPlayer = players[0];
	  //set player stuff
	}

    public void tick(int tick){
        for(Player p : players){
        	p.tick(tick);
        }
        
        
        
    	System.out.println("elements: "+mainPlayer.getSelectedPath().size());

    }

    public void nextMode() {
      mainPlayer.nextMode();	
    }
    public void previousMode(){
      mainPlayer.previousMode();
    }
    public void nextSubmode(){
      mainPlayer.nextSubmode();
    }
    public void previousSubmode(){
      mainPlayer.previousSubmode();
    }
    public void nextInstance(){
      mainPlayer.nextInstance();
    }
    public void previousInstance(){
      mainPlayer.previousInstance();
    }
    public void nextAbility(){
        mainPlayer.nextAbility();	
    }
    public void previousAbility(){
        mainPlayer.previousAbility();
    }

    public void nextTechnology(){}
    public void previousTechnology(){}
    public void nextTechnoogyBranch(){}
    public void previousTechnologyBranch(){}

    
    public void createRallyPoint(){}
    
	@Override
	public List<ViewableStructure> getAllStructures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewableUnit> getAllUnits() {
		return null;
	}

	@Override
	public ViewableControllable getCurrentlySelectedInstance() {
		return mainPlayer.getSelected();
		
	}

	@Override
	public String getCurrentlySelectedMode() {
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

	@Override
	public void nextStructure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextUnit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousStructure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousUnit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getCurrentSelectorPathToInstance() {	
		return mainPlayer.getSelectedPath();		
	}

	@Override
	public ViewableTech getCurrentlySelectedTech() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectedTechNodeBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewableTech> getSelectedTechNodeBranchAllNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nextTechnologyBranch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousTechnolgy() {
		// TODO Auto-generated method stub
	}

	public Position getMapSize() {
		return AreaMap.getSize();
	}
	
	public List<Position> getActionTiles() {
		List<Position> p = new ArrayList<Position>();
		p.add(new Position(2,2));
		return p;
	}

}
