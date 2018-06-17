package com.sagar.boogiewoogienepal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class customAdapterSpinner extends ArrayAdapter<String> {
    Context context;
    String[] names;

    public customAdapterSpinner(Context context,String[] names)
    {
        super(context, R.layout.spinnercontent,names);
        this.context=context;
        this.names = names;

    }
    @Override

    public View getDropDownView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinnercontent,null);
        TextView t1 = (TextView)row.findViewById(R.id.textview);

        t1.setText(names[position]);

        return  row;

    }
    @Override
    public  View getView (int position,View convertView,ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinnercontent,null);
        TextView t1 = (TextView)row.findViewById(R.id.textview);


        t1.setText(names[position]);

        return  row;
    }
}
