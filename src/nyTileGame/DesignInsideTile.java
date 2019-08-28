package nyTileGame;

public class DesignInsideTile {

    private String color;

    private String shape;

    public DesignInsideTile(String color, String shape) {
        this.color = color;

        this.shape = shape;

    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return this.color;
    }

    public String getShape()
    {
        return this.shape;
    }

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
