package nyTileGame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        int number_of_tiles = 50;

        Board board = new Board(number_of_tiles);

        Text current_score = new Text();

        current_score.setText("Current Score is 19");
        current_score.setFont(Font.font("Verdana", 20));

        Text longest_streak = new Text();

        longest_streak.setText("Longest Run is 100");
        longest_streak.setFont(Font.font("Verdana", 20));


        BorderPane bp = new BorderPane();
        Canvas canvas = new Canvas (560 ,640);




        GraphicsContext gc = canvas.getGraphicsContext2D ();

        Display display = new Display(number_of_tiles, canvas, board);

        canvas = display.getCanvas();



        bp.setCenter(canvas);

        bp.setRight(current_score);

        bp.setLeft(longest_streak);


        Scene scene = new Scene(bp, 800, 800);

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();


        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            System.out.println(" pressed " + event.getX() + " " + event.getY());
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
