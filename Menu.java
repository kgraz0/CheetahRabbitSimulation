import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

	private static final String title =
	"\n\t********************************\n"+
	"\t1. Random Movement (Rabbit avoids Cheetah) \n"+
	"\t2. Record a walk \n"+
	"\t0. Exit \n"+
	"\t********************************\n"+
	"Please input a single digit (0-2):\n";

	Menu() {
		int selected = -1;

		System.out.println(title);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
				selected = Integer.parseInt(in.readLine()); // allow user to input an integer

				switch(selected) {
					case 0: System.exit(0);
					case 1: q1();
					break;
					case 2: q2(); 
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid selection. Please try again.");
			}
	}

	public static void main(String[] args) {
		new Menu();
	}
	

	private void q1() {
		new RandomWalk();
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

    return userInput;
	}
}