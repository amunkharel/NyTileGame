package nyTileGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main extends Application {

    public static int number_of_tiles = 50;

    Board board = new Board(number_of_tiles);

    List<DesignInsideTile> designs = new ArrayList<>();

    Tile [] tile = board.getTiles();

    int tileNumber;

    EventHandler e;

    Text current_score = new Text();

    Text longest_streak = new Text();


    BorderPane bp = new BorderPane();

    Canvas canvas = new Canvas (560 ,640);

    Display display = new Display(number_of_tiles, canvas, board);

    Scene scene = new Scene(bp, 800, 800);



    @Override
    public void start(Stage stage) throws Exception {



        current_score.setText("Current Score is 19");
        current_score.setFont(Font.font("Verdana", 20));



        longest_streak.setText("Longest Run is 100");
        longest_streak.setFont(Font.font("Verdana", 20));





        canvas.setOnMousePressed(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(" pressed " + event.getX() + " " + event.getY());
                 e = new EventHandler(event.getX(), event.getY(), board);
                 tileNumber = e.getTileNumber();
                designs = tile[tileNumber].getElementsInsideTile();
            }
        });



        display.updateCanvas();

        canvas = display.getCanvas();



        bp.setCenter(canvas);

        bp.setRight(current_score);

        bp.setLeft(longest_streak);




        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int counter = 0;

                Iterator<DesignInsideTile> iter = designs.iterator();
                while (iter.hasNext()) {
                    DesignInsideTile design = iter.next();

                    if (counter == 0 ){
                        iter.remove();
                    }
                    counter++;
                }
                display.updateCanvas();


            }
        };

        animator.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
