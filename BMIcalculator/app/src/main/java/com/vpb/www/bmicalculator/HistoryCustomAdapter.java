package com.vpb.www.bmicalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryCustomAdapter extends BaseAdapter {

    List<String> bmi,calorieburn,time;
    Context c;
    private static LayoutInflater inflater=null;
    public HistoryCustomAdapter(Context historyfrag, List<String> bmis, List<String> calorieburns, List<String> times){
        bmi=new ArrayList<>();
        calorieburn=new ArrayList<>();
        time=new ArrayList<>();
        bmi=bmis;
        c=historyfrag;
        calorieburn=calorieburns;
        time=times;
        inflater = ( LayoutInflater )c.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return bmi.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView bmitext,calorieburntext,timetext;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.historylistlayout, null);
        holder.bmitext=(TextView) rowView.findViewById(R.id.bmitext);
        holder.calorieburntext=(TextView) rowView.findViewById(R.id.calorieburntext);
        holder.timetext=(TextView) rowView.findViewById(R.id.timetext);
        holder.bmitext.setText(bmi.get(position));
        holder.calorieburntext.setText(calorieburn.get(position)+" Cal");
        holder.timetext.setText(time.get(position).replace(" ","\n"));
        return rowView;

    }
}
