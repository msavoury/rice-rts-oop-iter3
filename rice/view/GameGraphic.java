/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import javax.media.opengl.GL;

/**
 *
 * @author spock
 */
abstract class GameGraphic {
    private boolean activated = false;

    boolean activate(String s){
        return false;
    }

    void deactivate(){

    }

    boolean getActivated(){
        return activated;
    }

    void refresh(){
    }

}
