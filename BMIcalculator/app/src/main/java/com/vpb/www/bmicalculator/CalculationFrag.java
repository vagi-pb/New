package com.vpb.www.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class CalculationFrag extends Fragment {

    DBHelper dbHelper;



    private EditText age,weight,height,distance;
    private Button calculate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.calculationfrag,container,false);
        return view;

    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        age=(EditText)view.findViewById(R.id.age);
        weight=(EditText)view.findViewById(R.id.weight);
        height=(EditText)view.findViewById(R.id.height);
        distance=(EditText)view.findViewById(R.id.distance);
        calculate=(Button)view.findViewById(R.id.calculatebtn);
        dbHelper=new DBHelper(getContext());



        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(age.getText().toString().equals("")
                        || weight.getText().toString().equals("")
                        || height.getText().toString().equals("")
                        || distance.getText().toString().equals("") ){

                    Toast.makeText(getContext(),"Enter all the fields",Toast.LENGTH_LONG).show();
                }

                else
                {
                    float bmiresult = parseFloat(weight.getText().toString())
                             / ((parseFloat(height.getText().toString())/100)
                             * (parseFloat(height.getText().toString())/100));

                    float time=((parseFloat(distance.getText().toString())/(1000))/2)*60;
                    double calorieburn = ( (parseFloat(age.getText().toString()) * 0.2017)
                             + ((parseFloat(weight.getText().toString()) )* 0.1988)
                             + (72 * 0.6309)
                             - 55.0969)
                             * time / 4.184;

                    dbHelper.insert(String.format("%.2f",bmiresult),String.format("%.2f",calorieburn));
                    Intent i = new Intent(view.getContext(),second.class);
                    i.putExtra("bmiresult",String.format("%.2f",bmiresult));
                    i.putExtra("calories",String.format("%.2f",calorieburn)+" Cal");
                    startActivity(i);

                }

            }
        });

    }
}

