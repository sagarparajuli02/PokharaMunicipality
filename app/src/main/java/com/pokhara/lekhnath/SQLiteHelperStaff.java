package com.pokhara.lekhnath;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelperStaff extends SQLiteOpenHelper {

    static String DATABASE_NAME="StaffDatabase";

   // public static final String TABLE_NAME="SubjectTable";

    public static final String TABLE_STAFF="StaffTable";
    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_Subject_Name="subjectName";

    public static final String Table_Column_2_SubjectFullForm="subjectFullForm";
    public static final String Table_Column_3_SubjectFullForm="imageEmployees";

    public SQLiteHelperStaff(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_STAFF+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_Subject_Name+" VARCHAR, "+Table_Column_2_SubjectFullForm+" VARCHAR , "+Table_Column_3_SubjectFullForm+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STAFF);
        onCreate(db);

    }

}