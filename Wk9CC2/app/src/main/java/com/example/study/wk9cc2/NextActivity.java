package com.example.study.wk9cc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        welcome =(TextView) findViewById(R.id.welcomexx);

        //receive the intent and retrieve the message

        Intent intent =getIntent();
//
        String message =intent.getStringExtra(MainActivity.KEY);

        //set welcome message
        welcome.setText("Welcome " +message);
//        Intent a = new Intent(this,MainActivity.class);
//        startActivity(a);
    }
}
