package com.example.quizzapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class LB_Adapter extends ArrayAdapter<LB_items> {

    Activity context;
    ArrayList<LB_items> lb_items;
    int layoutID;
    int currentUserId;

    public LB_Adapter(Activity context, int layoutID, ArrayList<LB_items> lb_items, int currentUserId){
        super(context, layoutID, lb_items);
        this.context = context;
        this.layoutID = layoutID;
        this.lb_items = lb_items;
        this.currentUserId = currentUserId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(layoutID, null);

        TextView tvRank = row.findViewById(R.id.tv_rank);
        TextView tvName = row.findViewById(R.id.tv_name);
        TextView tvPoints = row.findViewById(R.id.tv_points);
       LinearLayout linearOp = row.findViewById(R.id.linearOption);
       FrameLayout frameOp = row.findViewById(R.id.frameOption);
        LB_items lb = lb_items.get(position);

        tvRank.setText(lb.getRank());
        tvName.setText(lb.getName());
        tvPoints.setText(lb.getPoints());
//tái sử dụng ở top score
        if (lb.getUserId() == currentUserId) {
            linearOp.setBackgroundResource(R.drawable.bg_op_true);
            frameOp.setBackgroundResource(R.drawable.bg_op4);
            tvName.setText("You");
            tvRank.setTypeface(tvName.getTypeface(), Typeface.BOLD);
            tvName.setTypeface(tvName.getTypeface(), Typeface.BOLD);
            tvPoints.setTypeface(tvPoints.getTypeface(), Typeface.BOLD);

            tvName.setTextColor(Color.BLACK);
            tvPoints.setTextColor(Color.GRAY);
            tvRank.setTextColor(Color.WHITE );
        } else {
            linearOp.setBackgroundResource(R.drawable.bg_op1);

            tvName.setTypeface(Typeface.DEFAULT);
            tvPoints.setTypeface(Typeface.DEFAULT);

            tvName.setTextColor(Color.BLACK);
            tvPoints.setTextColor(Color.GRAY);
        }


        return row;
    }
}
