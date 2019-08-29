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
    private static int number_of_tiles = 28;

    /** Board object for bookkeeping tiles and designs inside each tile */
    private Board board = new Board(number_of_tiles);

    /** Design inside each tile */
    private List<DesignInsideTile> designs = new ArrayList<>();

    /** Tile object inside the board bookkeeper*/
    private Tile [] tile = board.getTiles();

    /** Handles click of a mouse in the canvas of Tile Game*/
    private EventHandler e;

    /** Text to keep track of the current score*/
    private Text current_score = new Text();

    /** Text to keep track of the longest streak in the game*/
    private Text longest_streak = new Text();

    /** Board Pane where the canvas is stored*/
    private BorderPane bp = new BorderPane();

    /** Canvas where the board is created*/
    private Canvas canvas = new Canvas (560 ,640);

    /** GUI of the game board*/
    private Display display = new Display(number_of_tiles, canvas, board);

    /** Scene where the game border pane is stored*/
    private Scene scene = new Scene(bp, 800, 800);

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private Score score = new Score(current_score, longest_streak);




    @Override
    public void start(Stage stage) throws Exception {



        current_score.setText("Current Score is 0");
        current_score.setFont(Font.font("Verdana", 20));



        longest_streak.setText("Longest Run is 0");
        longest_streak.setFont(Font.font("Verdana", 20));


        canvas.setOnMousePressed(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                int counter = 0;
                 e = new EventHandler(event.getX(), event.getY(), board, score);
                 e.handleClick();

                for (int i = 0; i < number_of_tiles; i++)
                {
                    if(tile[i].getNumberOfDesignRemaining() >= 3)
                    {
                        counter++;
                    }
                }

                if(counter == number_of_tiles)
                {
                    alert.setTitle("Game Over");
                    alert.setContentText("You have finished all the clicks");
                    alert.showAndWait();

                    stage.close();

                }
            }
        });




        bp.setCenter(canvas);

        bp.setRight(current_score);

        bp.setLeft(longest_streak);


        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

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
