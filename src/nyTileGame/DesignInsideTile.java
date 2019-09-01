package nyTileGame;


/**
 * Project 1, Class for design element inside Tile
 * @version Date 2019-08-30
 * @author Amun Kharel
 *
 *
 */

public class DesignInsideTile {
    /**Color of the design element*/
    private String color;

    /**Shape of the design element*/
    private String shape;

    /**
     * Constructor for creating a Design
     *
     * @param String color , Color of the Design
     * @param String shape , Shape of the Design
     */
    public DesignInsideTile(String color, String shape) {
        this.color = color;

        this.shape = shape;

    }

    /**
     * Sets color for design
     *
     * @param String color , Color of the design
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets shape of the design
     *
     * @param String shape , Shape of the Design
     */
    public void setShape(String shape) {

        this.shape = shape;
    }

    /**
     * Gets color of the design
     *
     * @return String color , Color of the Design
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Gets shape of the design
     *
     * @return String shape , Shape of the Design
     */
    public String getShape()
    {
        return this.shape;
    }


    /**
     * Compares the object with DesignElement and see if they are equal
     *
     * @param Object obj , Generic type object
     */
    public boolean equals (Object obj) {
        if(obj instanceof DesignInsideTile)
        {
            DesignInsideTile design = (DesignInsideTile) obj;

            if(getColor().equals(design.color) && getShape().equals(design.shape))
            {
                return true;
            }
        }
        return false;
    }


}
