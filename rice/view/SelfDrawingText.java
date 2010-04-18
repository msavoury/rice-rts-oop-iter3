/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import javax.media.opengl.GL;
import com.sun.opengl.util.j2d.TextRenderer;
import javax.media.opengl.GLAutoDrawable;
import java.awt.Color;
import java.awt.Font;


/**
 *
 * @author spock
 */
class SelfDrawingText extends SelfDrawingObject{

    private double x;
    private double y;
    private String text;
    private String fontType;
    private int fontSize;

    SelfDrawingText(String text, double x, double y){
        this.text = text;
        this.x = x;
        this.y = y;

    }

    void draw(GL gl, GLAutoDrawable drawable, TextRenderer renderer){
        renderer.beginRendering(drawable.getWidth(), drawable.getHeight());

        renderer.setColor(Color.WHITE);
        renderer.draw(text, (int)(x*drawable.getWidth()), (int)(y*drawable.getHeight()));

        renderer.endRendering();
    }

}
