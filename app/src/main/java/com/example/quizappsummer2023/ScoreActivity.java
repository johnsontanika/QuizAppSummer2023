package com.example.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    int score;
    String name;
    Button sendScoreBtn, highScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);
        sendScoreBtn = (Button) findViewById(R.id.sendScoreBTN);
        highScore = (Button) findViewById(R.id.highScore);

        sendScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String subject = "new score on quiz app";
                    String body = "Hello!\n" + "Your score" + score;
                    composeEmail(subject, body);
            }
        });
        Intent incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", 0);
        name = incomingIntent.getStringExtra("name");

        scoreTV.setText("Score =" + score);

    }
    private void composeEmail(String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }
}