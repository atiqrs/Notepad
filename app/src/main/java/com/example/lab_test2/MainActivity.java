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
    static int num;
    SharedPreferences sp;
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
                num = 1;
                Intent i = new Intent(MainActivity.this,descriptor.class);
                startActivity(i);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 2;
                Intent i = new Intent(MainActivity.this,descriptor.class);
                startActivity(i);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 3;
                Intent i = new Intent(MainActivity.this,descriptor.class);
                startActivity(i);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 4;
                Intent i = new Intent(MainActivity.this,descriptor.class);
                startActivity(i);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 5;
                Intent i = new Intent(MainActivity.this,descriptor.class);
                startActivity(i);
            }
        });

        diplayData();

    }

    private void diplayData() {
        SharedPreferences sp = getSharedPreferences("Note1",MODE_PRIVATE);

        //Keep the values on EditText
        String a1=sp.getString("T1",null);
        String b1=sp.getString("D1",null);

        if(a1!=null && b1!=null) {
            one.setText(sp.getString("T1",null)+"\n\n"+sp.getString("D1",null));
        }
        else
            one.setText("");
        two.setText(sp.getString("T2",null)+"\n\n"+sp.getString("D2",null));
        three.setText(sp.getString("T3",null)+"\n\n"+sp.getString("D3",null));
        four.setText(sp.getString("T4",null)+"\n\n"+sp.getString("D4",null));

        String a5=sp.getString("T5",null);
        String b5=sp.getString("D5",null);

        if(a5!=null && b5!=null) {
            five.setText(sp.getString("T5",null)+"\n\n"+sp.getString("D5",null));
        }
        else
            one.setText("");

    }
}
