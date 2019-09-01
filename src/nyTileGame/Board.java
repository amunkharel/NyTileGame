package nyTileGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Project 1, Class to handle the board backend logic
 * @version Date 2019-08-30
 * @author Amun Kharel
 *
 *
 */

public class Board {

    /** Number of tiles in the board*/
    private int numberOfTiles;

    /** Tiles object for the game*/
    private Tile [] tiles;

    /** To check if the board has been clicked before*/
    private boolean isClicked = false;

    /** Current Tile which is clicked*/
    private int currentTile;

    /** Colors available for the game*/
    private String colors[] = new String[] {
            "yellow", "red", "blue", "green", "purple" , "pink"};

    /** Shapes available for the game*/
    private String shapes[] = new String[] {
            "curved_rectangle", "rectangle", "vertical_rectangle", "oval", "vertical_oval" };


    /**
     * Constructor of board object
     *
     * @param int numberOfTiles, number of Tiles in the board
     */
    public Board(int numberOfTiles) {

        if(numberOfTiles % 2 != 0) {
            System.out.println("Cannot have odd number of tiles in the program \n");
            System.exit(0);
        }

        if(numberOfTiles < 4 || numberOfTiles > 50) {
            System.out.println("Number of Tiles should be between 20 and 50 \n");
            System.exit(0);
        }

        int counter = 0;

        this.numberOfTiles = numberOfTiles;


        int numberOfDesign = (3 * numberOfTiles)/2;


        ArrayList<Integer> list = new ArrayList<>();

        ArrayList<Integer> list_with_one_remaining = new ArrayList<>();

        ArrayList<Integer> list_with_two_remaining = new ArrayList<>();

        Random rand = new Random();

        int randomNumberColor;

        int randomNumberShape;

        this.tiles = new Tile[numberOfTiles];

        for (int m = 0; m < this.tiles.length; m ++){
            this.tiles[m] = new Tile();
        }

        DesignInsideTile [] design = new DesignInsideTile[numberOfDesign];

        for(int k = 0; k < design.length; k++){
            randomNumberColor = rand.nextInt(colors.length);
            randomNumberShape = rand.nextInt(shapes.length);

            design[k] = new DesignInsideTile(colors[randomNumberColor], shapes[randomNumberShape]);


        }

        for (int i = 0; i < numberOfTiles; i++) {
            list.add(new Integer(i));
        }


        //adds one design element to all the tiles until there are no tiles left
        for(int a = 0; a < numberOfTiles/2; a ++) {
            Collections.shuffle(list);

            for (int j = 0; j < 2; j++) {


                if(list.size() == 1)
                {

                    this.tiles[list.get(0)].addDesignElement(design[counter]);

                    list_with_two_remaining.add(list.get(0));

                }

                else
                {

                    this.tiles[list.get(j)].addDesignElement(design[counter]);

                    list_with_two_remaining.add(list.get(j));

                    list.remove(j);


                }

            }


            counter++;
        }


        //adds second design element to all the tiles until there are no tiles left
        for(int b = 0; b < numberOfTiles/2; b ++) {
            Collections.shuffle(list_with_two_remaining);

            for (int j = 0; j < 2; j++) {


                if(list_with_two_remaining.size() == 1)
                {

                    this.tiles[list_with_two_remaining.get(0)].addDesignElement(design[counter]);

                    list_with_one_remaining.add(list_with_two_remaining.get(0));

                }

                else
                {

                    this.tiles[list_with_two_remaining.get(j)].addDesignElement(design[counter]);

                    list_with_one_remaining.add(list_with_two_remaining.get(j));

                    list_with_two_remaining.remove(j);


                }

            }


            counter++;
        }



        //adds third design element to all the tiles until there are no tiles left
        for(int c = 0; c < numberOfTiles/2; c ++) {
            Collections.shuffle(list_with_one_remaining);

            for (int j = 0; j < 2; j++) {


                if(list_with_one_remaining.size() == 1)
                {

                    this.tiles[list_with_one_remaining.get(0)].addDesignElement(design[counter]);

                }

                else
                {

                    this.tiles[list_with_one_remaining.get(j)].addDesignElement(design[counter]);

                    list_with_one_remaining.remove(j);
                }

            }


            counter++;
        }

        //if there are two designs assigned randomly in the same tile, it removes the designs to make the game complete
        for(int k = 0; k < numberOfTiles; k++) {
            if(this.tiles[k].getElementsInsideTile().get(0).equals(this.tiles[k].getElementsInsideTile().get(1))){
                this.tiles[k].removeDesignElement(this.tiles[k].getElementsInsideTile().get(0));
                this.tiles[k].removeDesignElement(this.tiles[k].getElementsInsideTile().get(0));
            }

            else if(this.tiles[k].getElementsInsideTile().get(0).equals(this.tiles[k].getElementsInsideTile().get(2))){
                this.tiles[k].removeDesignElement(this.tiles[k].getElementsInsideTile().get(0));
                this.tiles[k].removeDesignElement(this.tiles[k].getElementsInsideTile().get(1));
            }

            else if(this.tiles[k].getElementsInsideTile().get(1).equals(this.tiles[k].getElementsInsideTile().get(2))){
                this.tiles[k].removeDesignElement(this.tiles[k].getElementsInsideTile().get(1));
                this.tiles[k].removeDesignElement(this.tiles[k].getElementsInsideTile().get(1));
            }
        }


    }

    /**
     * Clicks the given tile
     *
     * @param int tileNumber, Number of the tile in array
     */
    public void clickBoard(int tileNumber) {
        this.isClicked = true;
        this.currentTile = tileNumber;

    }

    /**
     * Unclicks the board
     */
    public void unclickBoard() {
        this.isClicked = false;
    }

    /**
     * Clicks the board
     */
    public boolean isClicked() {
        return isClicked;
    }

    /**
     * Gets the current tile which is clicked
     */
    public int getCurrentTile() {
        return this.currentTile;
    }

    /**
     * Get Number of tiles present in the board
     */
    public int getNumberOfTiles() {
        return this.numberOfTiles;
    }

    /**
     * returns all the tile objects of the board
     */
    public Tile[] getTiles() {
        return this.tiles;
    }
}
