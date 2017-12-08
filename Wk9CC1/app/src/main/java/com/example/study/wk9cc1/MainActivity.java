package com.example.study.wk9cc1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView my1sttextView;
    Button my1stButton;
    Button my2ndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my1sttextView =(TextView) findViewById(R.id.textView3);
        my1stButton =(Button) findViewById(R.id.button1);
        my2ndButton =(Button) findViewById(R.id.button2);


        my2ndButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(my1sttextView.getVisibility() ==View.INVISIBLE) {
                    my1sttextView.setVisibility(View.VISIBLE);
                } else {
                    my1sttextView.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });


    }

    public void whenClick(View v) {
        if(my1sttextView.getVisibility() ==View.INVISIBLE) {
            my1sttextView.setVisibility(View.VISIBLE);
        } else {
            my1sttextView.setVisibility(View.INVISIBLE);
        }
    }
}
