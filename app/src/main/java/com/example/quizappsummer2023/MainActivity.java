package com.example.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionTV;
    Button falseButton, trueButton, nextButton;
    int score;
    Question q1, q2, q3, q4, q5, q6, currentQ;
    Question[] questions;
    int currentIndex;
    String message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = (TextView) findViewById(R.id.questionTV);
        falseButton = (Button) findViewById(R.id.falseButton);
        trueButton = (Button) findViewById(R.id.trueButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        score = 0;
        currentIndex = 0;
        q1 = new Question("Did Martin Luther King Jr. make a speech in Washington DC?", true);
        q2 = new Question( "Vermont was the first colony to ban slavery in 1800", false);
        q3 = new Question("In the 1770s, a Quaker named Anthony Benezet created the first school for African American children", true);
        q4 = new Question("William Tucker, son of indentured servants from Great Britian, was the first recorded African child to be born in the colonies in 1620", false);
        q5 = new Question("There was a Black wall street in Tulsa, OK", true);
        q6 = new Question("The first black woman ran for president in, 1969 and was almost assassinated three times", false);
        currentQ = q1;
        questions = new Question[] {q1, q2, q3, q4, q5, q6};


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.getCorrectAnswer()== true){
                    message = "You are correct";
                    score ++;
                }
                else {
                    message = "You are wrong";
                }

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), message, duration);
                toast.show();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentQ.getCorrectAnswer()== false){
                    message = "You are correct";
                    score ++;
                }
                else {
                    message = "You are wrong";
                }

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), message, duration);
                toast.show();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex < 6){
                    currentQ = questions[currentIndex];
                    questionTV.setText(currentQ.getqPrompt());
                }
                else
                {
                    Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    scoreIntent.putExtra("score", score);
                    startActivity(scoreIntent);
                 }


            }

        });
    }
}