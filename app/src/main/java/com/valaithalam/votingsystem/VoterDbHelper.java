package com.valaithalam.votingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VoterDbHelper extends SQLiteOpenHelper {

    public static final String VDATABASE_NAME = "Voter.db";
    public static final String VTABLE_NAME = "voter";


    public static final String VCOL_2 = "VNAME";
    public static final String VCOL_3 = "VEMAIL";
    public static final String VCOL_4 = "VDEPARTMENT";

    public VoterDbHelper( Context context) {
        super(context, VDATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ VTABLE_NAME +" (VNAME TEXT,VEMAIL TEXT,VDEPARTMENT TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+VTABLE_NAME);
        onCreate(db);

    }

    public boolean VinsertData(String vname,String vemail,String vdept) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VCOL_2,vname);
        contentValues.put(VCOL_3,vemail);
        contentValues.put(VCOL_4,vdept);

        long result = db.insert(VTABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
