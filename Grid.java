import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class Grid {

     private static ArrayList<Block> grid; 
     public static int x = 0, y = 0, blockWidth = 25, blockHeight = 25, numBlockW = 20, numBlockH = 20;

     public Grid() {
          grid = generateGrid();
     }

     /*
     This method creates a new ArrayList that will contain Blocks,
     and for each x and y value create a new two-dimensional grid
     full of blocks, the difference in position is based on the
     block width and block height. 
     */
     public static ArrayList<Block> generateGrid() {
     ArrayList<Block> blockAL = new ArrayList<Block>();

     for (int i = 0; i < numBlockW; i++) {
          for (int j = 0; j < numBlockH; j++) { 
               Block b = new Block(x, y, blockWidth, blockHeight); 
               blockAL.add(b); 
               x += blockWidth; 
          }
          x = 0; 
          y += blockHeight;
     }
     return new ArrayList<Block>(blockAL); 
}

     public static void drawGrid(Graphics g) {
         for (Block b : grid) { 
          drawBlock(g, b.getX(), b.getY(), b.getWidth(), b.getHeight(), Color.WHITE, Color.BLACK);
}
}

     /*
     This function draws a rectangle at specified x and y coordinates and the box is given its own height, width,
     fill colour and outline colour. This function is to draw each individual block. 
     */
     private static void drawBlock(Graphics g, int newX, int newY, int newWidth, int newHeight, Color newFill, Color newOutline ) {
          g.setColor(newFill);
          g.fillRect(newX, newY, newWidth, newHeight); 
          g.setColor(newOutline );
          g.drawRect(newX, newY, newWidth, newHeight);
     }
}