package com.example.lab_test2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView one;
    static TextView two;
    static TextView three;
    static TextView four;
    static TextView five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,descriptor.class);
                startActivity(i);
            }
        });

        diplayData();
    }

    private void diplayData() {
        SharedPreferences sp = getSharedPreferences("Note1",MODE_PRIVATE);
        String show = sp.getString("Title",null);
        if(show != null){
            one.setText(show);
        }
    }
}
