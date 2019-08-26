package nyTileGame;


public class EventHandler {
    private int tileNumber;

    public EventHandler(double x, double y, Board board)
    {
        int xCor = (int) x/80;
        int yCor = (int) y/80;

        System.out.println("x= " + xCor + " y= " + yCor);


        tileNumber = 7*yCor + xCor;



    }

    public int getTileNumber() {
        return tileNumber;
    }

}
