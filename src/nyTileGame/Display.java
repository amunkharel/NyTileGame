package nyTileGame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Display {

    private Canvas canvas;

    private GraphicsContext gc;

    private Board board;

    private int numberOfTiles;

    public Display(int numberOfTiles, Canvas canvas, Board board) {
        this.canvas = canvas;

        this.numberOfTiles = numberOfTiles;

        this.board = board;

    }

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

    public Canvas getCanvas() {
        return canvas;
    }

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
