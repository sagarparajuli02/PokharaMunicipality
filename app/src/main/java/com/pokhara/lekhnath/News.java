package com.pokhara.lekhnath;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class News extends AppCompatActivity {
    SQLiteHelperNews sqLiteHelperNews;
    SQLiteDatabase sqLiteDatabase2;
    Cursor cursor;
    ListAdapterSqliteNews listAdapterSqliteNews;
    ListView LISTVIEW;
    ArrayList<String> ID_Array;
    ArrayList<String> Subject_NAME_Array;
    ArrayList<String> Subject_FullForm_Array;
    ArrayList<String> EmployeeImage;
    ArrayList<String> Subject_Link;
    ArrayList<String> ListViewClickItemArray = new ArrayList<String>();


    SQLiteDatabase sqLiteDatabase;

    Button SaveButtonInSQLite, ShowSQLiteDataInListView;

    String HttpJSonURL = "http://municipality1.000webhostapp.com/sagar/news.php";

    ProgressDialog progressDialog;
    boolean internet_connection(){
        //Check if connected to internet, output accordingly
        ConnectivityManager cm =
                (ConnectivityManager)News.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(R.string.news);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton SaveButtonInSQLite = (FloatingActionButton) findViewById (R.id.button);
        //  SaveButtonInSQLite = (Button)findViewById(R.id.button);

        // ShowSQLiteDataInListView = (Button)findViewById(R.id.button2);

        SaveButtonInSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!internet_connection()){
                    Toast.makeText(News.this, "no connection", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDataBaseBuild();

                    SQLiteTableBuild();

                    DeletePreviousData();

                    new StoreJSonDataInToSQLiteClass(News.this).execute();
                 //   overridePendingTransition(0,0);
                    startActivity(getIntent());
                   // overridePendingTransition(0,0);

                }


            }
        });

        LISTVIEW = (ListView) findViewById(R.id.listView2);

        ID_Array = new ArrayList<String>();

        Subject_NAME_Array = new ArrayList<String>();

        Subject_FullForm_Array = new ArrayList<String>();
        EmployeeImage = new ArrayList<String>();

        Subject_Link = new ArrayList<String>();
        sqLiteHelperNews = new SQLiteHelperNews(this);


    }


    private class StoreJSonDataInToSQLiteClass extends AsyncTask<Void, Void, Void> {

        public Context context;

        String FinalJSonResult;

        public StoreJSonDataInToSQLiteClass(Context context) {

            this.context = context;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            progressDialog = new ProgressDialog(News.this);
            progressDialog.setTitle("LOADING");
            progressDialog.setMessage("Please Wait");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpServiceClassNews httpServiceClassNews = new HttpServiceClassNews(HttpJSonURL);

            try {
                httpServiceClassNews.ExecutePostRequest();

                if (httpServiceClassNews.getResponseCode() == 200) {

                    FinalJSonResult = httpServiceClassNews.getResponse();

                    if (FinalJSonResult != null) {

                        JSONArray jsonArray = null;
                        try {

                            jsonArray = new JSONArray(FinalJSonResult);
                            JSONObject jsonObject;

                            for (int i = 0; i < jsonArray.length(); i++) {

                                jsonObject = jsonArray.getJSONObject(i);

                                String tempSubjectName = jsonObject.getString("name");

                                String tempSubjectFullForm = jsonObject.getString("position");
                                String tempImages = jsonObject.getString("photo");
                                String tempLink = jsonObject.getString("link");

                                String SQLiteDataBaseQueryHolder = "INSERT INTO "+ SQLiteHelperNews.TABLE_NAME+" (subjectName,subjectFullForm,imageEmployees,subjectLink) VALUES('"+tempSubjectName+"', '"+tempSubjectFullForm+"', '"+tempImages+"','"+tempLink+"');";

                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {

                    Toast.makeText(context, httpServiceClassNews.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            sqLiteDatabase.close();

        //    progressDialog.dismiss();
            if ((progressDialog != null) && progressDialog.isShowing())
            {
                progressDialog.dismiss();
            }

            Toast.makeText(News.this,"Load Done", Toast.LENGTH_LONG).show();

        }
    }


    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = openOrCreateDatabase(SQLiteHelperNews.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+ SQLiteHelperNews.TABLE_NAME+"("+ SQLiteHelperNews.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+ SQLiteHelperNews.Table_Column_1_Subject_Name+" VARCHAR, "+ SQLiteHelperNews.Table_Column_2_SubjectFullForm+" VARCHAR, "+ SQLiteHelperNews.Table_Column_3_SubjectFullForm+" VARCHAR, "+ SQLiteHelperNews.Table_Column_4_SubjectFullForm+" VARCHAR);");

    }

    public void DeletePreviousData(){

        sqLiteDatabase.execSQL("DELETE FROM "+ SQLiteHelperNews.TABLE_NAME+"");

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        sqLiteDatabase2= sqLiteHelperNews.getWritableDatabase();

        cursor = sqLiteDatabase2.rawQuery("SELECT * FROM "+ SQLiteHelperNews.TABLE_NAME+"", null);

        ID_Array.clear();
        Subject_NAME_Array.clear();
        Subject_FullForm_Array.clear();
        EmployeeImage.clear();
        Subject_Link.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperNews.Table_Column_ID)));

                //Inserting Column Name into Array to Use at ListView Click Listener Method.
                ListViewClickItemArray.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperNews.Table_Column_1_Subject_Name)));

                Subject_NAME_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperNews.Table_Column_1_Subject_Name)));

                Subject_FullForm_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperNews.Table_Column_2_SubjectFullForm)));

                EmployeeImage.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperNews.Table_Column_3_SubjectFullForm)));
                Subject_Link.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperNews.Table_Column_3_SubjectFullForm)));


            } while (cursor.moveToNext());
        }

        listAdapterSqliteNews = new ListAdapterSqliteNews(News.this,

                ID_Array,
                Subject_NAME_Array,
                Subject_FullForm_Array, EmployeeImage,Subject_Link);

        LISTVIEW.setAdapter(listAdapterSqliteNews);

        cursor.close();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}