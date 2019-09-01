package nyTileGame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Project 1, Class to handle GUI element of the board
 * @version Date 2019-08-30
 * @author Amun Kharel
 *
 *
 */

public class Display {

    /** Canvas where the board is being made*/
    private Canvas canvas;

    /** Graphics we are using over the canvas*/
    private GraphicsContext gc;

    /** Board object of the game*/
    private Board board;

    /** Number of Tiles in the board*/
    private int numberOfTiles;

    /**
     * Constructor to initialize GUI board for the game
     *
     * @param int numberOfTiles, number of Tiles in the board
     * @param Canvas canvas, canvas where graphics is being done
     * @param Board board, the board object for the game
     */
    public Display(int numberOfTiles, Canvas canvas, Board board) {
        this.canvas = canvas;

        this.numberOfTiles = numberOfTiles;

        this.board = board;

    }


    /**
     * Function to update the canvas after each change is made
     * in the backend of the board
     *
     */
    public void updateCanvas() {

        int fixedRow = (int) numberOfTiles/7;

        int numberOfColumnInLastRow = (int) numberOfTiles % 7;

        Tile [] tile = board.getTiles();

        int counter = 0;

        this.gc = this.canvas.getGraphicsContext2D();

        List<DesignInsideTile> designs = new ArrayList<>();

        for (int i = 0; i < fixedRow; i++) {
            for (int j = 0; j < 7; j ++) {
                gc. setFill (Color.KHAKI );
                gc. fillRect (j * 80 , i * 80 ,80 ,80);

                designs = tile[counter].getElementsInsideTile();

                for (DesignInsideTile design : designs){
                    fillTillWithDesign(i, j, design.getColor(), design.getShape());
                }

                if(board.isClicked()) {
                    if(counter == board.getCurrentTile()) {
                        gc.setStroke(Color.RED);
                        gc.setLineWidth(5);
                        gc.strokeRect(j*80, i*80, 76, 76 );
                    }
                }
                counter++;


                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);
                gc.strokeRect(j*80, i*80, 80, 80 );
            }

        }

        for (int i = fixedRow; i < fixedRow + 1; i++) {
            for (int j = 0; j < numberOfColumnInLastRow; j ++) {
                gc. setFill (Color.KHAKI );
                gc. fillRect (j * 80 , i * 80 ,80 ,80);

                designs = tile[counter].getElementsInsideTile();

                for (DesignInsideTile design : designs){
                    fillTillWithDesign(i, j, design.getColor(), design.getShape());
                }

                if(board.isClicked()) {
                    if(counter == board.getCurrentTile()) {
                        gc.setStroke(Color.RED);
                        gc.setLineWidth(5);
                        gc.strokeRect(j*80, i*80, 76, 76 );
                    }
                }

                counter++;

                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);
                gc.strokeRect(j*80, i*80, 80, 80 );
            }

        }
    }
    /**
     * Returns canvas of the board
     *
     * @return Canvas, return canvas where board is drawn
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Takes in row, column, color and shape of the tile design and
     * makes the design on the tile
     *
     * @param int i, row of the tile
     * @param int j, column of the tile
     * @param String color, color of the design
     * @param String shape, shape of the design
     */
    private void fillTillWithDesign(int i, int j, String color, String shape) {
        if(color.equals("yellow")){
            gc.setFill(Color.YELLOW);
        }

        else if(color.equals("red")){
            gc.setFill(Color.RED);
        }

        else if(color.equals("blue")){
            gc.setFill(Color.BLUE);
        }

        else if(color.equals("green")){
            gc.setFill(Color.GREEN);
        }

        else if(color.equals("pink")){
            gc.setFill(Color.PINK);
        }

        else if(color.equals("purple")){
            gc.setFill(Color.PURPLE);
        }

        if(shape.equals("curved_rectangle")){
            gc.fillRoundRect(j*80 + 10, i*80 + 10, 40, 40, 10, 10);
        }

        else if(shape.equals("rectangle")){
            gc. fillRect (j * 80 + 20 , i * 80 + 20,40 ,40);
        }

        else if(shape.equals("vertical_rectangle")){
            gc. fillRect (j * 80 + 40 , i * 80 + 30,20 ,40);
        }


        else if(shape.equals("oval")){
            gc.fillOval(j*80 + 30, i*80 + 30, 40, 40 );
        }

        else if(shape.equals("vertical_oval")){
            gc.fillOval(j*80 + 40, i*80 + 40, 20, 35 );
        }

    }


}
