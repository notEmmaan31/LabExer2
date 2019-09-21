package com.falceso.falcesoemmanuellab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button btn_save, btn_next;
    private EditText editText1, editText2, editText3,editText4, editText5, editText6, editText7, editText8;
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("pref",MODE_PRIVATE);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);


        btn_save= findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                editor = pref.edit();

                Set<String> set = new HashSet<>();

                set.add(String.valueOf(editText1.getText()));
                set.add(String.valueOf(editText2.getText()));
                set.add(String.valueOf(editText3.getText()));
                set.add(String.valueOf(editText4.getText()));
                set.add(String.valueOf(editText5.getText()));
                set.add(String.valueOf(editText6.getText()));
                set.add(String.valueOf(editText7.getText()));
                set.add(String.valueOf(editText8.getText()));
                editor.putStringSet("set",set);

                editor.apply();
            }
        });

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nextActivity();
            }
        });
    }

    public void nextActivity(){
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }

    }


