package com.vpb.www.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().trim().length()==0 || password.getText().toString().trim().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Fill all the details",Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),username.getText().toString().trim(),Toast.LENGTH_LONG).show();


                }

                else if(username.getText().toString().equals("iotracx") && password.getText().toString().equals("1111"))
                {


                    Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(i);
                }


            }
        });

    }
}
