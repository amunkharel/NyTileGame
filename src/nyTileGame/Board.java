package nyTileGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {

    private int numberOfTiles;

    private Tile [] tiles;

    private String colors[] = new String[] {
            "yellow", "red", "blue", "green", "purple" , "pink"};

    private String shapes[] = new String[] {
            "circle", "rectangle", "triangle", "polygon" };

    public Board(int numberOfTiles) {

        if(numberOfTiles % 2 != 0) {
            System.out.println("Cannot have odd number of tiles in the program \n");
            System.exit(0);
        }
        int counter = 0;

        this.numberOfTiles = numberOfTiles;

        int numberOfDesign = (3 * numberOfTiles)/2;


        ArrayList<Integer> list = new ArrayList<>();

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

        while(!list.isEmpty()){

            Collections.shuffle(list);



            for (int j = 0; j < 2; j++) {

                if(list.size() == 1){

                    this.tiles[list.get(0)].addDesignElement(design[counter]);

                    if(this.tiles[list.get(0)].getNumberOfDesignRemaining() == 0){
                        list.remove(0);
                    }

                }
                else{

                    this.tiles[list.get(j)].addDesignElement(design[counter]);

                    if(this.tiles[list.get(j)].getNumberOfDesignRemaining() == 0){
                        list.remove(j);
                    }
                }
            }
            counter++;

        }

    }

    public int getNumberOfTiles() {
        return this.numberOfTiles;
    }

    public Tile[] getTiles() {
        return this.tiles;
    }
}
