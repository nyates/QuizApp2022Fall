package com.patterson.helloname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1. declare our variables, including UI elements
    TextView questionTV;
    Button trueBTN, falseBTN, finishedBTN;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. initialize our variables and inflate our UI elements
        questionTV = (TextView) findViewById(R.id.questionTV);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        finishedBTN = (Button) findViewById(R.id.finishedBTN);
        score=0;

        // 3. write code to make app do what we want
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getApplicationContext(), "You got it wrong",Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getApplicationContext(), "You got it right",Toast.LENGTH_SHORT);
                myToast.show();
                score = score + 1;
            }
        });

        finishedBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                myIntent.putExtra("score", score);
                startActivity(myIntent);
            }
        });


    }
}