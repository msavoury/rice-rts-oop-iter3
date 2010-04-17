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

import rice.model.map.HexTranslator;
import rice.model.map.MapPositionTranslator;

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
	
	public MapInitializer() {
		this.state = new TerrainState(this);
		terrainRows = new ArrayList<int[]>();
	}
		
	public void setFile(String filename){
      this.userFile = filename;
	}
	
	public void addTerrainRow(int[] row){
		terrainRows.add(row);
	}
	
	public int [][] getTerrain() {
		//throw new UnsupportedOperationException();
		int[][] terrains = new int[terrainRows.size()][terrainRows.get(0).length];
		
		for(int i = 0; i < terrainRows.size(); i++){
			terrains[i] = terrainRows.get(i);
		}
		
		return terrains;
	}
	
	//
	/**
	 * Parse the map, the terrain section should be square 
	 */
	public void parse() {
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
			String strLine;
			//Read File Line By Line\
			 while ((strLine = br.readLine()) != null)   {
			   if(strLine.startsWith("terrain")){
				   state = new TerrainState(this);
				   continue;
			   }
			   else if(strLine.startsWith("location")){
				   state = new LocationState(this);
				   continue;
			   }
			   else if (strLine.startsWith("/")){ //for comments
				   continue;
			   }
			   state.processLine(strLine);
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

class LocationState extends InitializerState {

	public LocationState(MapInitializer m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	void processLine(String s) {
		// TODO Auto-generated method stub
		  System.out.println("location state " + s);	
	
	}
	
}
