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
                        graphics.put( "tiger", TextureIO.newTexture(ImageIO.read(new File("rice/images/tiger.jpg")), true));

            graphics.put( "Food", TextureIO.newTexture(ImageIO.read(new File("rice/images/bread.jpg")), true));
            graphics.put( "Ore", TextureIO.newTexture(ImageIO.read(new File("rice/images/Magnet.jpg")), true));
            graphics.put( "hud", TextureIO.newTexture(ImageIO.read(new File("rice/images/hud.png")), true));
            graphics.put( "cat", TextureIO.newTexture(ImageIO.read(new File("rice/images/cat.jpg")), true));
            graphics.put( "marblecake", TextureIO.newTexture(ImageIO.read(new File("rice/images/marblecake.jpg")), true));
            graphics.put( "Terrain_1", TextureIO.newTexture(ImageIO.read(new File("rice/images/testImage.jpg")), true));
            graphics.put( "Terrain_2", TextureIO.newTexture(ImageIO.read(new File("rice/images/RandomAngle.png")), true));
            graphics.put( "Terrain_3", TextureIO.newTexture(ImageIO.read(new File("rice/images/snail.jpg")), true));
            graphics.put( "Terrain_4", TextureIO.newTexture(ImageIO.read(new File("rice/images/iceTiletest.jpg")), true));
            graphics.put( "Terrain_5", TextureIO.newTexture(ImageIO.read(new File("rice/images/grass.jpg")), true));
            graphics.put( "iceTest", TextureIO.newTexture(ImageIO.read(new File("rice/images/iceTiletest.jpg")), true));
            graphics.put( "arrowRedN", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowRedN.png")), true));
            graphics.put( "arrowRedNW", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowRedNW.png")), true));
            graphics.put( "arrowRedNE", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowRedNE.png")), true));
            graphics.put( "arrowRedS", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowRedS.png")), true));
            graphics.put( "arrowRedSW", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowRedSW.png")), true));
            graphics.put( "arrowRedSE", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowRedSE.png")), true));
            graphics.put( "arrowBlueN", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowBlueN.png")), true));
            graphics.put( "arrowBlueNW", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowBlueNW.png")), true));
            graphics.put( "arrowBlueNE", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowBlueNE.png")), true));
            graphics.put( "arrowBlueS", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowBlueS.png")), true));
            graphics.put( "arrowBlueSW", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowBlueSW.png")), true));
            graphics.put( "arrowBlueSE", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowBlueSE.png")), true));
            graphics.put( "arrowGreenN", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowGreenN.png")), true));
            graphics.put( "arrowGreenNW", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowGreenNW.png")), true));
            graphics.put( "arrowGreenNE", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowGreenNE.png")), true));
            graphics.put( "arrowGreenS", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowGreenS.png")), true));
            graphics.put( "arrowGreenSW", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowGreenSW.png")), true));
            graphics.put( "arrowGreenSE", TextureIO.newTexture(ImageIO.read(new File("rice/images/arrowGreenSE.png")), true));
            graphics.put( "0", TextureIO.newTexture(ImageIO.read(new File("rice/images/0.png")), true));
            graphics.put( "1", TextureIO.newTexture(ImageIO.read(new File("rice/images/1.png")), true));
            graphics.put( "2", TextureIO.newTexture(ImageIO.read(new File("rice/images/2.png")), true));
            graphics.put( "3", TextureIO.newTexture(ImageIO.read(new File("rice/images/3.png")), true));
            graphics.put( "4", TextureIO.newTexture(ImageIO.read(new File("rice/images/4.png")), true));
            graphics.put( "5", TextureIO.newTexture(ImageIO.read(new File("rice/images/5.png")), true));
            graphics.put( "6", TextureIO.newTexture(ImageIO.read(new File("rice/images/6.png")), true));
            graphics.put( "7", TextureIO.newTexture(ImageIO.read(new File("rice/images/7.png")), true));
            graphics.put( "8", TextureIO.newTexture(ImageIO.read(new File("rice/images/8.png")), true));
            graphics.put( "9", TextureIO.newTexture(ImageIO.read(new File("rice/images/9.png")), true));
	    graphics.put( "Decal_1", TextureIO.newTexture(ImageIO.read(new File("rice/images/melee.png")), true));
	    graphics.put( "Decal_2", TextureIO.newTexture(ImageIO.read(new File("rice/images/ranged.png")), true));
	    graphics.put( "Decal_0", TextureIO.newTexture(ImageIO.read(new File("rice/images/explorer.png")), true));
	    graphics.put( "Colonist", TextureIO.newTexture(ImageIO.read(new File("rice/images/colonist.png")), true));
	    graphics.put( "University", TextureIO.newTexture(ImageIO.read(new File("rice/images/university.png")), true));
	    graphics.put( "Capital", TextureIO.newTexture(ImageIO.read(new File("rice/images/capital.png")), true));
	    graphics.put( "Energy", TextureIO.newTexture(ImageIO.read(new File("rice/images/voltage.png")), true));
	    graphics.put( "fan", TextureIO.newTexture(ImageIO.read(new File("rice/images/fan.png")), true));
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
