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
        q2 = new Question(getString(R.string.qText2), false);
        q3 = new Question(getString(R.string.qText3), true);
        q4 = new Question(getString(R.string.qText4), false);
        q5 = new Question(getString(R.string.qText5), true);
        q6 = new Question(getString(R.string.qText6), false);
        currentQ = q1;
        questions = new Question[] {q1, q2, q3, q4, q5, q6};


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.getCorrectAnswer()== true){
                    message = getString(R.string.rightMsg);
                    score ++;
                }
                else {
                    message = getString(R.string.wrongMsg);
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
                    message = getString(R.string.rightMsg);
                    score ++;
                }
                else {
                    message = getString(R.string.wrongMsg);
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