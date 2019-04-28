import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

class Cheetah {

	private static BufferedImage cheetahImg; // the image will be stored as a BufferedImage

	public static void drawCheetah(Graphics g, Block newBlock) {

     	try {
     		cheetahImg = ImageIO.read(new File("img/Cheetah.png")); // load the image of the Cheetah 
     	} catch (IOException e) { // catch the exception in case the image might not exist
     		e.printStackTrace();
     	}
     	
        // draw the cheetah image at the x and y positions that were specified when the object was created
        g.drawImage(cheetahImg, newBlock.getX() * Grid.blockWidth, newBlock.getY() * Grid.blockHeight, null);
     }
}