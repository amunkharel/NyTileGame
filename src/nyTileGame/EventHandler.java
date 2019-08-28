package nyTileGame;


import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private int tileNumber;
    private Board board;
    private Score score;

    public EventHandler(double x, double y, Board board, Score score)
    {
        this.board = board;
        int xCor = (int) x/80;
        int yCor = (int) y/80;

        this.score = score;


        tileNumber = 7*yCor + xCor;


    }

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
                            score.setCurrentRun();

                        }
                        canLoop = true;
                    }

                }

                currentRun = score.getCurrentRun();
                score.setBestRun(currentRun);

            }

            if(tile[tileNumber].getNumberOfDesignRemaining() >= 3) {
                board.unclickBoard();
                return;
            }


            if(successfulClick) {
                board.clickBoard(tileNumber);
            }

            if(!successfulClick) {
                System.out.println("The clicked tile does not have the design");
                score.resetCurrentRun();
            }


        }
    }

    public int getTileNumber() {
        return tileNumber;
    }

}
