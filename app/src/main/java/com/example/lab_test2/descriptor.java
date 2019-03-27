package com.example.lab_test2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.lab_test2.MainActivity.num;


public class descriptor extends AppCompatActivity {

    final String SHERED_PREF = "Note1";
    EditText title,description;
    Button save;
    String TitleTag,DescTag;
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

        showData();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData(); //Put the value save and update
                updateData();
                MainDataShow();
                finish();
            }
        });
    }

    private void MainDataShow() {

    }

    private void showData() {
        if(num == 1){
            TitleTag = "T1";
            DescTag = "D1";

            String OneBtnTitle = sp.getString(TitleTag,null);
            String OneBtnDesc = sp.getString(DescTag,null);

            if (OneBtnTitle != null){
                title.setText(OneBtnTitle);
                description.setText(OneBtnDesc);
            }
        } else if (num == 2){
            TitleTag = "T2";
            DescTag = "D2";
            String OneBtnTitle = sp.getString(TitleTag,null);
            String OneBtnDesc = sp.getString(DescTag,null);
            if (OneBtnTitle != null){
                title.setText(OneBtnTitle);
                description.setText(OneBtnDesc);
            }
        } else if (num == 3){
            TitleTag = "T3";
            DescTag = "D3";
            String OneBtnTitle = sp.getString(TitleTag,null);
            String OneBtnDesc = sp.getString(DescTag,null);
            if (OneBtnTitle != null){
                title.setText(OneBtnTitle);
                description.setText(OneBtnDesc);
            }
        } else if (num == 4){
            TitleTag = "T4";
            DescTag = "D4";
            String OneBtnTitle = sp.getString(TitleTag,null);
            String OneBtnDesc = sp.getString(DescTag,null);
            if (OneBtnTitle != null){
                title.setText(OneBtnTitle);
                description.setText(OneBtnDesc);
            }
        } else if (num == 5){
            TitleTag = "T5";
            DescTag = "D5";
            String OneBtnTitle = sp.getString(TitleTag,null);
            String OneBtnDesc = sp.getString(DescTag,null);
            if (OneBtnTitle != null){
                title.setText(OneBtnTitle);
                description.setText(OneBtnDesc);
            }

        }
    }

    private void saveData() {

        String t = title.getText().toString(); //Put the values
        String d = description.getText().toString();
        editor.putString(TitleTag,t);
        editor.putString(DescTag,d);

        editor.apply(); //Apply the change
    } //Save all data on SharedPreferences

    private void updateData() {

        String tt = sp.getString(TitleTag,null); //Keep the values on EditText
        title.setText(tt);
        String dd = sp.getString(DescTag,null);
        description.setText(dd);

        if (num == 1)
            MainActivity.one.setText(tt+"\n\n"+dd); //Update Data/values on Luncher Activity
        else if (num == 2)
            MainActivity.two.setText(tt+"\n\n"+dd);
        else if (num == 3)
            MainActivity.three.setText(tt+"\n\n"+dd);
        else if (num == 4)
            MainActivity.four.setText(tt+"\n\n"+dd);
        else if (num == 5)
            MainActivity.five.setText(tt+"\n\n"+dd);
    }
}
