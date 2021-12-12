package com.example.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SurveyActivity extends AppCompatActivity {

    TextView greatText,questionText;
    String[] langs={"arabic","englis","spanish"};
    byte i,yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        greatText=findViewById(R.id.greatText);
        questionText=findViewById(R.id.questionText);
        String name=getIntent().getStringExtra("name");
        greatText.setText("hello"+name);
        questionText.setText("do you apeak "+langs[0]);
    }


    public void answer(View view) {
        if (view.getId()==R.id.yesButton){
            yes++;
        }
        else{
            no++;
        }
        i++;
        if (i<langs.length){
            questionText.setText("do you speak"+langs[0]);
        }
        else{
            Intent returnIntent = new Intent(this, MainActivity.class);
            returnIntent.putExtra("yes",yes);
            returnIntent.putExtra("no",no);
            setResult(RESULT_OK, returnIntent);
            finish();
        }
    }
}