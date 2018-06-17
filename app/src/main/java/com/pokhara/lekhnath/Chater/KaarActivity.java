package com.pokhara.lekhnath.Chater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.pokhara.lekhnath.R;

import java.util.ArrayList;

/**
 * Created by shiva on 5/16/2018.
 */

public class KaarActivity extends AppCompatActivity{

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panjikaran);
        setTitle(R.string.kaar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        createExampleList();
        buildRecyclerView();

    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();


        mExampleList.add(new ExampleItem(R.drawable.nepal, "एकीकृत सम्पत्ति कर / घर जग्गा कर ", "१)निवेदनपत्र \n" +
                "२) जग्गाधनी प्रमाण पुर्जाको प्रमाणित प्रतिलिपि\n" +
                "३) भवन/जग्गा खरिद गरेको भए मालपोतबाट रजिष्ट्रेसनपारित लिखित्को प्रतिलिपि \n" +
                "४)भवन  नक्शा  स्वीकृति प्रमाण पत्र र नक्शाको प्रतिलिपि \n" +
                "५) (स्थानीय तहको नाम) घोषणा हुनु पुर्व निर्माण भएको भवनका हकमा नापी नक्शा वा स्थलगत प्राबिधिक प्रतिवेदन \n" +
                "६) मालपोत तिरेको रसिद \n" +
                "७)आ.व. ०५७/०५८ पुर्व आन्तरिक राजश्व कार्यालयमा कर तिरेको भए सो को प्रमाणित प्रतिलिपि  \n" +
                "८) नागरिकता र नापी नक्शाको प्रमाणित प्रतिलिपि \n" ,"१) वडा अध्यक्ष/सदस्य/ सचिबले सम्बन्धित कर्मचारीलाई तोक आदेश गर्ने\n" +
                "२ ) तोकिएको कर्मचारीले कर निर्धारण  तयार गरि वडा अध्यक्ष/सदस्य/ सचिब समक्ष पेश  गर्ने\n" +
                "३) निवेदकले तोकिएको कर  बुझाउने \n" +
                "४) चलानी गरि निवेदकलाइ कर निर्धारण पत्र  उपलब्ध गराउने \n" ,"वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n","मुल्यांकन आधारमा"));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "वहाल कर ", "१)निवेदन पत्र \n" +
                "२) वहाल सम्झौताको प्रतिलिपि  \n" +
                "३) नेपाल सरकारमा बहाल संग सम्बन्धित निकायमा दर्ता गरेको प्रमाणपत्रको प्रतिलिपि \n" +
                "४) नागरिकताको प्रमाणपत्र प्रतिलिपि \n" +
                "५) चालु आ.व. सम्मको मालपोत र घर जग्गा  कर वा एकीकृत सम्पत्ति कर तिरेको रसिद\n","१) वडा अध्यक्ष/सदस्य/ सचिबले सम्बन्धित कर्मचारीलाई तोक आदेश गर्ने\n" +
                "२ ) तोकिएको कर्मचारीले कर निर्धारण  तयार गरि वडा अध्यक्ष/सदस्य/ सचिब समक्ष पेश  गर्ने\n" +
                "३) निवेदकले तोकिएको कर  बुझाउने \n" +
                "४) चलानी गरि निवेदकलाइ कर निर्धारण पत्र  उपलब्ध गराउने\n" ,"वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n","सम्झौता रकमको २%  \n"));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "विज्ञापन कर ", "१)\t१)निवेदन पत्र र संस्थाको प्रमाणित कागजात \n" +
                "२) सम्बन्धित स्थानीय तहमा तिर्न बुझाउन पर्ने व्यवसाय रअन्य करको प्रमाणित प्रतिलिपि  \n","१) वडा अध्यक्ष/सदस्य/ सचिबले सम्बन्धित कर्मचारीलाई तोक आदेश गर्ने\n" +
                "२ ) तोकिएको कर्मचारीले कर निर्धारण  तयार गरि वडा अध्यक्ष/सदस्य/ सचिब समक्ष पेश  गर्ने\n" +
                "३) निवेदकले तोकिएको कर  बुझाउने \n" +
                "४) चलानी गरि निवेदकलाइ कर निर्धारण पत्र  उपलब्ध गराउने\n","वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n","प्रति बर्गफुट रु. १०० डिपि.एस बोर्ड\n" +
                "प्रति बर्गफुट रु. ७५ भित्ते लेखन \n" +
                "प्रति बर्गफुट  रु. २५ तुल व्यानर \n" +
                "प्रति एक हप्ताको ३०० लाईट डिजिटल बोर्ड LED "));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "मालपोत / भुमि कर " , "१)निवेदन पत्र \n" +
                "२)प्रथम बर्षका लागि जग्गा धनि प्रमाण पुर्जा, नविकरणका लागि अघिल्लो आ. वा. मा मालपोत तिरेको रसिद वा यस कार्यालयबाट जारि गरिएको मालपोत नाविज्करण बुक \n" +
                "३)घर जग्गा वा एकीकृत सम्पत्ति कर तिरेको प्रमाण  \n","१) निवेदन सहितको तोकिएको कागजातहरु पेश गर्ने\n" +
                "२) वडा अध्यक्ष/सदस्य/सचिबले सम्बन्धित कर्मचारीलाई तोक आदेश गर्ने\n" +
                "३) निबेदन दर्ता गर्ने\n" +
                "४) ) तोकिएको कर्मचारीले आवश्यकता अनुसार सर्जमिन मुचुल्का  तयार गरि सिफारिस तयार गर्ने\n" +
                "५) निवेदकले तोकिएको शुल्क बुझाउने \n" +
                "६) चलानी गरि निवेदकलाइ सिफारिस उपलब्ध गराउने\n" ,"वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n","मुल्यांकन पछी जारि गरिएको बिजक बमोजिम  "));

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
                Intent intent = new Intent(KaarActivity.this, DetailsChater.class);
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
