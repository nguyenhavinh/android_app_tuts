package com.example.vinhnguyen.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vinh Nguyen on 4/13/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "citywesttkd.db";
    //TABLE EXAMINER
    public static final String TABLE_EXAMINER_NAME = "Examiner";
    public static final String EXAMINER_TABLE_COL_1 = "ID";
    public static final String EXAMINER_TABLE_COL_2 = "NAME";
    public static final String EXAMINER_TABLE_COL_3 = "PASSWORD";
    //TABLE STUDENT
    public static final String TABLE_STUDENT_NAME = "Student";

    //TABLE EXAMINER_STUDENT
    public static final String TABLE_EXAMINER_STUDENT_NAME = "Examiner_student";
    public static final String EXAMINER_STUDENT_TABLE_COL_1 = "ID";
    public static final String EXAMINER_STUDENT_TABLE_COL_2 = "EXAMINER_ID";
    public static final String EXAMINER_STUDENT_TABLE_COL_3 = "STUDENT_ID";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_EXAMINER_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists: " + TABLE_EXAMINER_NAME);
        onCreate(db);
    }
    public boolean insertExaminer(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXAMINER_TABLE_COL_2, name);
        contentValues.put(EXAMINER_TABLE_COL_3, password);
        long result = db.insert(TABLE_EXAMINER_NAME, null, contentValues);
        if (result == -1){
            return false;
        }
        else return true;
    }
    public Cursor loginExaminer(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_EXAMINER_NAME + " where NAME = ? AND PASSWORD = ?", new String[] {name, password} );
        return res;
    }
}
