import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.io.PrintWriter;

class Direction {
	
	public static final int noDirection = 0;
	public static final int U = 1;
	public static final int D = 2;
	public static final int L = 3;
	public static final int R = 4;
    public static final int UR = 5;
    public static final int DR = 6;
    public static final int DL = 7;
    public static final int UL = 8;
	private static int direction = noDirection;

	File myFile = null;; // set to null for now, but make it global
	FileWriter fw = null; // set to null for now, but make it global
	static PrintWriter outputFile;

    public static void moveDirection(Block p) {

        if (p.getY() < 2) { // check whether the cheetah or the rabbit hit the upper wall
            direction = chooseDirection(2, 3, 4, 6, 7); // set state to only allow direction Down, Left, Right, lower Right, lower Left
        } else if (p.getY() > Grid.numBlockH - 2) { // check whether cheetah or rabbit hit south wall
            direction = chooseDirection(1, 3, 4, 5, 8); // set state to only allow direction Up, Left, Right, upper Right, upper Left
        } else if (p.getX() > Grid.numBlockW - 2) { // check whether cheetah or rabbit hit eastern wall
            direction = chooseDirection(1, 2, 3, 7, 8); // set state to only allow direction Up, Down, Left, lower Left, upper Left
        } else if (p.getX() < 1) { // check whether cheetah or rabbit hit western wall
            direction = chooseDirection(1, 2, 4, 5, 6); // set state to only allow direction Up, Down, Right, upper Right, lower Right
        }

        switch (direction) {
            case Direction.U:
            p.setY(p.getY()-1); // decrease Y position if block is going up
            break;
            case Direction.D:
            p.setY(p.getY()+1); // increase Y position if block is going up
            break;
            case Direction.L:
            p.setX(p.getX()-1); // decrease X position if block is going left
            break;
            case Direction.R:
            p.setX(p.getX()+1); // increase X position if block is going right
            break;
            case Direction.UR:
            p.setX(p.getX()+1); // increase X position, decrease Y to go upper right
            p.setY(p.getY()-1);
            break;
            case Direction.DR:
            p.setX(p.getX()+1); // increase X position, increase Y to go lower right
            p.setY(p.getY()+1);
            break;
            case Direction.DL:
            p.setX(p.getX()-1); // decrease X position, increase Y to go lower left
            p.setY(p.getY()+1);
            break;
            case Direction.UL:
            p.setX(p.getX()-1); // decrease X position, decrease Y to go upper left
            p.setY(p.getY()-1);
            break;
        }

    }
     public static void randomMove(Block p) {

     	Random random = new Random(); // create a random Object

		direction = random.nextInt(5); // select a random direction between 0 and 4 (no direction = 0, Up = 1, Down = 2, Left = 3, Right = 4)

        /*
        Check whether the paths of Cheetah and Rabbit meet, if it's true then the Cheetah has caught the rabbit
        */
        if (RandomWalk.cheetah.getX() == RandomWalk.rabbit.getX() && RandomWalk.cheetah.getY() == RandomWalk.rabbit.getY()) {
        	System.out.println("Cheetah caught the rabbit!");
        	System.out.println("Setting new positions...");
          try {
          Thread.sleep(5000); // delay by 5 seocnds
        } catch (Exception e) {
          System.out.println(e);
        }

       /*
       If cheetah has caught the rabbit, reset their positions
       to random coordinates on the grid
       */
        RandomWalk.cheetah.setX(random.nextInt(19) + 1);
        RandomWalk.cheetah.setY(random.nextInt(19) + 1);
        RandomWalk.rabbit.setX(random.nextInt(19) + 1);
        RandomWalk.rabbit.setY(random.nextInt(19) + 1);
        }

        moveDirection(p);
     }

     public static void walkPath(Block p) {
     	try {
     	outputFile = new PrintWriter(new FileWriter("savedWalks.txt", true)); // set the where the walks will be added to
        } catch (Exception e) {

        }

     	LinkedList<String> ll = new LinkedList<String>(); // create a new Linked List

        Random random = new Random(); // create a new random object

		direction = random.nextInt(5) + 1; // allow movement from 1 to 4 (Up, Down, Left, Right)

        if (p.getY() < 2) {
            direction = chooseDirection(2, 3, 4, 6, 7);
        } else if (p.getY() > Grid.numBlockH - 2) {
            direction = chooseDirection(1, 3, 4, 5, 8);
        } else if (p.getX() > Grid.numBlockW - 2) {
            direction = chooseDirection(1, 2, 3, 7, 8);
        } else if (p.getX() < 1) {
            direction = chooseDirection(1, 2, 4, 5, 6);
        }

     	switch (direction) {
     		case Direction.U:
            p.setY(p.getY()-1);
            System.out.println("Adding U to the walk.");
            ll.add("U"); // add 'U' as position to linked list
     		break;
     		case Direction.D:
            p.setY(p.getY()+1);
            System.out.println("Adding D to the walk.");
            ll.add("D"); // add 'D' as position to linked list
     		break;
     		case Direction.L:
            p.setX(p.getX()-1);
            System.out.println("Adding L to the walk.");
            ll.add("L"); // add 'L' as position to linked list
     		break;
     		case Direction.R:
            p.setX(p.getX()+1);
            System.out.println("Adding R to the walk.");
            ll.add("R"); // add 'R' as position to linked list
     		break;
            case Direction.UR:
            p.setX(p.getX()+1);
            p.setY(p.getY()-1);
            System.out.println("Adding UR to the walk.");
            ll.add("UR"); // add 'UR' as position to linked list
            break;
            case Direction.DR:
            p.setX(p.getX()+1);
            p.setY(p.getY()+1);
            System.out.println("Adding DR to the walk.");
            ll.add("DR"); // add 'DR' as position to linked list
            break;
            case Direction.DL:
            p.setX(p.getX()-1);
            p.setY(p.getY()+1);
            System.out.println("Adding DL to the walk.");
            ll.add("DL"); // add 'DL' as position to linked list
            break;
            case Direction.UL:
            p.setX(p.getX()-1);
            p.setY(p.getY()-1);
            System.out.println("Adding UL to the walk.");
            ll.add("UL"); // add 'UL' as position to linked list
            break;
     	}

     	for (String item : ll) {
	     outputFile.print(item); // add each item of the linked list to the file to show the full path
	     outputFile.flush();
	 }
	 outputFile.append("\n");
	 outputFile.close(); // close the stream
}

     public static int chooseDirection(int value1, int value2, int value3, int value4, int value5) {
            
            ArrayList<Integer> al = new ArrayList<Integer>(); // create a new arraylist

            Random random = new Random(); // create a random object
            al.add(value1); // add value to arraylist 
            al.add(value2); // add value2 to arraylist
            al.add(value3); // add value3 to arraylist
            al.add(value4); // add value4 to arraylist
            al.add(value5); // add value5 to arraylist
            direction = al.get(random.nextInt(al.size())); // select a random value (direction) from the elements in the arraylist
            al.clear(); // clear the arraylist 

            return direction; // return the direction value (integer)
     }
}