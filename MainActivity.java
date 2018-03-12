package com.example.kellytang.summative;

/*
Author: Kelly Tang
Date: June 1 2017
Description: Physics Multiple Choice exam review app. This app displays 5 True/False questions for user to answer,
then user clicks submit button to see how many they got right. Wrong answers are displayed in red.
If user wants to do more questions, click the Try again button, and the process will repeat.
 */


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.text.NumberFormat;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Random;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity {

    private TextView questionOneTextView;
    private TextView questionTwoTextView;
    private TextView questionThreeTextView;
    private TextView questionFourTextView;
    private TextView questionFiveTextView;
    private TextView scoreTextView;
    private Button submitButton;
    private Button tryAgainButton;


    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;


    private RadioButton q1RadioButton;
    private RadioButton q2RadioButton;
    private RadioButton q3RadioButton;
    private RadioButton q4RadioButton;
    private RadioButton q5RadioButton;

    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans5;

    private int score = 0;

    private SharedPreferences savedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionOneTextView = (TextView) findViewById(R.id.questionOneTextView);
        questionTwoTextView= (TextView) findViewById(R.id.questionTwoTextView);
        questionThreeTextView =  (TextView) findViewById(R.id.questionThreeTextView);
        questionFourTextView  =  (TextView) findViewById(R.id.questionFourTextView);
        questionFiveTextView  =  (TextView) findViewById(R.id.questionFiveTextView);
        scoreTextView  =  (TextView) findViewById(R.id.scoreTextView);
        submitButton = (Button) findViewById(R.id.submitButton);
        tryAgainButton = (Button) findViewById(R.id.tryAgainButton);

        //each radio group contains the true and false radiobuttons for the corresponding question
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);


        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();

        addListenerOnButton();

        savedPrefs = getSharedPreferences( "SummativePrefs", MODE_PRIVATE );

    }

    @Override
    public void onPause() {
        // Save the score instance variable
        Editor prefsEditor = savedPrefs.edit();
        prefsEditor.putInt( "score", score);
        prefsEditor.commit();

        // Calling the parent onPause() must be done LAST
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Load the instance variables back (or default values)
        score = savedPrefs.getInt("score", 0);
    }


    //method to generate question 1 (randomly) , display it on screen, and return the answer as a "T" or "F" string
    public String questionOne(){

        Random generator = new Random();
        int q1 = 1 + generator.nextInt(5);

        if (q1 == 1){
            questionOneTextView.setText("Objects of different masses have the same acceleration on incline plane");
            return ans1 = "T";
        }
        else if (q1 ==2){
            questionOneTextView.setText("A string can only provide a pulling force");
            return ans1 = "T";
        }
        else if (q1 == 3){
            questionOneTextView.setText("When angle of a rough incline plane is decreased, F friction increases");
            //return answer1 = true;
            return ans1 = "T";
        }
        else if (q1==4){
            questionOneTextView.setText("On incline plane, normal force is never larger than force of gravity");
           // return answer1 = false;
            return ans1 = "F";
        }
        else{
            questionOneTextView.setText("Unit for g is kg/ms");
           // return answer1 = false;
            return ans1 = "F";
    }

    }

    //method to generate question 2, display it on screen, and return the answer as a "T" or "F" string
    public String questionTwo(){

        Random generator = new Random();
        int q2 = 1 + generator.nextInt(5);

        if (q2 == 1){
            questionTwoTextView.setText("Accleration of ball at top of its path is 0");
            return ans2 = "F";
        }
        else if (q2 ==2){
            questionTwoTextView.setText("Acceleration of ball is min at its max height");
            return ans2 = "F";
        }
        else if (q2 == 3){
            questionTwoTextView.setText("The slope of a V-T graph is the acceleration");
            return ans2 ="T";
        }
        else if (q2==4){
            questionTwoTextView.setText("Horizontal velocity of projectile is constant");
            return ans2 = "F";
        }
        else{
            questionTwoTextView.setText("Area under V-T graph is the distance travelled");
            return ans2 = "T";
        }

    }

    //method to generate question 3, display it on screen, and return the answer as a "T" or "F" string
    public String questionThree(){

        Random generator = new Random();
        int q3 = 1 + generator.nextInt(5);

        if (q3 == 1){
            questionThreeTextView.setText("Object moving at constant speed can also be accelerating");
            return ans3 = "T";
        }
        else if (q3 ==2){
            questionThreeTextView.setText("In vertical circle, tension in string is max at the bottom");
            return ans3 = "T";
        }
        else if (q3 == 3){
            questionThreeTextView.setText("If period decreases, centripetal acceleration will also decrease");
            return ans3 = "F";
        }
        else if (q3==4){
            questionThreeTextView.setText("On banked curve, a component of F normal contributes to centripetal force");
            return ans3 = "T";
        }
        else{
            questionThreeTextView.setText("Centripetal acceleration is towards the centre of the circle ");
            return ans3 = "T";
        }

    }

    //method to generate question 4, display it on screen, and return the answer as a "T" or "F" string
    public String questionFour(){

        Random generator = new Random();
        int q4 = 1 + generator.nextInt(5);

        if (q4 == 1){
            questionFourTextView.setText("Momentum is conserved in all collisions");
            return ans4 = "T;";
        }
        else if (q4 ==2){
            questionFourTextView.setText("Kinetic energy is conserved in inelastic collisions");
            return ans4 = "F";
        }
        else if (q4 == 3){
            questionFourTextView.setText("Momentum is a scalar quantity");
            return ans4 = "F";
        }
        else if (q4==4){
            questionFourTextView.setText("The impulse of an object cannot be 0");
            return ans4 = "F";
        }
        else{
            questionFourTextView.setText("When Eg goes down, Ek must increase");
            return ans4 = "F";
        }

    }

    //method to generate question 5, display it on screen, and return the answer as a "T" or "F" string
    public String questionFive(){

        Random generator = new Random();
        int q5 = 1 + generator.nextInt(5);

        if (q5 == 1){
            questionFiveTextView.setText("Orbiting objects are always bound to the planet");
            return ans5 = "T";
        }
        else if (q5 ==2){
            questionFiveTextView.setText("g depends on the mass of the planet");
            return ans5 = "T";
        }
        else if (q5 == 3){
            questionFiveTextView.setText("All objects in orbit move in ellipses");
            return ans5 = "T";
        }
        else if (q5==4){
            questionFiveTextView.setText("Doubling orbital radius increases Kepler's constant");
            return ans5 = "F";
        }
        else{
            questionFiveTextView.setText("If |Ek|>|Eg|, the object can escape");
            return ans5 = "T";
        }

    }


    //event handling for the submit and try again buttons, and the radioGroups/radiobuttons
    public void addListenerOnButton() {

        //when user clicks submit button, even handling for the radioGroup will occur
        submitButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                score = 0;

                NumberFormat scoreFormat = NumberFormat.getIntegerInstance();

                //get selected radio button from radioGroup
                int selectedId = radioGroup1.getCheckedRadioButtonId();
                //find the radiobutton by returned id
                q1RadioButton = (RadioButton) findViewById(selectedId);

                //if selected radiobutton value ("T" or "F") matches the answer, add to score, otherwise, displays the wrong answer's question in red
                if (q1RadioButton.getText().equals(ans1) == true) {
                    score++;
                } else if (q1RadioButton.getText().equals(ans1) == false) {
                    questionOneTextView.setTextColor(getResources().getColor(R.color.redText));

                }


                //get selected radio button from radioGroup
                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                //find the radiobutton by returned id
                q2RadioButton = (RadioButton) findViewById(selectedId2);
                if (q2RadioButton.getText().equals(ans2) == true) {
                    score++;
                } else if (q2RadioButton.getText().equals(ans2) == false) {
                    questionTwoTextView.setTextColor(getResources().getColor(R.color.redText));


                }


                //get selected radio button from radioGroup
                int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                //find the radiobutton by returned id
                q3RadioButton = (RadioButton) findViewById(selectedId3);
                //if radiobutton value ("T" or "F") matches the answer, add to score, otherwise, displays the wrong answer's question in red
                if (q3RadioButton.getText().equals(ans3) == true) {
                    score++;
                } else if (q3RadioButton.getText().equals(ans3) == false) {
                    questionThreeTextView.setTextColor(getResources().getColor(R.color.redText));

                }

                //get selected radio button from radioGroup
                int selectedId4 = radioGroup4.getCheckedRadioButtonId();
                //find the radiobutton by returned id
                q4RadioButton = (RadioButton) findViewById(selectedId4);
                //if radiobutton value ("T" or "F") matches the answer, add to score, otherwise, displays the wrong answer's question in red
                if (q4RadioButton.getText().equals(ans4) == true) {
                    score++;
                } else if (q4RadioButton.getText().equals(ans4) == false) {
                    questionFourTextView.setTextColor(getResources().getColor(R.color.redText));


                }

                //get selected radio button from radioGroup
                int selectedId5 = radioGroup5.getCheckedRadioButtonId();
                //find the radiobutton by returned id
                q5RadioButton = (RadioButton) findViewById(selectedId5);
                //if radiobutton value ("T" or "F") matches the answer, add to score, otherwise, displays the wrong answer's question in red
                if (q5RadioButton.getText().equals(ans5) == true) {
                    score++;
                } else if (q5RadioButton.getText().equals(ans5) == false) {
                    questionFiveTextView.setTextColor(getResources().getColor(R.color.redText));


                }


                //display the user's score out of 5
                scoreTextView.setText(scoreFormat.format(score) +" /5");

            }
        });


        //when try again button is pressed, call the methods of each question to generate and display new answers
        //reset the red text of wrong answers back to black for the new round of questions
        tryAgainButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberFormat scoreFormat = NumberFormat.getIntegerInstance();
                score = 0;
                questionOne();
                questionTwo();
                questionThree();
                questionFour();
                questionFive();
                scoreTextView.setText(scoreFormat.format(score));
                questionOneTextView.setTextColor(getResources().getColor(R.color.blackText));
                questionTwoTextView.setTextColor(getResources().getColor(R.color.blackText));
                questionThreeTextView.setTextColor(getResources().getColor(R.color.blackText));
                questionFourTextView.setTextColor(getResources().getColor(R.color.blackText));
                questionFiveTextView.setTextColor(getResources().getColor(R.color.blackText));

            }

        });

    }


}
