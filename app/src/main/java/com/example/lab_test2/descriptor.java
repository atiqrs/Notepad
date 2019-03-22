package com.example.lab_test2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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

        title = findViewById(R.id.title); //Linked with XML id
        description = findViewById(R.id.description);
        save = findViewById(R.id.save);

        sp = getSharedPreferences(SHERED_PREF, MODE_PRIVATE); //Initialize Shared Preferencces
        editor = sp.edit();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData(); //Put the value save and update
                updateData();
                finish();
            }
        });
    }
    private void saveData() {

        String t = title.getText().toString(); //Put the values
        String d = description.getText().toString();
        editor.putString("Title",t);
        editor.putString("Desc",d);

        editor.apply(); //Apply the change
    } //Save all data on SharedPreferences

    private void updateData() {

        String tt = sp.getString("Title",null); //Keep the values on EditText
        title.setText(tt);
        String dd = sp.getString("Desc",null);
        description.setText(dd);

        MainActivity.one.setText(tt+"\n\n"+dd); //Update Data/values on Luncher Activity
    }
}
