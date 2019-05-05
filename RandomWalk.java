import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

class RandomWalk extends JFrame implements Runnable {

	private Thread runThread; // use the Thread class
	private Graphics globalGraphics; // use the Graphics class
	public static Block cheetah, rabbit; // create cheetah and rabbit of Block class
	

	/*
	This constructor:
	- sets the title of the program
	- sets the size of the window
	- create a new Grid by calling the Grid class constructor
	- set the window to not be resizeable
	- set the relative location
	- set the window the be visible 
	- set to close the frame when the window is closed
	*/
	RandomWalk() {
		setTitle("Cheetah and Rabbit");
		setPreferredSize(new Dimension(500, 500));
		new Grid();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		globalGraphics = g.create(); // create a new Graphics object

		cheetah = new Block(5, 3, 20, 20); // create a new Block for cheetah at x = 5, y = 3 and 20 pixels large
		rabbit = new Block(15, 5, 20, 20); // create a new Block for rabbit at x = 15, y = 5 and 20 pixels large

		if (runThread == null) {
			runThread = new Thread(this); // create a new thread for this class
			runThread.start(); // run the thread
		}
	}

    public void draw(Graphics g) {
     	Grid.drawGrid(g); // draw the grid (two-dimensional) from the Grid class
     	Cheetah.drawCheetah(g, cheetah); // draw the Cheetah image and its specified location
     	Rabbit.drawRabbit(g, rabbit); // draw the Rabbit image and its specified location
     }

    public void run() {
     	while (true) {
     		Direction.randomMove(cheetah, false); // call the movement function to allow for the cheetah to move U, D, L, R
     		Direction.randomMove(rabbit, false); // call the movement function to allow for the rabbit to move U, D, L, R
     		draw(globalGraphics); // draw all the items onto the frame

     		try {
     			Thread.currentThread();
     			Thread.sleep(200); // set the speed of the movement

     		} catch (Exception e) { // catch in case there is an exception
     			e.printStackTrace();
     		}
     	}
     }
}