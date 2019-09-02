# New York Tile Game

## Game Play

### Starting the file
To start the game, you can simply go to the Main class and compile and run the program. <br>
Another way to start the game is open the tileGame1.0_akharel.jar file <br>
If you want to change the size of the board, go to the Main class and change the size of numberOfTiles variable
<br>
The board size will dynamically resize itself

### How to Play
To play the game, we need to start the game and click on our first tile. 
We need to click another tile that has the same design. If another tile
does not have the same design, our score will be reset to zero. However,
if we do get the design, our point is incremented each time. <br>

Some of the designs are hidden inside another design. Therefore, we need
to be careful to choose the easy ones first. One assurance of this game is 
that the game will always complete if you look for the designs in the tile carefully. 

## Description of Program Internals

### Description of Classes
The game has 6 classes: <br>

1) Board- Board class helps us create a board object where we can store array of tile object. 
It also help us design design elements in each tile, which will help us reach the end of the game.
All design elements in the tile will have it's pair so that the game will reach it's conclusion

2) Tile - Tile class is used to store 3 designs 

3) DesignInsideTile - Design Inside Tile will have shape and a color of the design element

4) Display- Display is the GUI of the board, which will dynamically update the board if the 
backend of the board object is changed

5) Score- Score class will keep track of current score and longest streak score. 
This class will also update the text present in the GUI displaying current score and longest streak score

6) EventHandler- EventHandler class will take in a click from the user in the board and use that 
click to update the board objects, its tile and its design elements. 


### Algorithm Details

1) Adding pair of design elements in the board-  <br>
a) First we need to have even number of tiles on the board. If there are odd number of tiles 
in the board, we might not have a pair of design element to finish the game
b) First, we add one pair of element on all the tiles of the board
c) Then, we add another pair of design element on all the tiles of the board
d) Then, we add third pair of design element on all the tiles of the board
e) If the same design element exists on the same tile, then the design elements will be removed to make sure that the game completes



## Know Bugs and feature requests
There are no  explicit bugs in the program since the game has always reached its completion in 10 trials with different sizes of board ranging from 20 tiles to 50 tiles. However, there are certain shortcomings in the program <br>
1) Some tiles might not have 3 design elements, which is rare, because the way algorithm is set. 
If my code randomly  puts two designs with same shape and same color in the same tile, it will remove both designs to make sure game reaches its completion
2) This game is pretty dynamic and size of board can be changed with ease. However, adding 4th design 
inside the program might be a hassle because of lack of proper design planning and shortage of time. 
3) If you click inside the canvas that has no tile, the first tile will be clicked. Also, this is the way I setup my program 
to remove any unwanted exception. However, this could have been handled properly. 
However, on the plus side, size of canvas is pretty well planned out. 


## References
I did not explicitly use any resource to write my code. I mostly used Brooke's lecture on JavaFx to learn canvas painting 
and animation timing. <br>
StackOverflow and google was used to debug my errors

## Author - Amun Kharel

## Date - 2019/08/30