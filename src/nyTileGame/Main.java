/**
 * Project 1, Controller class to run the New York Tile Game
 * @version Date 2019-08-30
 * @author Amun Kharel
 *
 *
 */
package nyTileGame;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    /** Number of Tiles in the board*/
    private static int numberOfTiles = 50;

    /** Board object for bookkeeping tiles and designs inside each tile */
    private Board board = new Board(numberOfTiles);

    /** Design inside each tile */
    private List<DesignInsideTile> designs = new ArrayList<>();

    /** Tile object inside the board bookkeeper*/
    private Tile [] tile = board.getTiles();

    /** Handles click of a mouse in the canvas of Tile Game*/
    private EventHandler e;

    /** Text to keep track of the current score*/
    private Text currentScore = new Text();

    /** Text to keep track of the longest streak in the game*/
    private Text longestStreak = new Text();

    /** Board Pane where the canvas is stored*/
    private BorderPane bp = new BorderPane();

    /** Canvas where the board is created*/
    private Canvas canvas = new Canvas (560 ,640);

    /** GUI of the game board*/
    private Display display = new Display(numberOfTiles, canvas, board);

    /** Scene where the game border pane is stored*/
    private Scene scene = new Scene(bp, 800, 800);

    /** Alert Window after the board detects that the game is over*/
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    /** Score class to keep track of current score and the longest streak*/
    private Score score = new Score(currentScore, longestStreak);


    /**
     * Method where the program starts. This method pulls out logic and gui board
     * to make this game work
     *
     * @param Stage stage, Stage where the Board GUI for this game is placed
     */

    @Override
    public void start(Stage stage) throws Exception {

        //sets current score text to 0 at the beginning of the game
        currentScore.setText("Current Score is 0");
        currentScore.setFont(Font.font("Verdana", 20));

        //sets longest streak to 0 at the beginning of the game
        longestStreak.setText("Longest Run is 0");
        longestStreak.setFont(Font.font("Verdana", 20));

        //handles the event when mouse is pressed on the canvas object

        canvas.setOnMousePressed(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                int counter = 0;
                 e = new EventHandler(event.getX(), event.getY(), board, score);
                 e.handleClick();

                for (int i = 0; i < numberOfTiles; i++)
                {
                    if(tile[i].getNumberOfDesignRemaining() >= 3)
                    {
                        counter++;
                    }
                }

                //if all the designs are deleted removed from all the tiles, the game is over
                if(counter == numberOfTiles)
                {
                    alert.setTitle("Game Over");
                    alert.setContentText("You have finished all the clicks");
                    alert.showAndWait();

                    stage.close();

                }
            }
        });



        //sets canvas in the center of the board
        bp.setCenter(canvas);

        //sets current score in the right side of the board
        bp.setRight(currentScore);

        //sets longest streak in the left side of the board
        bp.setLeft(longestStreak);

        //puts the scene in the stage
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        //continuously updates the canvas of the board
        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long now) {

                display.updateCanvas();

            }
        };

        animator.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
