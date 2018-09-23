package com.vpb.www.bmicalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + "calorienbmi" + " (" +
                    "id" + " INTEGER PRIMARY KEY," +
                     "bmi" + " TEXT," +
                    "calorieburn" + " TEXT," + "time" + " DATE DEFAULT (datetime('now','localtime')))";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + "calorienbmi";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "History.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);

    }


    public long insert(String bmi,String calorie) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put("bmi", bmi);
        values.put("calorieburn", calorie);

        // insert row
        long id = db.insert("calorienbmi", null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }


    public List<List<String>> getAllNotes() {
        List<List<String>> rlist = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  "+result.COLUMN_BMI+","+result.COLUMN_CALORIEBURN+","+result.COLUMN_TIME+" FROM " + "calorienbmi" + " ORDER BY " +
                result.COLUMN_TIME + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int dcount=cursor.getColumnCount();

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                List<String> str=new ArrayList<>();

                for(int i=0;i<dcount;i++)
                {
                    str.add(cursor.getString(i));
                }

                rlist.add(str);

                //   notes.add(cursor.getString(0));
                // notes.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();

        // return notes list
        return rlist;
    }
}
