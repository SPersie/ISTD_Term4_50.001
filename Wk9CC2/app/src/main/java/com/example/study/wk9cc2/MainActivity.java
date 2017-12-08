package com.example.study.wk9cc2;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY ="NextActivity";
    private static final String TAG = "MyActivity";
    Button submit;
    EditText password;
    TextView name;
    RadioGroup showhidepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate() is invoked");
        setContentView(R.layout.activity_main);

        submit =(Button) findViewById(R.id.submmitbutton);
        password =(EditText) findViewById(R.id.mypassword);
        name =(TextView) findViewById(R.id.myname);
        showhidepassword =(RadioGroup) findViewById(R.id.showhidepassword);

        //radio group to show and hide password
        showhidepassword.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch(checkedId)
                {
                    case R.id.showpassword:
                        password.setTransformationMethod(null);
                        break;
                    case R.id.hidepassword:
                        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        break;
                }
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() is invoked");
    }

    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() is invoked");
    }

    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() is invoked");
    }

    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() is invoked");
    }



    public void onClick(View v) {
        //check if the password matches
        boolean isPasswordMatch;
        if(password.getText().toString().equals("lxx")) {
            isPasswordMatch =true;
            Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_SHORT).show();
        } else {
            isPasswordMatch =false;
            Toast.makeText(getApplicationContext(), password.getText().toString(), Toast.LENGTH_SHORT).show();
        }

        //get the context
        Context context =v.getContext();

        if(isPasswordMatch) {
            //write code for the intent
            Intent intent =new Intent(context, NextActivity.class);
            String message =name.getText().toString();
            intent.putExtra(KEY, message);
            startActivity(intent);
        } else {

        }
    }
}
