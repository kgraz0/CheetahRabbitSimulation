import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

class RecordWalk extends JFrame implements Runnable {

	private Thread runThread; // use the Thread class
	private Graphics globalGraphics; // use the Graphics class
	public static Block cheetah; // create the Block object for the cheetah
	public static int length, posX, posY; // parameters for user input
	

	/*
	recordWalk constructor takes in the walk length, the starting position X,
	starting position Y that the user enters and then calls the constructor.
	- set the title
	- set the size of the window
	- draw the Grid object
	- set the relative location
	- make window not possible to be resized
	- make the window visible
	- set default frame operation to close on exit
	- set the given values to local variables 
	*/
	RecordWalk(int newWalkLength, int newPosX, int newPosY) {
		setTitle("Cheetah - Record a random walk");
		setPreferredSize(new Dimension(500, 500));
		new Grid();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.length = newWalkLength;
		this.posX = newPosX;
		this.posY = newPosY;
	}

	public void paint(Graphics g) {
		globalGraphics = g.create(); // create a new Graphics object

		cheetah = new Block(posX, posY, 20, 20, false); // create a Cheetah block at the given posX and posY positions

		if (runThread == null) {
			runThread = new Thread(this); // create a new thread for this class
			runThread.start(); // start the thread
		}
	}

    public void draw(Graphics g) {
     	Grid.drawGrid(g); // draw the grid 
     	Cheetah.drawCheetah(g, cheetah); // draw the cheetah onto the frame
     }

    public void run() {
    	/*
    	the for loop is used to control the number of times the 
    	cheetah moves, which is the length of the walk, the
    	cheetah is given a random direction based on its location
    	*/
     	for (int i = 0; i <= RecordWalk.length; i++) { // control the number of moves

     		Direction.walkPath(cheetah); // allow the cheetah to move
     	
     		draw(globalGraphics); // draw the Graphics onto the frame

     		try {
     			Thread.currentThread();
     			Thread.sleep(200); // set the movement

     		} catch (Exception e) {
     			e.printStackTrace();
     	}
     }
System.out.println("Finished walk. Saving walk to file.");
        
try {
          Thread.sleep(2000); // delay the program by 2 seconds
          System.exit(0); // exit the program
        } catch (Exception e) { // if there is an exception, just exit the program
          System.exit(0);
        }
}
}