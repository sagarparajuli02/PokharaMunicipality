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
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StaffWorker extends AppCompatActivity {
    SQLiteHelperStaff sqLiteHelperStaff;
    SQLiteDatabase sqLiteDatabase2;
    Cursor cursor;
    ListAdapterSqlite listAdapterSqlite;
    ListView LISTVIEW;
    ArrayList<String> ID_Array;
    ArrayList<String> Subject_NAME_Array;
    ArrayList<String> Subject_FullForm_Array;
    ArrayList<String> EmployeeImage;
    ArrayList<String> ListViewClickItemArray = new ArrayList<String>();




    SQLiteDatabase sqLiteDatabase;


    String HttpJSonURL = "http://municipality1.000webhostapp.com/sagar/SubjectFullForm.php";

    ProgressDialog progressDialog;
    boolean internet_connection(){
        //Check if connected to internet, output accordingly
        ConnectivityManager cm =
                (ConnectivityManager)StaffWorker.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_worker);
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
                    Toast.makeText(StaffWorker.this, "no connection", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDataBaseBuild();

                    SQLiteTableBuild();

                    DeletePreviousData();

                    new StoreJSonDataInToSQLiteClass(StaffWorker.this).execute();

                    startActivity(getIntent());

                }


            }
        });

        LISTVIEW = (ListView) findViewById(R.id.listView2);

        ID_Array = new ArrayList<String>();

        Subject_NAME_Array = new ArrayList<String>();

        Subject_FullForm_Array = new ArrayList<String>();
        EmployeeImage = new ArrayList<String>();

        sqLiteHelperStaff = new SQLiteHelperStaff(this);

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

            progressDialog = new ProgressDialog(StaffWorker.this);
            progressDialog.setTitle("LOADING");
            progressDialog.setMessage("Please Wait");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpServiceClass httpServiceClass = new HttpServiceClass(HttpJSonURL);

            try {
                httpServiceClass.ExecutePostRequest();

                if (httpServiceClass.getResponseCode() == 200) {

                    FinalJSonResult = httpServiceClass.getResponse();

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

                                String SQLiteDataBaseQueryHolder = "INSERT INTO "+ SQLiteHelperStaff.TABLE_STAFF+" (subjectName,subjectFullForm,imageEmployees) VALUES('"+tempSubjectName+"', '"+tempSubjectFullForm+"', '"+tempImages+"');";

                                sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);

                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {

                    Toast.makeText(context, httpServiceClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
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

            progressDialog.dismiss();
            progressDialog=null;

            Toast.makeText(StaffWorker.this,"Load Done", Toast.LENGTH_LONG).show();

        }
    }


    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = openOrCreateDatabase(SQLiteHelperStaff.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+ SQLiteHelperStaff.TABLE_STAFF+"("+ SQLiteHelperStaff.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+ SQLiteHelperStaff.Table_Column_1_Subject_Name+" VARCHAR, "+ SQLiteHelperStaff.Table_Column_2_SubjectFullForm+" VARCHAR, "+ SQLiteHelperStaff.Table_Column_3_SubjectFullForm+" VARCHAR);");

    }

    public void DeletePreviousData(){

        sqLiteDatabase.execSQL("DELETE FROM "+ SQLiteHelperStaff.TABLE_STAFF+"");

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        sqLiteDatabase2= sqLiteHelperStaff.getWritableDatabase();

        cursor = sqLiteDatabase2.rawQuery("SELECT * FROM "+ SQLiteHelperStaff.TABLE_STAFF+"", null);

        ID_Array.clear();
        Subject_NAME_Array.clear();
        Subject_FullForm_Array.clear();
        EmployeeImage.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperStaff.Table_Column_ID)));

                //Inserting Column Name into Array to Use at ListView Click Listener Method.
                ListViewClickItemArray.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperStaff.Table_Column_1_Subject_Name)));

                Subject_NAME_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperStaff.Table_Column_1_Subject_Name)));

                Subject_FullForm_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperStaff.Table_Column_2_SubjectFullForm)));

                EmployeeImage.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperStaff.Table_Column_3_SubjectFullForm)));


            } while (cursor.moveToNext());
        }

        listAdapterSqlite = new ListAdapterSqlite(StaffWorker.this,

                ID_Array,
                Subject_NAME_Array,
                Subject_FullForm_Array, EmployeeImage);

        LISTVIEW.setAdapter(listAdapterSqlite);

        cursor.close();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}