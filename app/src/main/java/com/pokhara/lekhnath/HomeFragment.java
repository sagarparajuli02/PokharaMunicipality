package com.pokhara.lekhnath;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.pokhara.lekhnath.Chater.CitizenChater;
import com.pokhara.lekhnath.Fragments.IntroFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment  implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<PersonUtilsHomeNews> personUtilsHomeNewsList;

    RequestQueue rq;

    String request_url = "http://municipality1.000webhostapp.com/sagar/news.php";

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);



        final android.support.v4.app.FragmentManager fm = getFragmentManager();

        Button        Downloads=(Button)view.findViewById(R.id.downloadsPage);
        Button Staff=(Button)view.findViewById(R.id.staffPage);
        Button Chater=(Button)view.findViewById(R.id.chaterPage);
        Button Home=(Button)view.findViewById(R.id.homePage);
        Button Represent=(Button)view.findViewById(R.id.representPage);
        Button viewAllNews=(Button)view.findViewById(R.id.ViewAllNews);
        Button Trash = (Button) view.findViewById(R.id.trash);

        Button house=(Button)view.findViewById(R.id.gharPage);
        Button planning=(Button)view.findViewById(R.id.yojanaPage);

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent house = new Intent(getContext(),House.class) ;
                startActivity(house);
            }
        });
        planning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent plan = new Intent(getContext(),Planning.class) ;
                startActivity(plan);
            }
        });


        Trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trash = new Intent(getContext(),TenderActivity.class) ;
                startActivity(trash);
            }
        });


        viewAllNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent news= new Intent(getContext(),News.class);
                startActivity(news);
            }
        });


        Chater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chater= new Intent(getContext(), CitizenChater.class);
                startActivity(chater);
            }
        });
        Downloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent downloads= new Intent(getContext(), Downloads.class);
                startActivity(downloads);
            }
        });
        Represent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent employee= new Intent(getContext(), StaffWorker.class);
                startActivity(employee);
            }
        });
        Staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent staff= new Intent(getContext(), EmployeeWorker.class);
                startActivity(staff);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fm.beginTransaction()
                        .add(new HomeFragment(),"HomeFragment")
                        .addToBackStack("HomeFragment")
                        .replace(R.id.frame,new IntroFragment()).commit();
            }
        });



        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout)view.findViewById(R.id.slider);

        Hash_file_maps.put("पोखरा लेखनाथ महानगरपालिका ", "http://botanicaltreks.com/wp-content/uploads/2017/09/macchapucchre-trek.jpg");
        Hash_file_maps.put("नगर प्रमुख श्री मान बहादुर जि. सी. ब्रिक्ष रोपन कार्यक्रममा सरिग हुदै", "http://pokharamun.gov.np/sites/pokharamun.gov.np/files/gallery/padbahar.jpg");
        Hash_file_maps.put("पोखरा लेखनाथ महानगरपालिका र न्यू आइ टि भेन्चर कर्पोरेसन (जापान) बिच स्मार्ट सिटि सम्भाब्यता अध्ययन का लागि कर्यकारी अधिकृत दीर्घ नारायण पौडेल र कर्यकारी निर्देशक तदासी मोरिद्वारा समझदारी पत्रमा हस्ताक्षर गर्दै ", "http://pokharamun.gov.np/sites/pokharamun.gov.np/files/gallery/FB_IMG_1505962341489.jpg");

        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(getContext());
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(this);

      //  final android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();;
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Main   code will be here for the deafult home fragments


        rq = Volley.newRequestQueue(getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        personUtilsHomeNewsList = new ArrayList<>();

        sendRequest();


        return view;
    }


    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getContext(),slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = response.length()-1; i >=response.length()-2; i--){

                    PersonUtilsHomeNews personUtilsHomeNews = new PersonUtilsHomeNews();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        personUtilsHomeNews.setPersonFirstName(jsonObject.getString("name"));
                        personUtilsHomeNews.setJobProfile(jsonObject.getString("position"));
                        personUtilsHomeNews.setImage(jsonObject.getString("photo"));
                        personUtilsHomeNews.setLink(jsonObject.getString("link"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    personUtilsHomeNewsList.add(personUtilsHomeNews);

                }

                mAdapter = new CustomAdapterHomeNews(getContext(), personUtilsHomeNewsList);

                recyclerView.setAdapter(mAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonArrayRequest);

    }

}
