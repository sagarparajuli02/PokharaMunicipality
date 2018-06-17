package com.pokhara.lekhnath.Chater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;


import com.pokhara.lekhnath.R;

import java.util.ArrayList;

public class PanjikaranActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panjikaran);
        setTitle(R.string.panjikaran);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        createExampleList();
        buildRecyclerView();

    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();


        mExampleList.add(new ExampleItem(R.drawable.nepal, "आन्तरिक बसाइ सराइ सिफारिस", "१)निवेदन पत्र र नागरिकता प्रमाणपत्रको प्रतिलिपि\n" +
                "२) सरि जाने व्यक्तिहरुको नागरिकता प्रमाणपत्रको प्रतिलिपि नभएको हकमा विवाह दर्ता वा जन्म दर्ता वा उमेर खुलेको निस्सको प्रमाणित प्रतिलिपि   \n" +
                "३) जग्गाधनी प्रमाण पुर्जाको प्रमाणित प्रतिलिपि व्यवसाय वा घर वा जग्गा नभएकाको हकमा बसाइ खुल्ने प्रमाण कागजात\n" +
                "४) घर जग्गा भएकोको हकमा चालु आ.व. सम्मको मालपोत र घर जग्गा  कर वा एकीकृत सम्पत्ति कर तिरेको रसिद वा कर निर्धारण स्वीकृत भएको कागजात\n" +
                "५) घर  जग्गा नभएकाको हकमा म्बन्धित घर धनि संग गरेको घर बहालको सम्झौता \n","१) निवेदन सहितको तोकिएको कागजातहरु पेश गर्ने\n" +
                "२) वडा अध्यक्ष/सदस्य/सचिबले सम्बन्धित कर्मचारीलाई तोक आदेश गर्ने\n" +
                "३) निबेदन दर्ता गर्ने\n" +
                "४) ) तोकिएको कर्मचारीले आवश्यकता अनुसार सर्जमिन मुचुल्का  तयार गरि सिफारिस तयार गर्ने\n" +
                "५) निवेदकले तोकिएको शुल्क बुझाउने \n" +
                "६) चलानी गरि निवेदकलाइ सिफारिस उपलब्ध गराउने\n" ,"वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n","रु. ५०"));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "जन्म दर्ता ", "१)निवेदन पत्र \n" +
                "२) बालकको बाबु आमाको नागरिकता \n" +
                "३)चालु आ. व. सम्मको मालपोत र घर जग्गा कर वा एकीकृत सम्पत्ति कर तिरेको रसिद \n" +
                "४) अस्पतालमा जन्म भएको हकमा सम्बन्धित अस्पतालले जन्म प्रमाणित गरेको परिचयपत्रको प्रमाणित प्रतिलिपि  \n","१) घटना घटेको ३५ दिन भित्र परिवारको मुख्य परिवारको मुख्य व्यक्तिले \n" +
                "२) निजको अनुपस्थितिमा उमेर पुगेको पुरुष मध्य जेठो व्यक्तिले सुचना दिने\n"," वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n","३५ दिन भित्र निशुल्क \n" +
                "त्यसपछी रु. ५० सम्म "));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "मृत्यु दर्ता ", "१)निवेदन दर्ता \n" +
                "२) मृतकको नागरिकता र सुचना दिन आउनेको नागरिकता \n" +
                "३) मृतक संग सम्बन्ध जोडिने प्रमाण पत्र \n" +
                "४) अविवाहित मृतकको हकमा स्थानीय सर्जमिन मुचुल्का \n" +
                "५) मृतकको नागरिकता नभएको हकमा स्थानीय सर्जमिन पत्र \n" +
                "६) सुचना दिने व्यक्तिको नागरिकता नभएमा समेत स्थानीय सर्जमिन मुचुल्का  \n","१) घटेको ३५ दिन भित्र परिवारको मुख्य व्यक्तिले \n" +
                "२) निजको अनुपस्थितिमा उमेर पुगेको पुरुष मध्य जेठो व्यक्तिले सुचना दिने \n" +
                "३) वडा अध्यक्ष/सदस्य/ सचिबले सम्बन्धित कर्मचारीद्वारा सर्जमिन मुचुल्का तयार पार्ने \n","वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n","३५ दिन भित्र निशुल्क \n" +
                "त्यसपछी रु. ५० "));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "बसाइ सराइ  जाने आउने दर्ता ", "१)निवेदन पत्र र नागरिकताको प्रांपत्रको प्रतिलिपि  \n" +
                "२) बसाइ सराइ गरि जाने हरुको हकमा परिवारको विवरण सहितको वडा कार्यालय बसाइसराइको कागजात \n" +
                "३) जहा जाने हो त्यस ठाउको लालपूर्जा र जुन ठाउमा आउनेको पनि पेश गर्नुपर्ने \n" +
                "४) बसाइ सराइ गरि आउनेको हकमा बसाइ सराइ गरि ल्याएको प्रमाणपत्र \n" +
                "५) आउने जाने सबै व्यक्तिको नागरिकता/ जन्मदर्ताको प्रतिलिपि \n" +
                "६) चालु आ.व. सम्मको मालपोत र घर जग्गा  कर वा एकीकृत सम्पत्ति कर तिरेको रसिद\n","१) घटेको ३५ दिन भित्र सपरिवारको बसाइ सराइ भएको भए परिवारको मुख्य व्यक्तिले सुचना दिने \n" +
                "२) एकजनाको मात्र बसाइ सराइ भएको भए निजले सुचना दिने \n"," वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n", "३५ दिन भित्र निशुल्क \n" +
                "त्यसपछी रु. ५० "));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "सम्बन्धबिच्छेद दर्ता ", "१)निवेदन पत्र \n" +
                "२) अदालतबाट सम्बन्ध बिच्छेद भएको फैसालाको प्रमाणित प्रतिलिपि \n" +
                "३) पतिपत्नीको नागरिकताको प्रतिलिपि १/१ प्रति \n" +
                "४) केटाको स्थायी ठेगाना सम्बन्धित वडामा हुनुपर्ने \n","१) सम्बन्ध बिच्छेद भएको पति वा पत्नीले सुचना फारम भरि सुचना दिने \n"," वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n", "३५ दिन भित्र निशुल्क \n" +
                "त्यसपछी रु. ५०"));
        mExampleList.add(new ExampleItem(R.drawable.nepal, "विवाह दर्ता ", "१)निवेदन पत्र \n" +
                "२) दुलाहा दुलाहिको नागरिकताको प्रमाणपत्रको प्रतिलिपि \n" +
                "३) दुलहीको नागरिकता नभएमा बाबु वा दाजु भाइको नागरिकता प्रमाणपत्रको प्रतिलिपि \n" +
                "४) चालु आ.व. सम्मको मालपोत र घर जग्गा  कर वा एकीकृत सम्पत्ति कर तिरेको रसिद \n","१) दुलाहा दुलही दुवै उपस्थित भइ सुचना दिने \n","वडा अध्यक्ष/ सदस्य/ सचिबले सम्बन्धित फाटका कार्मचारी \n" +
                "लाग्ने समय : सोहि दिन \n" +
                "सर्जमिनको हकमा बढीमा ३ दिन  \n", "३५ दिन भित्र निशुल्क \n" +
                "त्यसपछी रु. ५०"));

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
                Intent intent = new Intent(PanjikaranActivity.this, DetailsChater.class);
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
