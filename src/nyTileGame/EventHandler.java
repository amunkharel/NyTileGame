package nyTileGame;


import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private int tileNumber;
    private Board board;

    public EventHandler(double x, double y, Board board)
    {
        this.board = board;
        int xCor = (int) x/80;
        int yCor = (int) y/80;


        tileNumber = 7*yCor + xCor;



        //Test Code
        Tile [] tile = board.getTiles();
        Tile current_tile;
        Tile clicked_tile;
        List<DesignInsideTile> current_tile_designs = new ArrayList<>();
        List<DesignInsideTile> click_tile_designs = new ArrayList<>();


        System.out.println("Initially");
        System.out.println(" ");
        if(board.isClicked()){
            current_tile = tile[board.getCurrentTile()];

            System.out.println("Current Tile Number " + board.getCurrentTile() + " ");

            System.out.println("Number of design remaining: " + current_tile.getNumberOfDesignRemaining());
            current_tile_designs = current_tile.getElementsInsideTile();


            for(DesignInsideTile design1 : current_tile_designs)
            {
                System.out.println(design1.getColor());
                System.out.println(design1.getShape());
            }


        }

        clicked_tile = tile[tileNumber];

        System.out.println("Clicked Tile Number " + tileNumber + " ");

        System.out.println("Number of design remaining: " + clicked_tile.getNumberOfDesignRemaining());
        click_tile_designs = clicked_tile.getElementsInsideTile();


        for(DesignInsideTile design1 : click_tile_designs)
        {
            System.out.println(design1.getColor());
            System.out.println(design1.getShape());
        }


    }

    public void handleClick() {
        Tile [] tile = board.getTiles();
        int i = 0;
        int j = 0;
        boolean canLoop = true;

        List<Integer> iValues = new ArrayList<>();
        List<Integer> jValues = new ArrayList<>();

        List<DesignInsideTile> current_tile_designs = new ArrayList<>();

        List<DesignInsideTile> clicked_tile_designs = new ArrayList<>();

        boolean successfulClick = false;

        if(tile[tileNumber].getNumberOfDesignRemaining() == 3) {
            System.out.println("Please select a non-empty tile");
            return;
        }

        if(board.isClicked() == false) {
            board.clickBoard(tileNumber);
        }

        else {
            if(board.getCurrentTile() == tileNumber) {
                System.out.println("Please do not click the same tile at the same time. Please choose another tile");
            }

            else {
                current_tile_designs = tile[board.getCurrentTile()].getElementsInsideTile();
                clicked_tile_designs = tile[tileNumber].getElementsInsideTile();

                int number_current_tile_designs = current_tile_designs.size();
                int number_clicked_tile_designs = clicked_tile_designs.size();

                DesignInsideTile [] current_designs = new DesignInsideTile[number_current_tile_designs];
                DesignInsideTile [] clicked_designs = new DesignInsideTile[number_clicked_tile_designs];

                for(DesignInsideTile design1 : current_tile_designs)
                {
                    current_designs[i] = design1;
                    i++;
                }

                for(DesignInsideTile design2 : clicked_tile_designs)
                {
                    clicked_designs[j] = design2;
                    j++;
                }

                for(i = 0; i < number_current_tile_designs; i++)
                {

                    for(j = 0; j < number_clicked_tile_designs; j++)
                    {
                        if(iValues.contains(i) || jValues.contains(j)) {
                            canLoop = false;
                        }
                        if(current_designs[i].equals(clicked_designs[j]) && canLoop)
                        {
                            successfulClick = true;
                            tile[board.getCurrentTile()].removeDesignElement(current_designs[i]);
                            tile[tileNumber].removeDesignElement(clicked_designs[j]);
                            iValues.add(i);
                            jValues.add(j);

                        }
                        canLoop = true;
                    }

                }

            }

            //Test Code
            System.out.println("After looping around");
            System.out.println(" ");

            System.out.println("Current Tile Number = " + board.getCurrentTile());

            System.out.println("Number of Design Remaining: " + tile[board.getCurrentTile()].getNumberOfDesignRemaining());

            for(DesignInsideTile design1: tile[board.getCurrentTile()].getElementsInsideTile())
            {
                System.out.println(design1.getColor());
                System.out.println(design1.getShape());
            }

            System.out.println("Clicked Tile Number = " + tileNumber );
            System.out.println("Number of Design Remaining:  " + tile[tileNumber].getNumberOfDesignRemaining());

            for(DesignInsideTile design2: tile[tileNumber].getElementsInsideTile())
            {
                System.out.println(design2.getColor());
                System.out.println(design2.getShape());
            }



            if(tile[tileNumber].getNumberOfDesignRemaining() >= 3) {
                board.unclickBoard();
                return;
            }




            //Finish Test Code

            if(successfulClick) {
                board.clickBoard(tileNumber);
            }

            if(!successfulClick) {
                System.out.println("The clicked tile does not have the design");
            }


        }
    }

    public int getTileNumber() {
        return tileNumber;
    }

}
