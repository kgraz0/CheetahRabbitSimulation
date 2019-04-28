import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

class Rabbit {

	private static BufferedImage rabbitImg; // the image will be stored as a BufferedImage

	public static void drawRabbit(Graphics g, Block newBlock) { 

     	try {
     		rabbitImg = ImageIO.read(new File("img/Rabbit.png")); // load the image of the Rabbit 
     	} catch (IOException e) { // catch the exception in case the image might not exist
     		e.printStackTrace();
     	}
     	
     	// draw the rabbit image at the x and y positions that were specified when the object was created
        g.drawImage(rabbitImg, newBlock.getX() * Grid.blockWidth, newBlock.getY() * Grid.blockHeight, null);
     }
}