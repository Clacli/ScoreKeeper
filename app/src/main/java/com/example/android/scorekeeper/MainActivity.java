package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Create key constants from key Strings used to save and restore the state on configuration change
    private static final String GOAL_FOR_HOME = "goalH";
    private static final String BEHIND_FOR_HOME = "behindH";
    private static final String SCORE_FOR_HOME = "scoreH";
    private static final String RESULT_OF_MATCH = "resultMatch";
    private static final String GOAL_FOR_VISITOR = "goalV";
    private static final String BEHIND_FOR_VISITOR = "behindV";
    private static final String SCORE_FOR_VISITOR = "scoreV";
    private static final String GOAL_FOR_HOME_S = "goalHs";
    private static final String BEHIND_FOR_HOME_S = "behindHs";
    private static final String SCORE_FOR_HOME_S = "scoreHs";
    private static final String GOAL_FOR_VISITOR_S = "goalVs";
    private static final String BEHIND_FOR_VISITOR_S = "behindVs";
    private static final String SCORE_FOR_VISITOR_S = "ScoreVs";
    //Declare instance variables to keep track of the goals, behinds and scores of the opponent teams
    private int goalHome;
    private int goalVisitor;
    private int behindHome;
    private int behindVisitor;
    private int scoreHome;
    private int scoreVisitor;
    //Create instance variables that capture from layout that capture from layout TextVievs referring to goals, behinds and scores.
    private TextView scoreViewA;
    private TextView goalViewA;
    private TextView behindViewA;
    private TextView goalViewB;
    private TextView behindViewB;
    private TextView scoreViewB;
    private TextView opposeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate variables that capture from layout that capture from layout TextVievs referring to goals, behinds and scores.
        scoreViewA = (TextView) findViewById(R.id.total_score_home_team);
        goalViewA = (TextView) findViewById(R.id.goals_for_home_team);
        behindViewA = (TextView) findViewById(R.id.number_of_behind_team_home);
        goalViewB = (TextView) findViewById(R.id.goals_for_visitor_team);
        behindViewB = (TextView) findViewById(R.id.number_of_behind_visitor_team);
        scoreViewB = (TextView) findViewById(R.id.total_score_visitor_team);
        opposeView = (TextView) findViewById(R.id.oppose);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //restore numeric values of variables (int) after configuration changes occur
        goalHome = savedInstanceState.getInt(GOAL_FOR_HOME);
        behindHome = savedInstanceState.getInt(BEHIND_FOR_HOME);
        scoreHome = savedInstanceState.getInt(SCORE_FOR_HOME);
        goalVisitor = savedInstanceState.getInt(GOAL_FOR_VISITOR);
        behindVisitor = savedInstanceState.getInt(BEHIND_FOR_VISITOR);
        scoreVisitor = savedInstanceState.getInt(SCORE_FOR_VISITOR);

        //restores scores displayed as String on the screen
        String resGoalHome = savedInstanceState.getString(GOAL_FOR_HOME_S);
        goalViewA.setText(resGoalHome);

        String resBehindHome = savedInstanceState.getString(BEHIND_FOR_HOME_S);
        behindViewA.setText(resBehindHome);

        String resScoreHome = savedInstanceState.getString(SCORE_FOR_HOME_S);
        scoreViewA.setText(resScoreHome);

        String resGoalVisitor = savedInstanceState.getString(GOAL_FOR_VISITOR_S);
        goalViewB.setText(resGoalVisitor);

        String resBehindVisitor = savedInstanceState.getString(BEHIND_FOR_VISITOR_S);
        behindViewB.setText(resBehindVisitor);

        String resScoreVisitor = savedInstanceState.getString(SCORE_FOR_VISITOR_S);
        scoreViewB.setText(resScoreVisitor);

        opposeView.setText(savedInstanceState.getString(RESULT_OF_MATCH));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //save numeric values of variables when configuration change occurs
        outState.putInt(GOAL_FOR_HOME, goalHome);
        outState.putInt(BEHIND_FOR_HOME, behindHome);
        outState.putInt(SCORE_FOR_HOME, scoreHome);
        outState.putInt(GOAL_FOR_VISITOR, goalVisitor);
        outState.putInt(BEHIND_FOR_VISITOR, behindVisitor);
        outState.putInt(SCORE_FOR_VISITOR, scoreVisitor);

        //save displayed scores on the screen as Strings
        outState.putString(GOAL_FOR_HOME_S, goalViewA.getText().toString());
        outState.putString(BEHIND_FOR_HOME_S, behindViewA.getText().toString());
        outState.putString(SCORE_FOR_HOME_S, scoreViewA.getText().toString());
        outState.putString(GOAL_FOR_VISITOR_S, goalViewB.getText().toString());
        outState.putString(BEHIND_FOR_VISITOR_S, behindViewB.getText().toString());
        outState.putString(SCORE_FOR_VISITOR_S, scoreViewB.getText().toString());
        outState.putString(RESULT_OF_MATCH, opposeView.getText().toString());

        super.onSaveInstanceState(outState);
    }

    /**
     * This method is called when the goal +6 button is clicked.
     * Increase goals by 1 and score by 6 for Home Team and display them.
     */
    public void increaseGoalsAndScoreHomeTeam(View view) {
        goalHome++;
        scoreHome += 6;
        displayGoalsForHomeTeam(goalHome);
        displayScoreForHomeTeam(scoreHome);
    }

    /**
     * This method is called when the behind +1 button is clicked.
     * Increase behind by 1 and score by 1 for Home Team and display them.
     */
    public void increaseBehindAndScoreHomeTeam(View view) {
        behindHome++;
        scoreHome++;
        displayNumberOfBehindHome(behindHome);
        displayScoreForHomeTeam(scoreHome);
    }

    /**
     * This method is called when the goal +6 button is clicked.
     * Increase goals by 1 and score by 6 for Visitor Team and display them.
     */
    public void increaseGoalsAndScoreVisitorTeam(View view) {
        goalVisitor++;
        scoreVisitor += 6;
        displayGoalsForVisitorTeam(goalVisitor);
        displayScoreForVisitorTeam(scoreVisitor);
    }

    /**
     * This method is called when the behind +1 button is clicked.
     * Increase behind by 1 and score by 1 for Visitor Team and display them.
     */
    public void increaseBehindAndScoreVisitorTeam(View view) {
        behindVisitor++;
        scoreVisitor++;
        displayNumberOfBehindVisitor(behindVisitor);
        displayScoreForVisitorTeam(scoreVisitor);
    }

    /**
     * This method is called when button "Result" is clicked.
     * Update @id/oppose TextView
     */
    public void updateView(View view) {
        if (scoreHome > scoreVisitor) {
            displayWinTeam(getString(R.string.message_defeated));
        } else if (scoreHome < scoreVisitor) {
            displayWinTeam(getString(R.string.message_defeated_by));
        } else {
            displayWinTeam(getString(R.string.message_drew));
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
    private void displayGoalsForHomeTeam(int goals) {
        goalViewA.setText(String.valueOf(goals));
    }

    /**
     * Displays the number of behind for Home Team.
     */
    private void displayNumberOfBehindHome(int behind) {
        behindViewA.setText(String.valueOf(behind));
    }

    /**
     * Displays the given score for Home Team.
     */
    private void displayScoreForHomeTeam(int score) {
        scoreViewA.setText(String.valueOf(String.format(getString(R.string.parenthesis), score)));
    }

    /**
     * Displays the number of goals for Visitor Team.
     */
    private void displayGoalsForVisitorTeam(int goals) {
        goalViewB.setText(String.valueOf(goals));
    }

    /**
     * Displays the number of behinds for Visitor Team.
     */
    private void displayNumberOfBehindVisitor(int behind) {
        behindViewB.setText(String.valueOf(behind));
    }


    /**
     * Displays the given score for Visitor Team.
     */
    private void displayScoreForVisitorTeam(int score) {
        scoreViewB.setText(String.valueOf(String.format(getString(R.string.parenthesis), score)));
    }

    /**
     * Displays winner team
     */
    private void displayWinTeam(String result) {
        opposeView.setText(result);
    }

}
