## Installation
Compile and run Menu.java.  
Make sure that the environment you are using supports user input (such as CMD) and GUIs.

## How it works
The game simulates two automated players, Cheetah and Rabbit, on a 2D grid with Up, Down, Left, Right or diagonal movements.

Upon running, you are presented with a menu:  
![Selection menu](/READMEimages/menuSelection.png)

This is where the user the option by entering 0, 1 or 2.

### Exit (Option 0)
This exits the program.

### Random movement (Option 1)
The grid window pops up and the Cheetah and Rabbit start randomly moving on the grid:  
![Cheetah and Rabbit movement](/READMEimages/rabbitCheetahGIF.gif)

When the Cheetah catches the Rabbit (both up on the same tile), the positions reset and it starts again:
![Rabbit caught](/READMEimages/caughtRabbit.png)

To exit at any time, press X to close the program top-right.

### Record a walk (Option 2)
![Option 2 selection](/READMEimages/recordWalk.png)  
Enter further options:  
* Length of the walk - times to move  
* X starting coordinate  
* Y starting coordinate  

The movements will then be saved to the savedWalks.txt file:  
![Updated movement text file](/READMEimages/savedWalks.png)



