import java.util.Random;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;

class Direction {
	
	public static int direction = 0;
	public static final int U = 1;
	public static final int D = 2;
	public static final int L = 3;
	public static final int R = 4;
    public static final int UR = 5;
    public static final int DR = 6;
    public static final int DL = 7;
    public static final int UL = 8;

	static PrintWriter outputFile;

    public static void moveDirection(Block p, boolean isAWalk) {

        if (p.getY() < 2) { // check whether the cheetah or the rabbit hit the upper wall
            direction = chooseDirection(2, 3, 4, 6, 7); // Allowed movements: Down, Left, Right, lower Right, lower Left
        } else if (p.getY() > Grid.numBlockH - 2) { // check whether cheetah or rabbit hit south wall
            direction = chooseDirection(1, 3, 4, 5, 8); // Allowed movements: Up, Left, Right, upper Right, upper Left
        } else if (p.getX() > Grid.numBlockW - 2) { // check whether cheetah or rabbit hit eastern wall
            direction = chooseDirection(1, 2, 3, 7, 8); // Allowed movements: Up, Down, Left, lower Left, upper Left
        } else if (p.getX() < 1) { // check whether cheetah or rabbit hit western wall
            direction = chooseDirection(1, 2, 4, 5, 6); // Allowed movements: Up, Down, Right, upper Right, lower Right
        }

        ArrayList<String> movedPosition = new ArrayList<String>();

        switch (direction) {
            case Direction.U:
            p.setY(p.getY()-1); // decrease Y position if block is going up
            movedPosition.add("U");
            break;
            case Direction.D:
            p.setY(p.getY()+1); // increase Y position if block is going up
            movedPosition.add("D");
            break;
            case Direction.L:
            p.setX(p.getX()-1); // decrease X position if block is going left
            movedPosition.add("L");
            break;
            case Direction.R:
            p.setX(p.getX()+1); // increase X position if block is going right
            movedPosition.add("R");
            break;
            case Direction.UR:
            p.setX(p.getX()+1); // increase X position, decrease Y to go upper right
            p.setY(p.getY()-1);
            movedPosition.add("UR");
            break;
            case Direction.DR:
            p.setX(p.getX()+1); // increase X position, increase Y to go lower right
            p.setY(p.getY()+1);
            movedPosition.add("DR");
            break;
            case Direction.DL:
            p.setX(p.getX()-1); // decrease X position, increase Y to go lower left
            p.setY(p.getY()+1);
            movedPosition.add("DL");
            break;
            case Direction.UL:
            p.setX(p.getX()-1); // decrease X position, decrease Y to go upper left
            p.setY(p.getY()-1);
            movedPosition.add("UL");
            break;
        }

        if (isAWalk == true) {
        for (String item : movedPosition) {
         outputFile.print(item); // add each movement to file
         outputFile.flush();
     }
     outputFile.append("\n");
     outputFile.close();
 }
    
    }
     public static void randomMove(Block p, boolean isAWalk) {

     	Random random = new Random(); 

		direction = random.nextInt(8) + 1; // select a random direction between 0 and 4 (no direction = 0, Up = 1, Down = 2, Left = 3, Right = 4)

        if (isAWalk == true) {
            try {
        outputFile = new PrintWriter(new FileWriter("savedWalks.txt", true)); // set the where the walks will be added to
        } catch (Exception e) {
            System.out.println("Something went wrong. File was not created.");
        } 

        moveDirection(p, isAWalk);
        } else {
        moveDirection(p, isAWalk);
     
        // check whether the Cheetah caught the rabbit
        if (RandomWalk.cheetah.getX() == RandomWalk.rabbit.getX() && RandomWalk.cheetah.getY() == RandomWalk.rabbit.getY()) {
        	System.out.println("Cheetah caught the rabbit!");
        	System.out.println("Setting new positions...");

       // reset positions to random if cheetah caught the rabbit
        RandomWalk.cheetah.setX(random.nextInt(19) + 1);
        RandomWalk.cheetah.setY(random.nextInt(19) + 1);
        RandomWalk.rabbit.setX(random.nextInt(19) + 1);
        RandomWalk.rabbit.setY(random.nextInt(19) + 1);
        }
    }
     }

     public static int chooseDirection(int value1, int value2, int value3, int value4, int value5) {
            
            ArrayList<Integer> al = new ArrayList<Integer>();

            Random random = new Random();
            al.add(value1); 
            al.add(value2); 
            al.add(value3); 
            al.add(value4); 
            al.add(value5); 
            direction = al.get(random.nextInt(al.size())); // select a random value (direction) from the elements in the arraylist
            al.clear();

            return direction;
     }
}