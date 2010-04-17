/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import java.awt.event.KeyListener;

/**
 *
 * @author spock
 */
public class View implements ControllableView{

    private ScreenManager screenManager;

    public View(){
        screenManager = new ScreenManager(true);
        screenManager.requestFocusInWindow();
    }

    public void refresh(){
    }

    public void switchMode(String type){

    }

    public void addKeyListener(KeyListener k){
        screenManager.addKeyListener(k);
    }


    public void removeKeyListener(KeyListener k){
        screenManager.removeKeyListener(k);
    }

}
