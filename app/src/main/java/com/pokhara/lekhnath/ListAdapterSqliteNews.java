package com.pokhara.lekhnath;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapterSqliteNews extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> S_Name;
    ArrayList<String> S_Full_Form;
    ArrayList<String> S_Image;
    ArrayList<String> S_Link;


    public ListAdapterSqliteNews(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> sub_name,
            ArrayList<String> Sub_full,
            ArrayList<String> Sub_image,
             ArrayList<String> Sub_link
    )
    {

        this.context = context2;
        this.ID = id;
        this.S_Name = sub_name;
        this.S_Full_Form = Sub_full;
        this.S_Image = Sub_image;
        this.S_Link = Sub_link;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return ID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
      //  return null;
        //paila null thiyo paxi
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
       // return 0;
        return position;
    }

    public View getView(final int position, View child, ViewGroup parent) {

        final Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.sqliteitemsnews, null);

            holder = new Holder();


            holder.Subject_TextView = (TextView) child.findViewById(R.id.textViewSubject);
            holder.SubjectFullFormTextView = (TextView) child.findViewById(R.id.textViewSubjectFullForm);
            holder.SubjectImage= (ImageView)child.findViewById(R.id.imageEmployee);
            holder.SubjectLink= (Button) child.findViewById(R.id.newslink);

            child.setTag(holder);


        } else {

            holder = (Holder) child.getTag();
        }
        holder.Subject_TextView.setText(S_Name.get(position));
        holder.SubjectFullFormTextView.setText(S_Full_Form.get(position));
        holder.SubjectLink= (Button) child.findViewById(R.id.newslink);
        Picasso.with(context)
                .load(S_Image.get(position))
                .placeholder(R.drawable.news1)
                .into(holder.SubjectImage);
        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent details= new Intent(context,NewsDetails.class);

//                   Bundle bundle = new Bundle();
//                    bundle.putString("title",S_Name.get(position));
//                    bundle.putString("description",S_Full_Form.get(position));
//                    bundle.putString("image",S_Image.get(position));
//                    bundle.putString("link",S_Link.get(position));
//                    details.putExtras(bundle);
//
                details.putExtra("title",S_Name.get(position));
                details.putExtra("description",S_Full_Form.get(position));
                details.putExtra("image",S_Image.get(position));
                details.putExtra("link",S_Link.get(position));
                context.startActivity(details);
            }
        });

        return child;
    }


    public class Holder {

        TextView Subject_TextView;
        TextView SubjectFullFormTextView;
        ImageView SubjectImage;
        Button SubjectLink;
    }

}