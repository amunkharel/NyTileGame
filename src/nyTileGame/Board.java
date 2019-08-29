package nyTileGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board {

    private int numberOfTiles;

    private Tile [] tiles;

    private boolean isClicked = false;

    private int currentTile;

    private String colors[] = new String[] {
            "yellow", "red", "blue", "green", "purple" , "pink"};

    private String shapes[] = new String[] {
            "curved_rectangle", "rectangle", "vertical_rectangle", "oval", "vertical_oval" };

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

    public void clickBoard(int tileNumber) {
        this.isClicked = true;
        this.currentTile = tileNumber;

    }

    public void unclickBoard() {
        this.isClicked = false;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public int getCurrentTile() {
        return this.currentTile;
    }

    public int getNumberOfTiles() {
        return this.numberOfTiles;
    }

    public Tile[] getTiles() {
        return this.tiles;
    }
}
