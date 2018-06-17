package com.pokhara.lekhnath;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PokharaLekhnath extends Fragment {


    public PokharaLekhnath() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_pokhara_lekhnath, container, false);
        ImageView Website= (ImageView) view.findViewById(R.id.website);
        ImageView Facebook=(ImageView)view.findViewById(R.id.facebook);

        Website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent web = new Intent();
                web.setAction(Intent.ACTION_VIEW);
                web.addCategory(Intent.CATEGORY_BROWSABLE);
                web.setData(Uri.parse("http://pokharalekhnathmun.gov.np/"));
                startActivity(web);
            }
        });
        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = new Intent();
                fb.setAction(Intent.ACTION_VIEW);
                fb.addCategory(Intent.CATEGORY_BROWSABLE);
                fb.setData(Uri.parse("https://www.facebook.com/pokharaleakhnathmetropolitancity/"));
                startActivity(fb);
            }
        });


        return  view;
    }

}
