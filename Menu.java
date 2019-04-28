import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

	private static final String title =
	"\n Algorithms Coursework, Term II \n"+
	"       by karolis-GRAZULIS \n \n"+
	"\t********************************\n"+
	"\t1. Random Movement (Rabbit avoids Cheetah) \n"+
	"\t2. Record a walk \n"+
	"\t0. Exit \n"+
	"\t********************************\n"+
	"Please input a single digit (0-2):\n";

    /*
    Menu constructor that when called prints the 'title' String, sets up a BufferedReader
    for user input which will the be used to make a choice between 0 and 2 that is displayed
    in the console. A switch statement is used to call a method in any of the cases, depending
    on what number the user inputs. If the input is 0 then the program quits.

    Selection 1 - Random Walk, in this selection both the Cheetah and the Rabbit are random
    directions of Up, Down, Left or Right, have set boundaries to make sure that they never
    go out of bounds. Rabbit and Cheetah have different states where there are no boundaries
    around, they are able to move in any of the 4 directions, but if they hit a wall then their
    direction is limited to the opposite sides of the wall so it does not go off bounds.

    Selection 2 - Record a walk, in this selection the user is allowed to enter the length
    of the walk, the starting X coordinate and the starting Y coordinate where then the cheetah
    spawns and go into random direction however many times the length of the walk is.
    The walk (U, D, L, R) is then added into a file called savedWalks.txt where later
    they could be compared.
    */
	Menu() {
		int selected = -1;
		while (selected != 0) {
			System.out.println(title);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			try {
				selected = Integer.parseInt(in.readLine()); // allow user to input an integer

				System.out.println(selected);

				switch(selected) {
					case 1: q1(); // call q1 function
					break;
					case 2: q2(); // call q2 function
					break;
				}

			} catch (Exception e) {
				System.out.println("exception");
			}
		} 
		System.out.println("Bye!");
	}

	public static void main(String[] args) {
		new Menu(); // create a new Menu class object
	}
	

	private void q1() {
		new RandomWalk(); // create a new RandomWalk class object
	}

	private static void q2() {
		/*
		 Call the userInput function with parameters asking them for input
		 since the function returns an int, I store these returned values
		 that user entered in new variables
		*/
		int walkLength = userInput("Please enter the length of the walk: ", 1, 10); 
		int posX = userInput("Please enter the X coordinate (1 - 20): ", 1, 20);
		int posY = userInput("Please enter the Y coordinate (1 - 20): ", 1, 20);
		new RecordWalk(walkLength, posX, posY);
	}

	public static int userInput(String newInstruction, int minLimit, int maxLimit) {

		System.out.println(newInstruction);
     	Scanner scanner = new Scanner(System.in); // create a new scanner object

     	int userInput = 0; 

      /* 
      Make sure that the user enters correct input before moving on, 
      otherwise it won't be possible to correctly set the walk.
      If there is a mismatch exception (not an integer was entered),
      then the user is prompted to type another character until an
      integer is entered.
      */
      do {
        try {
        userInput = scanner.nextInt();
        } catch (InputMismatchException e) {
        	System.out.println("You have entered invalid input. Please try again");
        	scanner.next();
        }

        if (userInput < minLimit || userInput > maxLimit) {
        	System.out.println("Minimum length is " + minLimit + " and maximum length is " + maxLimit + "." + " Please try again.");
        }
    } while (userInput < minLimit || userInput > maxLimit);

    return userInput; // return the value that user entered
	}
}