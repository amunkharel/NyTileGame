package nyTileGame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Display {
    private int numberOfTiles;

    private Canvas canvas;

    private Board board;

    public Display(int numberOfTiles, Canvas canvas, Board board) {
        this.canvas = canvas;

        int fixedRow = (int) numberOfTiles/7;

        int numberOfColumnInLastRow = (int) numberOfTiles % 7;

        GraphicsContext gc = this.canvas.getGraphicsContext2D();

        for (int i = 0; i < fixedRow; i++) {
            for (int j = 0; j < 7; j ++) {
                gc. setFill (Color.KHAKI );
                gc. fillRect (j * 80 , i * 80 ,80 ,80);
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);
                gc.strokeRect(j*80, i*80, 80, 80 );
            }
        }

        for (int i = fixedRow; i < fixedRow + 1; i++) {
            for (int j = 0; j < numberOfColumnInLastRow; j ++) {
                gc. setFill (Color.KHAKI );
                gc. fillRect (j * 80 , i * 80 ,80 ,80);
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);
                gc.strokeRect(j*80, i*80, 80, 80 );
            }
        }

    }

    public Canvas getCanvas() {
        return canvas;
    }
}
