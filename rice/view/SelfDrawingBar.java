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
class SelfDrawingBar extends SelfDrawingObject{

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double r;
    private double g;
    private double b;
    private double a;

    SelfDrawingBar(double x1, double y1, double x2, double y2, Color color){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        r = (double)(color.getRed())/255.0;
        g = (double)(color.getGreen())/255.0;
        b = (double)(color.getBlue())/255.0;
        a = (double)(color.getAlpha())/255.0;

    }

    void draw(GL gl, GLAutoDrawable drawable, TextRenderer renderer){
        gl.glPushMatrix();

            gl.glColor4d(r, g, b, a);
            gl.glBegin(GL.GL_QUADS);

                gl.glVertex2d(x1, y1);

                gl.glVertex2d(x1, y2);
                
                gl.glVertex2d(x2, y2);

                gl.glVertex2d(x2, y1);

            gl.glEnd();


        gl.glPopMatrix();

    }

}
