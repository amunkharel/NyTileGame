package nyTileGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        int numberOfTiles = 4;
        Board board = new Board(numberOfTiles);

        Tile [] tiles = board.getTiles();

        List<DesignInsideTile> designElement1 = new ArrayList<>();
        List<DesignInsideTile> designElement0 = new ArrayList<>();
        List<DesignInsideTile> designElement2 = new ArrayList<>();
        List<DesignInsideTile> designElement3 = new ArrayList<>();

        designElement0 = tiles[0].getElementsInsideTile();

        designElement1 = tiles[1].getElementsInsideTile();

        designElement2 = tiles[2].getElementsInsideTile();

        designElement3 = tiles[3].getElementsInsideTile();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
