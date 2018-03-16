package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    //Bind views with Butter Knife and cast views in layout
    @BindView(R.id.goals_for_home_team) TextView goalHomeTeam;
    @BindView(R.id.number_of_behind_home_team) TextView behindHomeTeam;
    @BindView(R.id.total_score_home_team) TextView scoreHomeTeam;
    @BindView(R.id.goals_for_visitor_team) TextView goalVisitorTeam;
    @BindView(R.id.number_of_behind_visitor_team) TextView behindVisitorTeam;
    @BindView(R.id.total_score_visitor_team) TextView scoreVisitorTeam;
    @BindView(R.id.oppose) TextView oppose;
    // Uncomment if not using Butterknife
    //Create instance variables that capture from layout that capture from layout TextViews referring to goals, behinds and scores.
    //private TextView scoreViewA;
    //private TextView goalViewA;
    //private TextView behindViewA;
    //private TextView goalViewB;
    //private TextView behindViewB;
    //private TextView scoreViewB;
    //private TextView opposeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //Uncomment if not using Butterknife, initialize scoreviewA associating it to team_a_score value
        //Instantiate variables that capture from layout that capture from layout TextViews referring to goals, behinds and scores.
        //scoreViewA = (TextView) findViewById(R.id.total_score_home_team);
        //goalViewA = (TextView) findViewById(R.id.goals_for_home_team);
        //behindViewA = (TextView) findViewById(R.id.number_of_behind_home_team);
        //goalViewB = (TextView) findViewById(R.id.goals_for_visitor_team);
        //behindViewB = (TextView) findViewById(R.id.number_of_behind_visitor_team);
        //scoreViewB = (TextView) findViewById(R.id.total_score_visitor_team);
        //opposeView = (TextView) findViewById(R.id.oppose);

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
        goalHomeTeam.setText(resGoalHome);

        String resBehindHome = savedInstanceState.getString(BEHIND_FOR_HOME_S);
        behindHomeTeam.setText(resBehindHome);

        String resScoreHome = savedInstanceState.getString(SCORE_FOR_HOME_S);
        scoreHomeTeam.setText(resScoreHome);

        String resGoalVisitor = savedInstanceState.getString(GOAL_FOR_VISITOR_S);
        goalVisitorTeam.setText(resGoalVisitor);

        String resBehindVisitor = savedInstanceState.getString(BEHIND_FOR_VISITOR_S);
        behindVisitorTeam.setText(resBehindVisitor);

        String resScoreVisitor = savedInstanceState.getString(SCORE_FOR_VISITOR_S);
        scoreVisitorTeam.setText(resScoreVisitor);

        oppose.setText(savedInstanceState.getString(RESULT_OF_MATCH));
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
        outState.putString(GOAL_FOR_HOME_S, goalHomeTeam.getText().toString());
        outState.putString(BEHIND_FOR_HOME_S, behindHomeTeam.getText().toString());
        outState.putString(SCORE_FOR_HOME_S, scoreHomeTeam.getText().toString());
        outState.putString(GOAL_FOR_VISITOR_S, goalVisitorTeam.getText().toString());
        outState.putString(BEHIND_FOR_VISITOR_S, behindVisitorTeam.getText().toString());
        outState.putString(SCORE_FOR_VISITOR_S, scoreVisitorTeam.getText().toString());
        outState.putString(RESULT_OF_MATCH, oppose.getText().toString());

        super.onSaveInstanceState(outState);
    }

    //Bind Listener with Butter Knife
    /**
     * This method is called when the goal +6 button is clicked.
     * Increase goals by 1 and score by 6 for Home Team and display them.
     */
    //android:onClick="increaseGoalsAndScoreHomeTeam", use this in layout if not using ButterKnife
    @OnClick(R.id.home_team_plus_six_button)
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
    //android:onClick="increaseBehindAndScoreHomeTeam", use this in layout if not using ButterKnife
    @OnClick(R.id.home_team_plus_one_button)
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
    //android:onClick="increaseGoalsAndScoreVisitorTeam", use this in layout if not using ButterKnife
    @OnClick(R.id.visitor_team_plus_six_button)
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
    //android:onClick="increaseBehindAndScoreVisitorTeam", use this in layout if not using ButterKnife
    @OnClick(R.id.visitor_team_plus_one_button)
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
    //android:onClick="updateView", use this in layout if not using ButterKnife
    @OnClick(R.id.end_match_button)
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
    //android:onClick="resetMatch", use this in layout if not using ButterKnife
    @OnClick(R.id.reset_button)
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
        goalHomeTeam.setText(String.valueOf(goals));
    }

    /**
     * Displays the number of behind for Home Team.
     */
    private void displayNumberOfBehindHome(int behind) {
        behindHomeTeam.setText(String.valueOf(behind));
    }

    /**
     * Displays the given score for Home Team.
     */
    private void displayScoreForHomeTeam(int score) {
        scoreHomeTeam.setText(String.valueOf(String.format(getString(R.string.parenthesis), score)));
    }

    /**
     * Displays the number of goals for Visitor Team.
     */
    private void displayGoalsForVisitorTeam(int goals) {
        goalVisitorTeam.setText(String.valueOf(goals));
    }

    /**
     * Displays the number of behinds for Visitor Team.
     */
    private void displayNumberOfBehindVisitor(int behind) {
        behindVisitorTeam.setText(String.valueOf(behind));
    }


    /**
     * Displays the given score for Visitor Team.
     */
    private void displayScoreForVisitorTeam(int score) {
        scoreVisitorTeam.setText(String.valueOf(String.format(getString(R.string.parenthesis), score)));
    }

    /**
     * Displays winner team
     */
    private void displayWinTeam(String result) {
        oppose.setText(result);
    }

}
