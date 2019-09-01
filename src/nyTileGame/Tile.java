package nyTileGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Project 1, Class for Tiles inside the board
 * @version Date 2019-08-30
 * @author Amun Kharel
 *
 *
 */
public class Tile {

    /**Number of design inside the tile*/
    private int numberOfDesignRemaining = 3;

    /** Arraylist for designElement*/
    List<DesignInsideTile> designElement = new ArrayList<>();

    /**
     * Adds Design Element inside the tile
     *
     * @param DesignInsideTile design, design with shape and color inside tile
     */
    public void addDesignElement(DesignInsideTile design){
        this.designElement.add(design);
        this.numberOfDesignRemaining = this.numberOfDesignRemaining - 1;
    }

    /**
     * Returns number of design we can add inside each tile
     *
     * @return int , design that can be added to the tile
     */
    public int getNumberOfDesignRemaining() {
        return this.numberOfDesignRemaining;
    }

    /**
     * Removes the given design element from the tile object
     *
     * @param DesignInsideTile design, design with shape and color inside tile
     */

    public void removeDesignElement(DesignInsideTile design) {
        this.designElement.remove(design);
        this.numberOfDesignRemaining = this.numberOfDesignRemaining + 1;
    }

    /**
     * Returns list of all design elements inside each tile object
     *
     * @param List<DesignInsideTile>, returns all design elements inside a tile
     */
    public List<DesignInsideTile> getElementsInsideTile()
    {
        return this.designElement;
    }



}
