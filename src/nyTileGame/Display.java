package nyTileGame;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Display {
    private int numberOfTiles;

    private static final int TILE_SIZE = 40;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 800);

        return root;
    }

    public Display(Stage stage, int numberOfTiles) {
        this.numberOfTiles = numberOfTiles;
        Scene scene = new Scene(createContent());
        stage.setTitle("Tile Game");
        stage.setScene(scene);
        stage.show();
    }
}
