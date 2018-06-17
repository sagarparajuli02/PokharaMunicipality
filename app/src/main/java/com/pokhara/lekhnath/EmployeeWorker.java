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

public class EmployeeWorker extends AppCompatActivity {

    SQLiteHelperEmployee sqLiteHelperEmployee;
    SQLiteDatabase sqLiteDatabase2;
    Cursor cursor;
    ListAdapterSqliteEmployee listAdapterSqliteEmployee;
    ListView LISTVIEW;
    ArrayList<String> ID_Array;
    ArrayList<String> Subject_NAME_Array;
    ArrayList<String> Subject_FullForm_Array;
    ArrayList<String> EmployeeImage;
    ArrayList<String> Subject_Email;
    ArrayList<String> Subject_Number;
    ArrayList<String> ListViewClickItemArray = new ArrayList<String>();

    SQLiteDatabase sqLiteDatabase;

    String HttpJSonURL = "http://municipality1.000webhostapp.com/sagar/staff.php";

    ProgressDialog progressDialog;
    boolean internet_connection(){
        //Check if connected to internet, output accordingly
        ConnectivityManager cm =
                (ConnectivityManager)EmployeeWorker.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

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
                    Toast.makeText(EmployeeWorker.this, "no connection", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDataBaseBuild();

                    SQLiteTableBuild();

                    DeletePreviousData();


                    new StoreJSonDataInToSQLiteClass(EmployeeWorker.this).execute();
                    startActivity(getIntent());
                }


            }
        });

        LISTVIEW = (ListView) findViewById(R.id.listView2);

        ID_Array = new ArrayList<String>();

        Subject_NAME_Array = new ArrayList<String>();

        Subject_FullForm_Array = new ArrayList<String>();
        EmployeeImage = new ArrayList<String>();
        Subject_Email = new ArrayList<String>();
        Subject_Number = new ArrayList<String>();

        sqLiteHelperEmployee = new SQLiteHelperEmployee(this);


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

            progressDialog = new ProgressDialog(EmployeeWorker.this);
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

                                String tempEmail = jsonObject.getString("email");
                                String tempNumber = jsonObject.getString("number");

                                String SQLiteDataBaseQueryHolder = "INSERT INTO "+ SQLiteHelperEmployee.TABLE_STAFF+" (subjectName,subjectFullForm,imageEmployees,subjectEmail,subjectNumber) VALUES('"+tempSubjectName+"', '"+tempSubjectFullForm+"', '"+tempImages+"', '"+tempEmail+"', '"+tempNumber+"');";


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

            Toast.makeText(EmployeeWorker.this,"Load Done", Toast.LENGTH_LONG).show();

        }
    }


    public void SQLiteDataBaseBuild(){

        sqLiteDatabase = openOrCreateDatabase(SQLiteHelperEmployee.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+ SQLiteHelperEmployee.TABLE_STAFF+"("+ SQLiteHelperEmployee.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+ SQLiteHelperEmployee.Table_Column_1_Subject_Name+" VARCHAR, "+ SQLiteHelperEmployee.Table_Column_2_SubjectFullForm+" VARCHAR, "+ SQLiteHelperEmployee.Table_Column_3_SubjectFullForm+" VARCHAR, "+ SQLiteHelperEmployee.Table_Column_4_SubjectFullForm+", "+ SQLiteHelperEmployee.Table_Column_5_SubjectFullForm+");");

    }

    public void DeletePreviousData(){

        sqLiteDatabase.execSQL("DELETE FROM "+ SQLiteHelperEmployee.TABLE_STAFF+"");

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        sqLiteDatabase2= sqLiteHelperEmployee.getWritableDatabase();

        cursor = sqLiteDatabase2.rawQuery("SELECT * FROM "+ SQLiteHelperEmployee.TABLE_STAFF+"", null);

        ID_Array.clear();
        Subject_NAME_Array.clear();
        Subject_FullForm_Array.clear();
        Subject_Email.clear();
        Subject_Number.clear();
        EmployeeImage.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperEmployee.Table_Column_ID)));

                //Inserting Column Name into Array to Use at ListView Click Listener Method.
                ListViewClickItemArray.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperEmployee.Table_Column_1_Subject_Name)));

                Subject_NAME_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperEmployee.Table_Column_1_Subject_Name)));

                Subject_FullForm_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperEmployee.Table_Column_2_SubjectFullForm)));

                EmployeeImage.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperEmployee.Table_Column_3_SubjectFullForm)));

                Subject_Email.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperEmployee.Table_Column_4_SubjectFullForm)));

                Subject_Number.add(cursor.getString(cursor.getColumnIndex(SQLiteHelperEmployee.Table_Column_5_SubjectFullForm)));



            } while (cursor.moveToNext());
        }

        listAdapterSqliteEmployee = new ListAdapterSqliteEmployee(EmployeeWorker.this,

                ID_Array,
                Subject_NAME_Array,
                Subject_FullForm_Array, EmployeeImage,Subject_Email,Subject_Number);

        LISTVIEW.setAdapter(listAdapterSqliteEmployee);

        cursor.close();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}