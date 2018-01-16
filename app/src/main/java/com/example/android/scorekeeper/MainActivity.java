package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int goalHome = 0;
    int goalVisitor = 0;
    int behindHome = 0;
    int behindVisitor = 0;
    int scoreHome = 0;
    int scoreVisitor = 0;


    TextView scoreViewA;
    TextView goalViewA;
    TextView behindViewA;
    TextView goalViewB;
    TextView behindViewB;
    TextView scoreViewB;
    TextView opposeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.total_score_home_team);
        goalViewA = (TextView) findViewById(R.id.goals_for_home_team);
        behindViewA = (TextView) findViewById(R.id.number_of_behind_team_home);
        goalViewB = (TextView) findViewById(R.id.goals_for_visitor_team);
        behindViewB = (TextView) findViewById(R.id.number_of_behind_visitor_team);
        scoreViewB = (TextView) findViewById(R.id.total_score_visitor_team);
        opposeView = (TextView) findViewById(R.id.oppose);
    }

    /**
     * This method is called when the goal +6 button is clicked.
     * Increase goals by 1 and score by 6 for Home Team and display them.
     */
    public void increaseGoalsAndScoreHomeTeam(View view) {
        goalHome = goalHome + 1;
        scoreHome = scoreHome + 6;
        displayGoalsForHomeTeam(goalHome);
        displayScoreForHomeTeam(scoreHome);
    }

    /**
     * This method is called when the behind +1 button is clicked.
     * Increase behind by 1 and score by 1 for Home Team and display them.
     */
    public void increaseBehindAndScoreHomeTeam(View view) {
        behindHome = behindHome + 1;
        scoreHome = scoreHome + 1;
        displayNumberOfBehindHome(behindHome);
        displayScoreForHomeTeam(scoreHome);
    }

    /**
     * This method is called when the goal +6 button is clicked.
     * Increase goals by 1 and score by 6 for Visitor Team and display them.
     */
    public void increaseGoalsAndScoreVisitorTeam(View view) {
        goalVisitor = goalVisitor + 1;
        scoreVisitor = scoreVisitor + 6;
        displayGoalsForVisitorTeam(goalVisitor);
        displayScoreForVisitorTeam(scoreVisitor);
    }

    /**
     * This method is called when the behind +1 button is clicked.
     * Increase behind by 1 and score by 1 for Visitor Team and display them.
     */
    public void increaseBehindAndScoreVisitorTeam(View view) {
        behindVisitor = behindVisitor + 1;
        scoreVisitor = scoreVisitor + 1;
        displayNumberOfBehindVisitor(behindVisitor);
        displayScoreForVisitorTeam(scoreVisitor);
    }

    /**
     * This method is called when button "Result" is clicked.
     * Update @id/oppose TextView
     */
    public void updateView(View view) {
        if (scoreHome > scoreVisitor) {
            displayWinTeam("Defeated");
        }
        if (scoreHome < scoreVisitor) {
            displayWinTeam("Defeated by");
        }
        if (scoreHome == scoreVisitor) {
            displayWinTeam("Drew");
        }
    }

    /**
     * This method is called when reset button is called.
     * Update to 0 goals, behinds and score to 0, update @id/oppose TextView
     */

    public void resetMatch(View view) {
        goalHome = 0;
        goalVisitor = 0;
        behindHome = 0;
        behindVisitor = 0;
        scoreHome = 0;
        scoreVisitor = 0;
        displayGoalsForHomeTeam(goalHome);
        displayGoalsForVisitorTeam(goalVisitor);
        displayNumberOfBehindHome(behindHome);
        displayNumberOfBehindVisitor(behindVisitor);
        displayScoreForHomeTeam(scoreHome);
        displayScoreForVisitorTeam(scoreVisitor);
        displayWinTeam("Vs.");
    }

    /**
     * Displays the number of goal for Home Team.
     */
    public void displayGoalsForHomeTeam(int goals) {
        goalViewA.setText(String.valueOf(goals));
    }

    /**
     * Displays the number of behind for Home Team.
     */
    public void displayNumberOfBehindHome(int behind) {
        behindViewA.setText(String.valueOf(behind));
    }

    /**
     * Displays the given score for Home Team.
     */
    public void displayScoreForHomeTeam(int score) {
        scoreViewA.setText(String.valueOf("(" + score + ")"));
    }

    /**
     * Displays the number of goals for Visitor Team.
     */
    public void displayGoalsForVisitorTeam(int goals) {
        goalViewB.setText(String.valueOf(goals));
    }

    /**
     * Displays the number of behinds for Visitor Team.
     */
    public void displayNumberOfBehindVisitor(int behind) {
        behindViewB.setText(String.valueOf(behind));
    }


    /**
     * Displays the given score for Visitor Team.
     */
    public void displayScoreForVisitorTeam(int score) {
        scoreViewB.setText(String.valueOf("(" + score + ")"));
    }

    /**
     * Display winner team
     */
    public void displayWinTeam(String result) {
        opposeView.setText(result);
    }

}
