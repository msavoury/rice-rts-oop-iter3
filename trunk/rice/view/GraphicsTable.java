/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.HashMap;

/**
 *
 * @author spock
 */
public class GraphicsTable {

    HashMap< String, Texture > graphics;

    private GraphicsTable(){
        graphics = new HashMap<String, Texture>();
        try{
            graphics.put( "rice", TextureIO.newTexture(ImageIO.read(new File("rice/images/testImage.jpg")), true));
        }
        catch(Exception d){
            d.printStackTrace();
            System.out.println("Error while making textures!");
        }
    }

    Texture getGraphic(String key){
        return graphics.get(key);
    }
    private static class GraphicsTableHolder {
        private static final GraphicsTable ONEANDONLY =
                                            new GraphicsTable();
    }

    public static GraphicsTable getInstance() {
        return GraphicsTableHolder.ONEANDONLY;
    }

}
