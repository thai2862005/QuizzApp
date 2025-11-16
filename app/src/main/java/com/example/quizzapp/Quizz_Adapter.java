package com.example.quizzapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Quizz_Adapter extends ArrayAdapter<Quizz_items> {
    Activity context;
    ArrayList<Quizz_items> quizzs;
    int layoutID;

    public Quizz_Adapter(Activity context, int layoutID, ArrayList<Quizz_items> quizzs){
        super(context, layoutID, quizzs);
        this.context = context;
        this.layoutID =layoutID;
        this.quizzs = quizzs;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(layoutID,null);
        TextView idCauhoi = row.findViewById(R.id.idCauHoi);
        TextView ndCauhoi = row.findViewById(R.id.ndCauHoi);
        RadioButton rdA = row.findViewById(R.id.rdA);
        RadioButton rdB = row.findViewById(R.id.rdB);
        RadioButton rdC = row.findViewById(R.id.rdC);
        RadioButton rdD = row.findViewById(R.id.rdD);
        Quizz_items q = quizzs.get(position);
        idCauhoi.setText(q.getIdCauhoi());
        ndCauhoi.setText(q.getNdCauhoi());
        rdA.setText(q.getRdA());
        rdB.setText(q.getRdB());
        rdC.setText(q.getRdC());
        rdD.setText(q.getRdD());
        return  row;
    }
}
