package com.pokhara.lekhnath;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapterSqlite extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> S_Name;
    ArrayList<String> S_Full_Form;
    ArrayList<String> S_Image;


    public ListAdapterSqlite(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> sub_name,
            ArrayList<String> Sub_full,
            ArrayList<String> Sub_image
    )
    {

        this.context = context2;
        this.ID = id;
        this.S_Name = sub_name;
        this.S_Full_Form = Sub_full;
        this.S_Image = Sub_image;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return ID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.sqliteitems, null);

            holder = new Holder();


            holder.Subject_TextView = (TextView) child.findViewById(R.id.textViewSubject);
            holder.SubjectFullFormTextView = (TextView) child.findViewById(R.id.textViewSubjectFullForm);
            holder.SubjectImage= (ImageView)child.findViewById(R.id.imageEmployee);

            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.Subject_TextView.setText(S_Name.get(position));
        holder.SubjectFullFormTextView.setText(S_Full_Form.get(position));
        Picasso.with(context)
                .load(S_Image.get(position))
                .placeholder(R.drawable.manager)
                .into(holder.SubjectImage);

        return child;
    }

    public class Holder {

        TextView Subject_TextView;
        TextView SubjectFullFormTextView;
        ImageView SubjectImage;
    }

}