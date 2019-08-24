package nyTileGame;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private int numberOfDesignRemaining = 3;

    List<DesignInsideTile> designElement = new ArrayList<>();

    public void addDesignElement(DesignInsideTile design){
        this.designElement.add(design);
        this.numberOfDesignRemaining = this.numberOfDesignRemaining - 1;
    }

    public int getNumberOfDesignRemaining() {
        return this.numberOfDesignRemaining;
    }

    public void removeDesignElement(DesignInsideTile design)
    {
        this.designElement.remove(design);
        this.numberOfDesignRemaining = this.numberOfDesignRemaining + 1;
    }



}
