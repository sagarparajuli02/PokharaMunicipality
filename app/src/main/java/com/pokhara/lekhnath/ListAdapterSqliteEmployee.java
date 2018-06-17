package com.pokhara.lekhnath;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapterSqliteEmployee extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> S_Name;
    ArrayList<String> S_Full_Form;
    ArrayList<String> S_Image;
    ArrayList<String> S_Email;
    ArrayList<String> S_Number;


    public ListAdapterSqliteEmployee(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> sub_name,
            ArrayList<String> Sub_full,
            ArrayList<String> Sub_image,
              ArrayList<String> Sub_email,
            ArrayList<String> Sub_number
    )
    {

        this.context = context2;
        this.ID = id;
        this.S_Name = sub_name;
        this.S_Full_Form = Sub_full;
        this.S_Image = Sub_image;
        this.S_Email = Sub_email;
        this.S_Number = Sub_number;
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
//new for repeated data
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public View getView(final int position, View child, ViewGroup parent) {

        final Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.sqliteitemsnewsemployee, null);

            holder = new Holder();


            holder.Subject_TextView = (TextView) child.findViewById(R.id.textViewSubject);
            holder.SubjectFullFormTextView = (TextView) child.findViewById(R.id.textViewSubjectFullForm);
            holder.SubjectImage= (ImageView)child.findViewById(R.id.imageEmployee);
            holder.Subject_Email= (TextView)child.findViewById(R.id.employeeEmail);
            holder.SubjectNumber= (TextView)child.findViewById(R.id.employeeNumber);

//
//            holder.SubjectNumber.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
//                    callIntent.setData(Uri.parse("tel:" + S_Number.get(position)));
//
//                    context.startActivity(callIntent);
//                }
//            });



            child.setTag(holder);


        } else {

            holder = (Holder) child.getTag();
        }
        holder.Subject_TextView.setText(S_Name.get(position));
        holder.SubjectFullFormTextView.setText(S_Full_Form.get(position));
        holder.Subject_Email.setText(S_Email.get(position));
        holder.SubjectNumber.setText(S_Number.get(position));
        Picasso.with(context)
                .load(S_Image.get(position))
                .placeholder(R.drawable.manager)
                .into(holder.SubjectImage);
        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent details= new Intent(context,StaffDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",S_Name.get(position));
                bundle.putString("post",S_Full_Form.get(position));
                bundle.putString("image",S_Image.get(position));
                bundle.putString("email",S_Email.get(position));
                bundle.putString("number",S_Number.get(position));
                details.putExtras(bundle);
                context.startActivity(details);
            }
        });

        return child;
    }


    public class Holder {

        TextView Subject_TextView;
        TextView SubjectFullFormTextView;
        TextView Subject_Email;
        TextView SubjectNumber;
        ImageView SubjectImage;
    }

}