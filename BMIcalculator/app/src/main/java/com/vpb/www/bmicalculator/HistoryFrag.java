package com.vpb.www.bmicalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryFrag extends Fragment {

    DBHelper dbHelper;


    List<result> list=new ArrayList<>();
    ListView lst;
    TextView weightlosstext,approx,textview15,bmititle,calorietitle;
    TextView stepstext,totalsteps;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.historyfrag, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dbHelper=new DBHelper(getContext());
        lst=(ListView) view.findViewById(R.id.HistoryList);
        weightlosstext=(TextView) view.findViewById(R.id.weightLosstext);
        approx=(TextView) view.findViewById(R.id.approx);
        stepstext=(TextView) view.findViewById(R.id.stepstext);
        totalsteps=(TextView) view.findViewById(R.id.totalsteps);
        textview15=(TextView) view.findViewById(R.id.textView15);
        bmititle=(TextView) view.findViewById(R.id.bmititle);
        calorietitle=(TextView) view.findViewById(R.id.calorietitle);


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser)
        {

            if(dbHelper.getAllNotes().size()==0)
                Toast.makeText(getContext(),"no history",Toast.LENGTH_LONG).show();
            else{
               // Toast.makeText(getContext(),String.valueOf(dbHelper.getAllNotes().size()),Toast.LENGTH_LONG).show();
                List<String> bmiarr,caloriearr,timearr;
                bmiarr=new ArrayList<>();
                caloriearr=new ArrayList<>();
                timearr=new ArrayList<>();
                for(int i=0;i<dbHelper.getAllNotes().size();i++)
                {
                    for (int j=0;j<dbHelper.getAllNotes().get(0).size();j++){

                        if(j==0)
                        {
                           bmiarr.add(dbHelper.getAllNotes().get(i).get(j));
                        }
                        else if(j==1)
                        {

                            caloriearr.add(dbHelper.getAllNotes().get(i).get(j));
                        }

                        else if(j==2)
                        {
                           timearr.add(dbHelper.getAllNotes().get(i).get(j));
                        }


                    }
                }

                WeightLossCalc weightLossCalc=new WeightLossCalc();
                String weightloss;
                weightloss=weightLossCalc.approxweightlost(caloriearr,timearr);
                textview15.setText("KG");
                bmititle.setText("BMI");
                calorietitle.setText("Calorie");

                approx.setText("Approx. weight lost\n     today");
                weightlosstext.setText(weightloss+" ");
                stepstext.setText("Total steps taken\n     today");
                totalsteps.setText(String.format("%.0f",weightLossCalc.stepstaken));

                lst.setAdapter(new HistoryCustomAdapter(getContext(),bmiarr,caloriearr,timearr));

            }


        }

    }

}

