/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import com.sun.opengl.util.j2d.TextRenderer;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author spock
 */
public class SelfDrawingHexHighlight extends SelfDrawingObject{

    private double x;
    private double y;
    double screenRatio;

    SelfDrawingHexHighlight(double x, double y, double screenRatio){
        this.x = x;
        this.y = y;
        this.screenRatio = screenRatio;
    }

    void draw(GL gl, GLAutoDrawable drawable, TextRenderer renderer){

        gl.glPushMatrix();

            gl.glLineWidth(20f);
            gl.glColor3f(1, 0, 0);

            gl.glBegin(GL.GL_LINES);

                gl.glVertex2d(x-.1,y);
                gl.glVertex2d(x-.05,y-.0866025*(screenRatio));

            gl.glEnd();

            gl.glBegin(GL.GL_LINES);

                gl.glVertex2d(x-.05,y-.0866025*(screenRatio));
                gl.glVertex2d(x+.05, y-.0866025*(screenRatio));

            gl.glEnd();

            gl.glBegin(GL.GL_LINES);

                gl.glVertex2d(x+.05, y-.0866025*(screenRatio));
                gl.glVertex2d(x+.1, y);

            gl.glEnd();

            gl.glBegin(GL.GL_LINES);

                gl.glVertex2d(x+.1, y);
                gl.glVertex2d(x+.05, y+.0866025*(screenRatio));

            gl.glEnd();

            gl.glBegin(GL.GL_LINES);

                gl.glVertex2d(x+.05, y+.0866025*(screenRatio));
                gl.glVertex2d(x-.05, y+.0866025*(screenRatio));

            gl.glEnd();

            gl.glBegin(GL.GL_LINES);

                gl.glVertex2d(x-.05, y+.0866025*(screenRatio));
                gl.glVertex2d(x-.1,y);

            gl.glEnd();

            gl.glColor3f(1, 1, 1);
            gl.glLineWidth(1f);

        gl.glPopMatrix();

    }


}
