import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

class RandomWalk extends JFrame implements Runnable {

	private Thread runThread;
	private Graphics globalGraphics; 
	public static Block cheetah, rabbit;
	
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
		globalGraphics = g.create(); 

		// x position, y position, pixel width, pixel height
		cheetah = new Block(5, 3, 20, 20);
		rabbit = new Block(15, 5, 20, 20);

		if (runThread == null) {
			runThread = new Thread(this);
			runThread.start();
		}
	}

    public void draw(Graphics g) {
     	Grid.drawGrid(g); // draw the grid (two-dimensional) from the Grid class
     	Cheetah.drawCheetah(g, cheetah);
     	Rabbit.drawRabbit(g, rabbit);
     }

    public void run() {
     	while (true) {
     		Direction.randomMove(cheetah, false);
     		Direction.randomMove(rabbit, false);
     		draw(globalGraphics); 

     		try {
     			Thread.currentThread();
     			Thread.sleep(200); // set the speed of the movement
     		} catch (Exception e) {
     			e.printStackTrace();
     		}
     	}
     }
}