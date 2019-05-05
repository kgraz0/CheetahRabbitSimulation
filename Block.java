import java.util.ArrayList;

class Block {

	private int x, y, width, height;

	public Block(int newX, int newY, int newWidth, int newHeight) {
		this.x = newX;
		this.y = newY;
		this.width = newWidth;
		this.height = newHeight;
	}

	public Block (Block newBlock) {
		this.x = newBlock.x;
		this.y = newBlock.y;
		this.width = newBlock.width;
		this.height = newBlock.height;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}
}