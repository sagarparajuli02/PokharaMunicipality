package com.pokhara.lekhnath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class TaxDetails extends AppCompatActivity  {

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_details);

        createExampleList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem( "घर जग्गा नामसारी सिफारिस ", " 210"));
        mExampleList.add(new ExampleItem( "मोही लागत कट्टा सिफारिस ", "2300"));
        mExampleList.add(new ExampleItem( "घर कायम सिफारिस ", "2121"));
        mExampleList.add(new ExampleItem( "घर कायम सिफारिस पाउ: भन्ने सम्बन्धि निवेदन", "433"));
        mExampleList.add(new ExampleItem( "निवेदन सहितको तोकिएको ", "112"));
        mExampleList.add(new ExampleItem("एकीकृत सम्पत्ति कर तिरेको रसिद", "222"));
        mExampleList.add(new ExampleItem("जग्गाधनी प्रमाण पुर्जाको प्रमाणित प्रतिलिपि ", "Line 2"));
        mExampleList.add(new ExampleItem( "कर्मचारीलाई तोक आदेश गर्ने", "Line 2"));
        mExampleList.add(new ExampleItem( "नागरिकता प्रमाणपत्रको प्रतिलिपि ", "Line 2"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}