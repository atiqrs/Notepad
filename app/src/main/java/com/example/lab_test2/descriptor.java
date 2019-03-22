package com.example.lab_test2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.lab_test2.MainActivity;


public class descriptor extends AppCompatActivity {

    final String SHERED_PREF = "Note1";
    EditText title,description;
    Button save;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptor);

        //Linked with XML id
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        save = findViewById(R.id.save);

        //Initialize Shared Preferencces
        sp = getSharedPreferences(SHERED_PREF, MODE_PRIVATE);
        editor = sp.edit();

        //
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Put the value save and update
                saveData();
                updateData();
                finish();
            }
        });
    }
    private void saveData() {

        //Put the values
        String t = title.getText().toString();
        String d = description.getText().toString();
        editor.putString("Title",t);
        editor.putString("Desc",d);

        //Apply the change
        editor.apply();
    } //Save all data on SharedPreferences

    private void updateData() {

        //Keep the values on EditText
        String tt = sp.getString("Title",null);
        title.setText(tt);
        String dd = sp.getString("Desc",null);
        description.setText(dd);

        //Update Data/values on Luncher Activity
        MainActivity.one.setText(tt+"\n\n"+dd);
    }
}
