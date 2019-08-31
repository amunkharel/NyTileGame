package nyTileGame;

/**
 * Project 1, Class to keep track of game score and update score text
 * @version Date 2019-08-30
 * @author Amun Kharel
 *
 *
 */
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score {

    /** Current score of the player*/
    private int currentRun = 0;

    /** Best Run of the game*/
    private int bestRun = 0;

    /** Current score displayed in the GUI*/
    private Text currentScore;

    /** Longest Streak displayed in the GUI*/
    private Text longestStreak;

    /**
     * Constructor to initialize the score object
     *
     * @param Text currentScore, currentScore text shown in the GUI
     * @param Text longestStreak, longestStreak of the game shown in the GUI
     */
    public Score(Text currentScore, Text longestStreak)
    {
        this.currentScore = currentScore;
        this.longestStreak = longestStreak;
    }

    /**
     * Adds 1 to the current score each time a design disappears from the tile
     * Updates the text in the GUI
     */
    public void setCurrentRun()
    {
        this.currentRun = currentRun + 1;
        this.currentScore.setText("Current Score is " + this.currentRun);
        this.currentScore.setFont(Font.font("Verdana", 20));
    }

    /**
     * If a user makes a bad click, then the current score is set to zero
     */

    public void resetCurrentRun()
    {
        this.currentRun = 0;
        this.currentScore.setText("Current Score is 0");
        this.currentScore.setFont(Font.font("Verdana", 20));
    }

    /**
     * Sets the longest streak to the currentRun if the current Run is
     * greater than the previous longest streak
     *
     * @param int currentRun, currentRun of the player
     */
    public void setBestRun(int currentRun)
    {
        if(currentRun > this.bestRun)
        {
            this.bestRun = currentRun;
        }
        this.longestStreak.setText("Longest Run is " + this.bestRun);
        this.longestStreak.setFont(Font.font("Verdana", 20));
    }

    /**
     * Returns currentRun of the game
     *
     * @return int, current Run of the player
     */
    public int getCurrentRun()
    {
        return this.currentRun;

    }

    /**
     * Returns get best run of the player in the current game
     *
     * @return int, best streak of the game
     */
    public int getBestRun()
    {
        return this.bestRun;

    }

}
