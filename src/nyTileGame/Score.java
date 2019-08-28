package nyTileGame;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score {
    private int currentRun = 0;

    private int bestRun = 0;

    private Text currentScore;

    private Text longestStreak;

    public Score(Text currentScore, Text longestStreak)
    {
        this.currentScore = currentScore;
        this.longestStreak = longestStreak;
    }

    public void setCurrentRun()
    {
        this.currentRun = currentRun + 1;
        this.currentScore.setText("Current Score is " + this.currentRun);
        this.currentScore.setFont(Font.font("Verdana", 20));
    }

    public void resetCurrentRun()
    {
        this.currentRun = 0;
        this.currentScore.setText("Current Score is 0");
        this.currentScore.setFont(Font.font("Verdana", 20));
    }

    public void setBestRun(int currentRun)
    {
        if(currentRun > this.bestRun)
        {
            this.bestRun = currentRun;
        }
        this.longestStreak.setText("Longest Run is " + this.bestRun);
        this.longestStreak.setFont(Font.font("Verdana", 20));
    }

    public int getCurrentRun()
    {
        return this.currentRun;

    }

    public int getBestRun()
    {
        return this.bestRun;

    }

}
