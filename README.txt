
## Title

This is the first version of the Cheetah and Rabbit game that I developed individually as part of my assignment for University.

## Installation

All you need to run to do is download the files, compile them all and make sure that the environment you are using to run it supports user input and GUIs. Navigating to, and running it through command prompt will work. 
 
## How it works

The game simulates two automated players, Cheetah and Rabbit, on a 2D grid where they are both able to move Up, Down, Left, Right or diagonally. There is a border set to make sure that neither of them go out of bounds. They both move in random directions until the Cheetah eventually catches the Rabbit by both ending up on the same tile. Although in the updated version, the Rabbit will move the opposite way if there is a Cheetah on the same horizontal or vertical line, thus making it harder to catch. If the user decides to select the second option in the menu, they are able to specify the length of walk (amount of moves) and the spawning location (X and Y) of the cheetah. In this mode, the movement of Cheetah is recorded and saved into the SavedWalks.txt file.