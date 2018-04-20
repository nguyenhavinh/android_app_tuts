package com.example.vinhnguyen.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;
import java.util.Vector;

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
    public static final String STUDENT_TABLE_COL_1 = "ID";
    public static final String STUDENT_TABLE_COL_2 = "NAME";
    public static final String STUDENT_TABLE_COL_3 = "BRANCH";
    public static final String STUDENT_TABLE_COL_4 = "RANK";
    public static final String STUDENT_TABLE_COL_5 = "PHONE";
    public static final String STUDENT_TABLE_COL_6 = "GRADING_DATE";
    public static final String STUDENT_TABLE_COL_7 = "GENDER";
    public static final String STUDENT_TABLE_COL_8 = "DOB";
    public static final String STUDENT_TABLE_COL_9 = "AGE";
    public static final String STUDENT_TABLE_COL_10 = "WEIGHT";
    public static final String STUDENT_TABLE_COL_11 = "HEIGHT";
    public static final String STUDENT_TABLE_COL_12 = "MOBILE";
    public static final String STUDENT_TABLE_COL_13 = "STARTING_TIME";
    public static final String STUDENT_TABLE_COL_14 = "MANNER";
    public static final String STUDENT_TABLE_COL_15 = "STANCES";
    public static final String STUDENT_TABLE_COL_16 = "SHORT_STANCE";
    public static final String STUDENT_TABLE_COL_17 = "PREVIOUS_STRIKES";
    public static final String STUDENT_TABLE_COL_18 = "STRIKES";
    public static final String STUDENT_TABLE_COL_19 = "BOXING";
    public static final String STUDENT_TABLE_COL_20 = "PREVIOUS_BLOCK";
    public static final String STUDENT_TABLE_COL_21 = "BLOCK";
    public static final String STUDENT_TABLE_COL_22 = "AXE_KICK";
    public static final String STUDENT_TABLE_COL_23 = "FRONT_KICK";
    public static final String STUDENT_TABLE_COL_24 = "SIDE_KICK";
    public static final String STUDENT_TABLE_COL_25 = "ROUND_KICK";
    public static final String STUDENT_TABLE_COL_26 = "BASIC_FORM";
    public static final String STUDENT_TABLE_COL_27 = "COUNT_TAEGUK";
    public static final String STUDENT_TABLE_COL_28 = "FREE_TAEGUK";
    public static final String STUDENT_TABLE_COL_29 = "STEP_SPARRING";
    public static final String STUDENT_TABLE_COL_30 = "SPARRING";
    public static final String STUDENT_TABLE_COL_31 = "YELL";
    public static final String STUDENT_TABLE_COL_32= "TOTAL";
    public static final String STUDENT_TABLE_COL_33= "EXAMINER_ID";


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
        db.execSQL("create table " + TABLE_EXAMINER_STUDENT_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, EXAMINER_ID INTEGER, STUDENT_ID INTEGER)");
        db.execSQL("create table " + TABLE_STUDENT_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, BRANCH TEXT, RANK TEXT, PHONE TEXT, GRADING_DATE TEXT, GENDER TEXT, DOB TEXT, AGE TEXT, WEIGHT TEXT, HEIGHT TEXT, MOBILE TEXT, STARTING_TIME TEXT, " +
                "MANNER INTEGER, STANCES INTEGER, SHORT_STANCE INTEGER, PREVIOUS_STRIKES INTEGER, STRIKES INTEGER, BOXING INTEGER, PREVIOUS_BLOCK INTEGER, BLOCK INTEGER, AXE_KICK INTEGER, FRONT_KICK INTEGER, SIDE_KICK INTEGER, ROUND_KICK INTEGER, " +
                "BASIC_FORM INTEGER, COUNT_TAEGUK INTEGER, FREE_TAEGUK INTEGER, STEP_SPARRING INTEGER, SPARRING INTEGER, YELL INTEGER, TOTAL DOUBLE, EXAMINER_ID INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists: " + TABLE_EXAMINER_NAME);
        db.execSQL("Drop table if exists: " + TABLE_EXAMINER_STUDENT_NAME);
        db.execSQL("Drop table if exists: " + TABLE_STUDENT_NAME);
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
    public boolean insertStudent(String dt2, String dt3, String dt4, String dt5, String dt6, String dt7, String dt8, String dt9, String dt10, String dt11, String dt12, String dt13,
                                 String dt14, String dt15, String dt16, String dt17, String dt18, String dt19, String dt20, String dt21, String dt22, String dt23, String dt24,
                                 String dt25, String dt26, String dt27, String dt28, String dt29, String dt30, String dt31, String dt33){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_TABLE_COL_2, dt2);
        contentValues.put(STUDENT_TABLE_COL_3, dt3);
        contentValues.put(STUDENT_TABLE_COL_4, dt4);
        contentValues.put(STUDENT_TABLE_COL_5, dt5);
        contentValues.put(STUDENT_TABLE_COL_6, dt6);
        contentValues.put(STUDENT_TABLE_COL_7, dt7);
        contentValues.put(STUDENT_TABLE_COL_8, dt8);
        contentValues.put(STUDENT_TABLE_COL_9, dt9);
        contentValues.put(STUDENT_TABLE_COL_10, dt10);
        contentValues.put(STUDENT_TABLE_COL_11, dt11);
        contentValues.put(STUDENT_TABLE_COL_12, dt12);
        contentValues.put(STUDENT_TABLE_COL_13, dt13);
        contentValues.put(STUDENT_TABLE_COL_14, dt14);
        contentValues.put(STUDENT_TABLE_COL_15, dt15);
        contentValues.put(STUDENT_TABLE_COL_16, dt16);
        contentValues.put(STUDENT_TABLE_COL_17, dt17);
        contentValues.put(STUDENT_TABLE_COL_18, dt18);
        contentValues.put(STUDENT_TABLE_COL_19, dt19);
        contentValues.put(STUDENT_TABLE_COL_20, dt20);
        contentValues.put(STUDENT_TABLE_COL_21, dt21);
        contentValues.put(STUDENT_TABLE_COL_22, dt22);
        contentValues.put(STUDENT_TABLE_COL_23, dt23);
        contentValues.put(STUDENT_TABLE_COL_24, dt24);
        contentValues.put(STUDENT_TABLE_COL_25, dt25);
        contentValues.put(STUDENT_TABLE_COL_26, dt26);
        contentValues.put(STUDENT_TABLE_COL_27, dt27);
        contentValues.put(STUDENT_TABLE_COL_28, dt28);
        contentValues.put(STUDENT_TABLE_COL_29, dt29);
        contentValues.put(STUDENT_TABLE_COL_30, dt30);
        contentValues.put(STUDENT_TABLE_COL_31, dt31);
        contentValues.put(STUDENT_TABLE_COL_33, dt33);
        int sum = Integer.parseInt(dt14) + Integer.parseInt(dt15) + Integer.parseInt(dt16) + Integer.parseInt(dt17) + Integer.parseInt(dt18) + Integer.parseInt(dt19) +
                Integer.parseInt(dt20) + Integer.parseInt(dt21) + Integer.parseInt(dt22) + Integer.parseInt(dt23) + Integer.parseInt(dt24) + Integer.parseInt(dt25) +
                Integer.parseInt(dt26) + Integer.parseInt(dt27) + Integer.parseInt(dt28) + Integer.parseInt(dt29) + Integer.parseInt(dt30) + Integer.parseInt(dt31);
        double total = (double) sum/18;
        Log.i("DB HELPER CLASS: ", String.valueOf(total));
        contentValues.put(STUDENT_TABLE_COL_32, String.valueOf(total));
        long result = db.insert(TABLE_STUDENT_NAME, null, contentValues);
        if (result == -1){
            return false;
        }
        else return true;
    }
    public boolean updateStudent(String id, String dt14, String dt15, String dt16, String dt17, String dt18, String dt19, String dt20, String dt21, String dt22, String dt23, String dt24,
                                 String dt25, String dt26, String dt27, String dt28, String dt29, String dt30, String dt31){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_TABLE_COL_1, id);
        contentValues.put(STUDENT_TABLE_COL_14, dt14);
        contentValues.put(STUDENT_TABLE_COL_15, dt15);
        contentValues.put(STUDENT_TABLE_COL_16, dt16);
        contentValues.put(STUDENT_TABLE_COL_17, dt17);
        contentValues.put(STUDENT_TABLE_COL_18, dt18);
        contentValues.put(STUDENT_TABLE_COL_19, dt19);
        contentValues.put(STUDENT_TABLE_COL_20, dt20);
        contentValues.put(STUDENT_TABLE_COL_21, dt21);
        contentValues.put(STUDENT_TABLE_COL_22, dt22);
        contentValues.put(STUDENT_TABLE_COL_23, dt23);
        contentValues.put(STUDENT_TABLE_COL_24, dt24);
        contentValues.put(STUDENT_TABLE_COL_25, dt25);
        contentValues.put(STUDENT_TABLE_COL_26, dt26);
        contentValues.put(STUDENT_TABLE_COL_27, dt27);
        contentValues.put(STUDENT_TABLE_COL_28, dt28);
        contentValues.put(STUDENT_TABLE_COL_29, dt29);
        contentValues.put(STUDENT_TABLE_COL_30, dt30);
        contentValues.put(STUDENT_TABLE_COL_31, dt31);
        int sum = Integer.parseInt(dt14) + Integer.parseInt(dt15) + Integer.parseInt(dt16) + Integer.parseInt(dt17) + Integer.parseInt(dt18) + Integer.parseInt(dt19) +
                Integer.parseInt(dt20) + Integer.parseInt(dt21) + Integer.parseInt(dt22) + Integer.parseInt(dt23) + Integer.parseInt(dt24) + Integer.parseInt(dt25) +
                Integer.parseInt(dt26) + Integer.parseInt(dt27) + Integer.parseInt(dt28) + Integer.parseInt(dt29) + Integer.parseInt(dt30) + Integer.parseInt(dt31);
        double total = (double) sum/18;
        contentValues.put(STUDENT_TABLE_COL_32, String.valueOf(total));
        db.update(TABLE_STUDENT_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public Integer deleteStudent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENT_NAME, "ID = ?", new String[] {id});
    }
    public Cursor loginExaminer(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_EXAMINER_NAME + " where NAME = ? AND PASSWORD = ?", new String[] {name, password} );
        return res;
    }
    public Cursor viewStudents(String examiner_id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_STUDENT_NAME + " where EXAMINER_ID = ?", new String[] {examiner_id});
        return res;
    }
}
