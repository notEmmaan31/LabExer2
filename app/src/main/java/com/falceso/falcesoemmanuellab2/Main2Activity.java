package com.falceso.falcesoemmanuellab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    private Button btn_verify;
    private EditText txt_school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);





        txt_school = findViewById(R.id.txt_school);

        btn_verify = findViewById(R.id.btn_verify);
        btn_verify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
                boolean isSchool = false;
                Set<String> set = pref.getStringSet("set",null);
                for (String s : set){
                    if(s.toLowerCase().equals(String.valueOf(txt_school.getText()).toLowerCase())){
                        isSchool = true;
                        }
                }

                if(isSchool){

                    Toast.makeText(getApplicationContext(),"School is competing in UAAP",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"School is not competing in UAAP", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
