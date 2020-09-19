package com.valaithalam.votingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VotingFinal extends SQLiteOpenHelper {

    public static final String SDATABASE_NAME = "Final.db";
    public static final String STABLE_NAME = "newresult";

    public static final String COL_1 = "EMAIL";
    public static final String COL_2 = "ID";


    public VotingFinal(Context context) {
        super(context, SDATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ STABLE_NAME +" (EMAIL TEXT, ID TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+STABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String email,String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,email);
        contentValues.put(COL_2,id);

        long result = db.insert(STABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+STABLE_NAME,null);
        return res;
    }

}
