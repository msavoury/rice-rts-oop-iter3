package rice.model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapInitializer {
	//File file;
	
	/**
	 * The name of the default map to be used
	 */
	private String defaultFile = "rice/maps/testMap";
	private String userFile;
	
	//public void setFile(File f){
		
	//}
	
	public void setFile(String filename){
      this.userFile = filename;
	}
	
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
			      // Print the content on the console
				      System.out.println (strLine);
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
	     
}
