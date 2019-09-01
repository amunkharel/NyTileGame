package nyTileGame;


import java.util.ArrayList;
import java.util.List;

/**
 * Project 1, Class to handle a mouse click on a certain tile element
 * @version Date 2019-08-30
 * @author Amun Kharel
 *
 *
 */

public class EventHandler {

    /** Tile Number which is being clicked*/
    private int tileNumber;

    /** Board object of the game*/
    private Board board;

    /** Score object of the game*/
    private Score score;

    /**
     * Constructor to initialize the event handler object
     *
     * @param double x, the x pixel in the canvas which is clicked
     * @param double y, the y pixel in the canvas which is clicked
     * @param Board board, the board object for the game
     * @param Score score, score object to handle scoring events
     */

    public EventHandler(double x, double y, Board board, Score score)
    {
        this.board = board;
        int xCor = (int) x/80;
        int yCor = (int) y/80;

        this.score = score;


        //returns a tileNumber by taking the x and y co-ordinates
        tileNumber = 7*yCor + xCor;

        int board_tileNumber = board.getNumberOfTiles();

        if(tileNumber > board_tileNumber - 1)
        {
            tileNumber = 0;
        }


    }

    /**
     * Handles the click.
     * Checks if the board is already clicked, if not clicks a certain tile
     * if already clicked then uses the click in the tile to see if it is the same time.
     * If it is same tile, return.
     * Else looks for same design to remove the design
     *
     */

    public void handleClick() {
        Tile [] tile = board.getTiles();
        int i = 0;
        int j = 0;
        boolean canLoop = true;
        int currentRun = 0;

        List<Integer> iValues = new ArrayList<>();
        List<Integer> jValues = new ArrayList<>();

        List<DesignInsideTile> current_tile_designs = new ArrayList<>();

        List<DesignInsideTile> clicked_tile_designs = new ArrayList<>();

        boolean successfulClick = false;

        //Checks if a tile is non-empty
        if(tile[tileNumber].getNumberOfDesignRemaining() == 3) {
            System.out.println("Please select a non-empty tile");
            return;
        }

        //checks if the board is already clicked or not
        if(board.isClicked() == false) {
            board.clickBoard(tileNumber);
        }

        else {

            //checks if the clicked tile is the one we just clicked before
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
                            score.setCurrentRun();

                        }
                        canLoop = true;
                    }

                }

                currentRun = score.getCurrentRun();
                score.setBestRun(currentRun);

            }

            //All the designs in the tile is finished, unclicks the board
            if(tile[tileNumber].getNumberOfDesignRemaining() >= 3) {
                board.unclickBoard();
                return;
            }


            //if the click was successful, moves on to the next tile
            if(successfulClick) {
                board.clickBoard(tileNumber);
            }

            //if make unsuccessful click, lose our score
            if(!successfulClick) {
                System.out.println("The clicked tile does not have the design");
                score.resetCurrentRun();
            }


        }
    }

    /**
     * Constructor to initialize the event handler object
     *
     * @return int, returns tile number that was clicked
     */
    public int getTileNumber() {
        return tileNumber;
    }

}
