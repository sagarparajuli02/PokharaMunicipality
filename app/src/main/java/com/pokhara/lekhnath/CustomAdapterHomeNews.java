package com.pokhara.lekhnath;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class CustomAdapterHomeNews extends RecyclerView.Adapter<CustomAdapterHomeNews.ViewHolder> {

    private Context context;
    private List<PersonUtilsHomeNews> personUtilHomeNews;

    public CustomAdapterHomeNews(Context context, List personUtils) {
        this.context = context;
        this.personUtilHomeNews = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item_home_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(personUtilHomeNews.get(position));

        PersonUtilsHomeNews pu = personUtilHomeNews.get(position);

        holder.pName.setText(pu.getPersonFirstName());
        holder.pJobProfile.setText(pu.getJobProfile());
        holder.link.setText(pu.getLink());
        Picasso.with(context)
                .load(pu.getImage())
                .placeholder(R.drawable.news1)
                .into(holder.iimage);



    }

    @Override
    public int getItemCount() {
        return personUtilHomeNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView pName;
        public TextView pJobProfile;
        public ImageView  iimage;
        public  TextView link;

        public ViewHolder(View itemView) {
            super(itemView);

            pName = (TextView) itemView.findViewById(R.id.pNametxt);
            pJobProfile = (TextView) itemView.findViewById(R.id.pJobProfiletxt);
            link = (TextView) itemView.findViewById(R.id.link);
            iimage= (ImageView)itemView.findViewById(R.id.userImg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    PersonUtilsHomeNews cpu = (PersonUtilsHomeNews) view.getTag();

                    Intent details= new Intent(context,NewsDetails.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("title",cpu.getPersonFirstName());
                    bundle.putString("description",cpu.getJobProfile());
                bundle.putString("image",cpu.getImage());
                    bundle.putString("link",cpu.getLink());
                    details.putExtras(bundle);
                    context.startActivity(details);
                }
            });

        }
    }

}