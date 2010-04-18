/**
 *
 * @author spock
 */

package rice;

import rice.controller.Controller;
import rice.model.Model;
import rice.view.View;

public class RunGame {

    public static void main(String args[]){
    	boolean fullScreenMode = false;
    	
        Model model = new Model();
        Controller controller = new Controller();
        if (args.length > 0){
          fullScreenMode = (args[0].equals("true"));
        }
        View view = new View(fullScreenMode, model);
        controller.registerModel(model);
        controller.registerView(view);
        controller.start();
        while(true){
        }
    }

}
