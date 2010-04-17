/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import javax.media.opengl.GL;
import com.sun.opengl.util.j2d.TextRenderer;
import javax.media.opengl.GLAutoDrawable;
import java.awt.Color;


/**
 *
 * @author spock
 */
class SelfDrawingText extends SelfDrawingObject{

    private double x;
    private double y;
    private String text;

    SelfDrawingText(String text, double x, double y){
        this.text = text;
        this.x = x;
        this.y = y;
    }

    void draw(GL gl, GLAutoDrawable drawable, TextRenderer renderer){
        renderer.beginRendering(drawable.getWidth(), drawable.getHeight());

        renderer.setColor(Color.WHITE);
        renderer.draw(text, (int)(x*drawable.getHeight()), (int)(y*drawable.getWidth()));

        renderer.endRendering();
    }

}
