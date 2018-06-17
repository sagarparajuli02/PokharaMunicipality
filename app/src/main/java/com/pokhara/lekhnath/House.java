package com.pokhara.lekhnath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.pokhara.lekhnath.Chater.ExampleAdapter;
import com.pokhara.lekhnath.Chater.ExampleItem;

import java.util.ArrayList;

public class House extends AppCompatActivity {


    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        setTitle(R.string.house);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        createExampleList();
        buildRecyclerView();

    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();

         mExampleList.add(new ExampleItem(R.drawable.nepal, "नक्शा दरखास्त फारम", "नक्शा दरखास्त फारम","रु. ७०० र रु.१०००","सोही दिन","कर अधिकृत"));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "भवन निर्माण दरखास्त", "नक्शा दरखास्त फारम, नेपाली नागरिकताको प्रमाणपत्र, जग्गाधनी प्रमाण पुर्जाको प्रमाणपत्र, नापी कक्शा जग्गाको सिट नं. सहितको ब्लुप्रिन्ट, (सक्कल र नक्कल) घरनिर्माणको लागि महानगरपालिकाबाट ईजाजत प्रमाणपत्रको प्रतिलिपि, नक्शाभवन निर्माण स्वीकृतीका लगि महानगरपालिकाबाट इजाजत प्राप्त ईन्जिनियर÷ओभरसियरबाट घर (भवन)को बनोट डिजाइन सहितको घरको नक्शा, आवश्यक प्रमाण कागजात सहित कन्सलटेन्सी मार्फत अनलाईनबाट घरनक्शा दरखास्त पेश गर्ने, सम्बन्धीत ईन्जिनियरबाट स्वीकृत गरि स्थलगत निरीक्षण पछि घरनक्शा शाखाबाट सधियाराको नाममा जारी १५ दिने सूचना लिने सूचना टाँसको लागि सम्बन्धित वडामा गई वडा सचिवबाट सूचना टाँस गराउने, र १५ दिन पश्चात भवन निर्माण स्थलको सर्जमिन मुचुल्का गर्ने,","रु. ७००","१६ दिन","महाशाखा प्रमुख"));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "घर निमांण अनुमति/घरनक्शा पास", "तोकिएको ढाँचामा निेवदन, जग्गा धनी प्रमाण पुर्जा, नागरिकताको प्रमाणपत्रको प्रतिलिपि, चालु वर्षको मालपोत एकीकृत सम्पत्ती कर तिरेको रसिद, आवश्यकता अनुसार सर्जमिन मुचुल्का, सम्बन्धित जग्गाको प्रमाणित नक्शा, नक्शा सेट चार, घरनक्शा तयार गर्ने प्राविधिकको नगरपालिकामा दर्ता प्रमाणपत्र, जग्गा धनि पूर्जा, तला थप भएमा पुरानो नक्शा, चालु आ.व.को मालपोत तथा भुमिकर तिरेको रसिद, घर निर्माण गरिने जग्गाको कित्ता नम्बर प्रष्ट देखिने नापी शाखाको प्रमाणित नक्शा २ प्रति, सम्बन्धित व्यक्तिको नागरिकताको प्रमाणपत्र, बाटो खुलेको नक्शा वा प्रमाण, वारेस राख्ने भए वारेसनामा र वारेस हुनेको नागरिकता, गुठी जग्गा भएमा गुठीको सिफारिस ।","रु. १०   देखि रु.३८ सम्म (कच्ची र पक्की भवन ५०० वर्गफिटको)","बढीमा ३० दिन","महाशाखा प्रमुख"));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "भवन निर्माण अस्थायी इजाजत DPC", "घरधनीले भवनको डि.पि.सि. सम्मको निर्माण भएको जानकारी दिएपछि पुनः प्राविधिकबाट भवनको स्थलगत निरीक्षण गरी तोकिएको मापदण्ड अनुसार भएमा स्थायी इजाजत प्रदान गरिने, ","","१ घण्टा","महाशाखा प्रमुख"));

        mExampleList.add(new ExampleItem(R.drawable.nepal, "भवन निर्माण स्थायी इजाजत", "सम्मको निर्माण भएको जानकारी दिएपछि पुनः प्राविधिकबाट भवनको स्थलगत निरीक्षण गरी तोकिएको मापदण्ड अनुसार भएमा स्थायी इजाजत प्रदान गरिने,","","१ घण्टा","महाशाखा प्रमुख"));

        mExampleList.add(new ExampleItem(R.drawable.nepal, "भवन निर्माण सम्पन्न", "सम्बन्धीत घरधनीले भवन निर्माण भएको जानकारी गराई सम्पन्न प्रमाणका लागि पुनः प्राविधिकबाट स्थलगत निरीक्षण गरी भवन सम्पन्न भएको देखिएमा आवश्यक प्रक्रिया अगाडी बढाई घर नम्बरिङ उपशाखा र राजश्व शाखाबाट घर जग्गा कर तिर्नुपर्ने","Line3","२ घण्टा","महाशाखा प्रमुख"));

        mExampleList.add(new ExampleItem(R.drawable.nepal, "घरको तला थप", "घरनक्शा पास भएको नक्शा र इजाजतपत्रको प्रतिलिपि, नयाँ नक्शा पास गर्दा आवस्यक पर्ने सवै कागजातहरु, चालु आ.व. सम्मको एकीकृत सम्पत्ति कर तिरेको रसिद","","बढीमा ३० दिन ","महाशाखा प्रमुख"));

        mExampleList.add(new ExampleItem(R.drawable.nepal, "घरक्शा नामसारी ", "दुवै पक्षको संयुक्त निवेदन, दुवै पक्षको नेपाली नागरिकताको प्रमाण पत्रको प्रतिलिपि, विक्री सम्वन्धी लिखितको प्रतिलिपि, नक्शापास गरेको प्रमाणपत्रको प्रतिलिपि, सक्कल प्रमाण पनि देखाउनु पर्नेछ","क्षेत्रफल अनुसार","१० मिनेट","महाशाखा प्रमुख"));

        mExampleList.add(new ExampleItem(R.drawable.nepal, "अनलाईनबाट त्रुटि सच्चाउने", "कि.नं. क्षे.फ.वर्ग फिट,  कम्प्यूटर दर्ता नं. घर नक्शा नाम थर ठेगाना आदि सच्चायाउनु पर्ने कारण खुलाई सम्बन्धित व्यक्तिबाट निवेदन पेश गर्नुपर्नेछ ।","नलाग्ने","उपलब्ध गराएपछि","IT शाखा"));

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(House.this, DetailHouseMap.class);
                intent.putExtra("Example Item", mExampleList.get(position));

                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}

