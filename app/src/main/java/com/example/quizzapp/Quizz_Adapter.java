package com.example.quizzapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Quizz_Adapter extends ArrayAdapter<Quizz_items> {

    Activity context;
    ArrayList<Quizz_items> quizzs;
    int layoutID;

    public Quizz_Adapter(Activity context, int layoutID, ArrayList<Quizz_items> quizzs){
        super(context, layoutID, quizzs);
        this.context = context;
        this.layoutID = layoutID;
        this.quizzs = quizzs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        ViewHolder holder;

        if (row == null){
            LayoutInflater inflater = context.getLayoutInflater();
            row = inflater.inflate(layoutID, null);

            holder = new ViewHolder();
            holder.idCauhoi = row.findViewById(R.id.idCauHoi);
            holder.ndCauhoi = row.findViewById(R.id.ndCauHoi);

            holder.rdGroup = row.findViewById(R.id.rdGroup);
            holder.rdA = row.findViewById(R.id.rdA);
            holder.rdB = row.findViewById(R.id.rdB);
            holder.rdC = row.findViewById(R.id.rdC);
            holder.rdD = row.findViewById(R.id.rdD);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Quizz_items q = quizzs.get(position);

        holder.idCauhoi.setText(q.getIdCauhoi());
        holder.ndCauhoi.setText(q.getNdCauhoi());

        holder.rdA.setText(q.getRdA());
        holder.rdB.setText(q.getRdB());
        holder.rdC.setText(q.getRdC());
        holder.rdD.setText(q.getRdD());

        holder.rdGroup.setOnCheckedChangeListener(null);

        // Set trạng thái đã chọn trước đó
        switch (q.userChoice) {
            case 0: holder.rdA.setChecked(true); break;
            case 1: holder.rdB.setChecked(true); break;
            case 2: holder.rdC.setChecked(true); break;
            case 3: holder.rdD.setChecked(true); break;
            default: holder.rdGroup.clearCheck(); break;
        }

        holder.rdGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == holder.rdA.getId()) q.userChoice = 0;
            else if (checkedId == holder.rdB.getId()) q.userChoice = 1;
            else if (checkedId == holder.rdC.getId()) q.userChoice = 2;
            else if (checkedId == holder.rdD.getId()) q.userChoice = 3;
        });

        return row;
    }

    static class ViewHolder {
        TextView idCauhoi, ndCauhoi;
        RadioGroup rdGroup;
        RadioButton rdA, rdB, rdC, rdD;
    }
}
