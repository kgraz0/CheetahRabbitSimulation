import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

class RecordWalk extends JFrame implements Runnable {

	private Thread runThread;
	private Graphics globalGraphics;
	public static Block cheetah;
	public static int length, posX, posY;
	

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
		globalGraphics = g.create();

		// x position, y position, pixel width, pixel height
		cheetah = new Block(posX, posY, 20, 20);

		if (runThread == null) {
			runThread = new Thread(this);
			runThread.start();
		}
	}

    public void draw(Graphics g) {
     	Grid.drawGrid(g);
     	Cheetah.drawCheetah(g, cheetah); 
     }

    public void run() {
    	/*
    	the for loop is used to control the number of times the 
    	cheetah moves, which is the length of the walk, the
    	cheetah is given a random direction based on its location
    	*/
     	for (int i = 0; i <= RecordWalk.length; i++) {

     		Direction.randomMove(cheetah, true);
     	
     		draw(globalGraphics);

     		try {
     			Thread.currentThread();
     			Thread.sleep(200); 

     		} catch (Exception e) {
     			e.printStackTrace();
     	}
     }
System.out.println("Finished walk. Saving walk to file.");
        
try {
          System.exit(0);
        } catch (Exception e) { // if there is an exception, just exit the program
          System.exit(0);
        }
}
}