package rice.model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import rice.model.accessories.Decal;
import rice.model.map.HexTranslator;
import rice.model.map.MapPositionTranslator;
import rice.util.Position;

/**
 * This class represents the party responisble of reading a file and parsing it appropriately
 * for the Map to be initialized.
 * 
 * @author Marcos
 *
 */
public class MapInitializer {
	InitializerState state;
	/**
	 * The name of the default map to be used
	 */
	private String defaultFile = "rice/maps/testMap";
	private String userFile;
	
	List<int[]> terrainRows;
	/**
	 * List of starting positions for all players
	 */
	List<Position> positions;
	
	/**
	 * LIst of decals on the map
	 */
	List<Decal> decals;
	
	
	public MapInitializer() {
		this.state = new TerrainState(this);
		terrainRows = new ArrayList<int[]>();
		positions = new ArrayList<Position>();
		decals = new ArrayList<Decal>();
	}
		
	public void setFile(String filename){
      this.userFile = filename;
	}
	
	public void addTerrainRow(int[] row){
		System.out.println("row added");
		terrainRows.add(row);
	}
	
	public void addPosition(Position p){
		positions.add(p);
	}
	
	public void addDecal(Decal d){
		decals.add(d);
	}
	
	public int [][] getTerrain() {
		int[][] terrains = new int[terrainRows.size()][terrainRows.get(0).length];
		
		for(int i = 0; i < terrainRows.size(); i++){
			terrains[i] = terrainRows.get(i);
		}
		
		return terrains;
	}
	
	public List<Position> getStartingPositions(){
		//Position p = new Position();
		return positions;
	}
	
	//
	/**
	 * Parse the map, the terrain section should be square 
	 */
	public void parse() {
	 boolean parsing = true;
	 String userdir = System.getProperty("user.dir");
	 System.out.println(userdir);
		
	  //check to make sure map isn't null
	  String filename = userFile;
	  if (filename == null){
		  filename = userdir + File.separator+defaultFile;
	  }
	    try {
	    	
			FileInputStream fstream = new FileInputStream(new File(filename));
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			System.out.println("Parsing Map: "+ filename );
			
			String strLine;
			//Read File Line By Line\
			 while (((strLine = br.readLine()) != null))   {
			   System.out.println("parsing line: " + strLine);
			   if(strLine.startsWith("terrain")){
				   state = new TerrainState(this);
				   continue;
			   }
			   else if(strLine.startsWith("location")){
				   state = new LocationState(this);
				   continue;
			   }
			   else if(strLine.startsWith("decal")){
				   state = new DecalState(this);
				   continue;
			   }
			   else if(strLine.startsWith("/*") || strLine.startsWith("*/")){
				   
				   parsing = !parsing;
				   System.out.println("parsing is now " + parsing);
				   continue;
			   }
			   else if (strLine.startsWith("/") || strLine.equals("")){ //for comments and empty space
				   continue;
			   }
			   if(parsing){
			     state.processLine(strLine);
			   }
			 }
			  //Close the input stream
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	public MapPositionTranslator getTranslator() {
		//TODO: have this come from value in file
		return new HexTranslator();
		
			
	}
	
}



abstract class InitializerState {
	MapInitializer m;
	public InitializerState(MapInitializer m){
	  this.m = m;	
	}
	
	abstract void processLine(String s);
		
	
}

/**
 * Process a terrain line
 * @author Marcos
 *
 */
class TerrainState extends InitializerState {

	public TerrainState(MapInitializer m) {
		super(m);
		// TODO Auto-generated constructor stub
	}
	
	void processLine(String s){
	  //System.out.println("terrain state " + s);
	  String[] terrains = s.split(",");
	  int[] translated = new int[terrains.length];
	  try {
	    for(int i = 0; i< terrains.length; i++){
		    translated[i] = Integer.parseInt(terrains[i]);
	    }
	    m.addTerrainRow(translated);
	  }
	  catch(NumberFormatException e){
		  e.printStackTrace();
	  }
	}
	
}

/**
 * Parse location for files
 */
class LocationState extends InitializerState {

	public LocationState(MapInitializer m) {
	  super(m);
	}

	@Override
	void processLine(String s) {
	  String [] num = s.split(",");
	  Position p = new Position(Integer.parseInt(num[0]), Integer.parseInt(num[1]));
	  m.addPosition(p);
	}
	
}

/**
 * Parse location for decal
 */
class DecalState extends InitializerState {

	public DecalState(MapInitializer m) {
	  super(m);
	}

	@Override
	void processLine(String s) {
	  m.addDecal(new Decal(s));
	}
	
}