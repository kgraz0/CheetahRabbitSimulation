import java.util.ArrayList;

class Block {

	private int x, y, width, height; // x, y coordinates and width, height of each individual block
	public static boolean isVisited; // boolean for individual block to see whether it has been visited 
	public Block parent = null; // parent of the Block
	//public static ArrayList<Block> neighbours = new ArrayList<Block>(); 


    /*
    The block constructor that initializes X, Y, width, height and whether it has been visited
    */
	public Block(int newX, int newY, int newWidth, int newHeight, boolean newisVisited) {
		this.x = newX;
		this.y = newY;
		this.width = newWidth;
		this.height = newHeight;
		this.isVisited = newisVisited;
	}

	public Block (Block newBlock) {
		this.x = newBlock.x;
		this.y = newBlock.y;
		this.width = newBlock.width;
		this.height = newBlock.height;
		this.isVisited = newBlock.isVisited;
	}

	public int getX() {
		return x; // return x position for individual block
	}
	public int getY() {
		return y; // return y position for individual block
	}
	public int getWidth() {
		return width; // return the width of the individual block
	}
	public int getHeight() {
		return height; // return the height of the individual block
	}

	public Block getParent(){
		return parent; // return the parent Block
	}

	public void setX(int newX) {
		this.x = newX; // set the x position for individual block
	}

	public void setY(int newY) {
		this.y = newY; // set the y position for individual block
	}
}