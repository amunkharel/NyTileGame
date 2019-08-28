package nyTileGame;

public class Score {
    private int currentRun;

    private int bestRun = 0;

    public void setCurrentRun(int score)
    {
        this.currentRun = 0;
        this.currentRun = currentRun + 0;
    }

    public void resetCurrentRun()
    {
        this.currentRun = 0;
    }

    public void setBestRun(int currentRun)
    {
        if(currentRun > this.bestRun)
        {
            this.bestRun = currentRun;
        }
    }

    public int getCurrentRun()
    {
        return 5;

    }

    public int getBestRun()
    {
        return 10;

    }

}
