package com.example.quizzapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Categories_Adapter extends ArrayAdapter<Categories_Items> {
    Activity context;
    ArrayList<Categories_Items> cate_items;
    int layoutID;

    public Categories_Adapter(Activity context, int layoutID, ArrayList<Categories_Items> cate_items) {
        super(context, layoutID, cate_items);
        this.layoutID = layoutID;
        this.context = context;
        this.cate_items = cate_items;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(layoutID, null);

        ImageButton CateImg = row.findViewById(R.id.CateImg);
        TextView CateName = row.findViewById(R.id.CateName);
        TextView CateQ = row.findViewById(R.id.CateQ);
        LinearLayout rowLayout = row.findViewById(R.id.row_layout);
        Categories_Items c = cate_items.get(position);
        CateImg.setImageResource(c.getCateImg());
        CateName.setText(c.getCateName());
        CateQ.setText(c.getCateQ());
        row.setBackgroundColor(c.getBackgroundColor());
        CateImg.setFocusable(false);
        CateImg.setFocusableInTouchMode(false);
        CateImg.setClickable(false);
        return row;
    }
}
