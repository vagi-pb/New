package com.vpb.www.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static java.lang.Float.parseFloat;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second1);
        Intent intent=getIntent();

        TextView textView=(TextView)findViewById(R.id.resultof);
        TextView textView1=(TextView)findViewById(R.id.bmicategory);
        TextView calories=(TextView)findViewById(R.id.calories);

        textView.setText(intent.getStringExtra("bmiresult"));
        calories.setText(intent.getStringExtra("calories"));

        float swc=parseFloat(intent.getStringExtra("bmiresult"));

        if(swc<15)
        {
            textView1.setText("Very severely underweight");
        }
        else if(swc>15 && swc<16)
        {
            textView1.setText("Severely underweight");
        }
        else if(swc>16 && swc<18.5)
        {
            textView1.setText("Underweight");
        }
        else if(swc>18.5 && swc<25)
        {
            textView1.setText("Normal (healthy weight)");
        }
        else if(swc>25 && swc<30)
        {
            textView1.setText("Overweight");
        }
        else if(swc>30 && swc<35)
        {
            textView1.setText("Moderately obese");
        }
        else if(swc>35 && swc<40)
        {
            textView1.setText("Severely obese");
        }
        else if(swc>50)
        {
            textView1.setText("Very severely obese");
        }
    }
}
