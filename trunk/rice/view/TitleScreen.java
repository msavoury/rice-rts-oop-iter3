/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import javax.media.opengl.GL;
import com.sun.opengl.util.j2d.TextRenderer;
import javax.media.opengl.GLAutoDrawable;

import java.util.ArrayList;

/**
 *
 * @author spock
 */
class TitleScreen extends GameGraphic{

    ArrayList<SelfDrawingObject> drawItems;

    TitleScreen(){
        drawItems = new ArrayList<SelfDrawingObject>();
        drawItems.add(new SelfDrawingImage("rice", .15, .15, .30, .30));
        drawItems.add(new SelfDrawingImage("rice", .15, .70, .30, .85));
        drawItems.add(new SelfDrawingImage("rice", .70, .15, .85, .30));
        drawItems.add(new SelfDrawingImage("rice", .70, .70, .85, .85));
        drawItems.add(new SelfDrawingText("RICE", .4, .55));
    }

    void render(GL gl, GLAutoDrawable drawable, TextRenderer renderer){
        for(SelfDrawingObject sdo: drawItems){
            sdo.draw(gl, drawable, renderer);
        }
    }

}
