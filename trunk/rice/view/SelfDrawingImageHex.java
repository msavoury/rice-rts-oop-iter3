/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import javax.media.opengl.GL;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.j2d.TextRenderer;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author spock
 */
class SelfDrawingImageHex extends SelfDrawingObject{
    private GraphicsTable graphics = GraphicsTable.getInstance();
    private double x;
    private double y;
    Texture image;
    double r;
    double h;
    double screenRatio;

    SelfDrawingImageHex(String imageName, double x, double y, double screenRatio){
        this.x = x;
        this.y = y;
        this.screenRatio = screenRatio;
        image = graphics.getGraphic(imageName);
    }

    void draw(GL gl, GLAutoDrawable drawable, TextRenderer renderer){



        image.bind();

        gl.glPushMatrix();

            gl.glBegin(GL.GL_POLYGON);

                gl.glTexCoord2d(0.0, 0.5);
                gl.glVertex2d(x-.1,y);

                gl.glTexCoord2d(0.25, 0);
                gl.glVertex2d(x-.05,y-.0866025*(screenRatio));

                gl.glTexCoord2d(0.75, 0);
                gl.glVertex2d(x+.05, y-.0866025*(screenRatio));

                gl.glTexCoord2d(1.0, .5);
                gl.glVertex2d(x+.1, y);

                gl.glTexCoord2d(.75, 1.0);
                gl.glVertex2d(x+.05, y+.0866025*(screenRatio));

                gl.glTexCoord2d(.25, 1.0);
                gl.glVertex2d(x-.05, y+.0866025*(screenRatio));

            gl.glEnd();

        gl.glPopMatrix();

    }

}