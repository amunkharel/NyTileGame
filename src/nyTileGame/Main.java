package nyTileGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        int numberOfTiles = 5;
        Board board = new Board(numberOfTiles);

        System.out.println(board.getNumberOfTiles());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
