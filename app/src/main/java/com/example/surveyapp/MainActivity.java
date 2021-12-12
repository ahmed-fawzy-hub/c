package com.example.surveyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    EditText nameText;
    Button startButton;
    ListView lvNames;
    ArrayList<String> names=new ArrayList<>();
    ArrayList<User> users=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvNames=findViewById(R.id.lvNames);
        nameText=findViewById(R.id.nameText);
        startButton=findViewById(R.id.startButton);
        nameText.addTextChangedListener(this);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        lvNames.setAdapter(adapter);
    }

    public void start(View view) {
        Intent in=new Intent(this,SurveyActivity.class);
        in.putExtra("name",nameText.getText().toString());
        startActivityForResult(in,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
           byte yes= data.getByteExtra("yes", (byte) -1);
           byte no=data.getByteExtra("no",(byte)-1);
           names.add(nameText.getText().toString());
           users.add(new User(nameText.getText().toString(),yes,no));
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(nameText.getText().toString().length()>2){
            startButton.setEnabled(true);
        }
        else{
            startButton.setEnabled(false);
        }

    }

    public void users(MenuItem item) {
        Intent in=new Intent(this,viewActivity.class);
        in.putExtra("users",users);
        startActivity(in);
    }
}