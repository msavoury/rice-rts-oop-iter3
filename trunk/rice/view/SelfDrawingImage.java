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
class SelfDrawingImage extends SelfDrawingObject{
    private GraphicsTable graphics = GraphicsTable.getInstance();
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    Texture image;


    SelfDrawingImage(String imageName, double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        image = graphics.getGraphic(imageName);
    }

    void draw(GL gl, GLAutoDrawable drawable, TextRenderer renderer){

        image.bind();

        gl.glPushMatrix();

            gl.glBegin(GL.GL_POLYGON);

                gl.glTexCoord2d(0, 0);
                gl.glVertex2d(x1, y1);

                gl.glTexCoord2d(0, 1);
                gl.glVertex2d(x1, y2);

                gl.glTexCoord2d(1, 1);
                gl.glVertex2d(x2, y2);

                gl.glTexCoord2d(1, 0);
                gl.glVertex2d(x2,y1);

            gl.glEnd();

        gl.glPopMatrix();

    }

}
