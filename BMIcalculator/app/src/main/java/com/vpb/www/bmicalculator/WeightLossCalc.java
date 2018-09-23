package com.vpb.www.bmicalculator;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;

public class WeightLossCalc {

    double stepstaken;

    public String approxweightlost(List<String> calorie,List<String> date){

        double todaysweightloss;

        todaysweightloss=parseFloat(calorie.get(0));
        List<String> exactdate=new ArrayList<>();


            for (int k = 0; k < date.size(); k++) {
                int r = date.get(k).indexOf(" ");
                String temp = date.get(k).substring(0, r);
                exactdate.add(temp);


        }




                for (int i = 1; i < calorie.size(); i++) {


                    if (exactdate.get(i).equals(exactdate.get(i - 1))) {
                        todaysweightloss = todaysweightloss + parseFloat(calorie.get(i));
                    }
                }

                stepstaken = todaysweightloss * 20;


                todaysweightloss = (todaysweightloss * 0.454)/3500;


     return String.format("%.5f",todaysweightloss);
    }
}
