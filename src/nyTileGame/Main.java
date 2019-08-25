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

        Text current_score = new Text();

        current_score.setText("Current Score is 19");
        current_score.setFont(Font.font("Verdana", 20));

        Text longest_streak = new Text();

        longest_streak.setText("Longest Run is 100");
        longest_streak.setFont(Font.font("Verdana", 20));


        BorderPane bp = new BorderPane();
        Canvas canvas = new Canvas (560 ,560);
        GraphicsContext gc = canvas.getGraphicsContext2D ();
        gc. setFill (Color.BLUE );
        gc. fillRect (0 ,0 ,560 ,560);
        gc.setFill(Color.RED);
        gc. fillRect (0 ,0 ,80 ,80);
        gc.setFill(Color.ORANGE);
        gc. fillRect (80 ,0 ,80 ,80);
        gc.setFill(Color.OLIVEDRAB);
        gc. fillRect (160 ,0 ,80 ,80);
        gc.setFill(Color.ROSYBROWN);
        gc. fillRect (240 ,0 ,80 ,80);
        gc.setFill(Color.PAPAYAWHIP);
        gc. fillRect (320 ,0 ,80 ,80);
        gc.setFill(Color.BLUE);
        gc. fillRect (400 ,0 ,80 ,80);
        gc.setFill(Color.KHAKI);
        gc. fillRect (480 ,0 ,80 ,80);


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

        /*int numberOfTiles = 26;

        BorderPane bp = new BorderPane();


        GridPane grid = new GridPane();


        Text current_score = new Text();

        current_score.setText("Current Score is 19");
        current_score.setFont(Font.font("Verdana", 20));

        Text longest_streak = new Text();

        longest_streak.setText("Longest Run is 100");
        longest_streak.setFont(Font.font("Verdana", 20));

        bp.setCenter(grid);

        bp.setLeft(current_score);
        bp.setRight(longest_streak);

        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                Circle circ = new Circle();
                circ.setCenterX(35);
                circ.setCenterY(35);
                circ.setRadius(10);
                circ.setFill(Color.RED);
                Rectangle rec = new Rectangle();
                rec.setWidth(70);
                rec.setHeight(70);
                rec.setFill(Color.valueOf("#feb"));
                rec.setStroke(Color.BLACK);
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec, circ);
            }
        }


        Scene scene = new Scene(bp, 1000, 800);

        primaryStage.setTitle("Tile Game");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();

        grid.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            System.out.println(" pressed " + event.getX() + " " + event.getY());
        }); */



    }

    public static void main(String[] args) {
        launch(args);
    }
}
