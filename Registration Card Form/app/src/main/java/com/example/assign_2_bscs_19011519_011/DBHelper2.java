package com.example.assign_2_bscs_19011519_011;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DBHelper2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RegCardDB";

    public DBHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("create Table RegCardDetails (StudentName TEXT PRIMARY KEY, FatherName TEXT, RollNo TEXT, " +
                "Department TEXT, RegistrationNo TEXT, Semester TEXT, DegreeStatus TEXT, " +
                "ContactNo TEXT, Program TEXT, Date TEXT, Subject TEXT, StudentSignature TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop TABLE if exists RegCardDetails");
    }


    public boolean insertUserData(String student_name, String father_name, String roll_no,String department,
                                   String registration_no,String semester, String degree_status, String contact_no,
                                   String program, String date, String subject, String student_signature){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("StudentName", student_name);
        contentValues.put("FatherName", father_name);
        contentValues.put("RollNo", roll_no);
        contentValues.put("Department", department);
        contentValues.put("RegistrationNo", registration_no);
        contentValues.put("Semester", semester);
        contentValues.put("DegreeStatus", degree_status);
        contentValues.put("ContactNo", contact_no);
        contentValues.put("Program", program);
        contentValues.put("Date", date);
        contentValues.put("Subject", subject);
        contentValues.put("StudentSignature", student_signature);
        long result = MyDB.insert("RegCardDetails", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updateUserData(String student_name, String father_name, String roll_no,String department,
                                  String registration_no,String semester, String degree_status, String contact_no,
                                  String program, String date, String subject, String student_signature) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("StudentName", student_name);
        contentValues.put("FatherName", father_name);
        contentValues.put("RollNo", roll_no);
        contentValues.put("Department", department);
        contentValues.put("RegistrationNo", registration_no);
        contentValues.put("Semester", semester);
        contentValues.put("DegreeStatus", degree_status);
        contentValues.put("ContactNo", contact_no);
        contentValues.put("Program", program);
        contentValues.put("Date", date);
        contentValues.put("Subject", subject);
        contentValues.put("StudentSignature", student_signature);
        Cursor cursor = MyDB.rawQuery("Select * from RegCardDetails where StudentName = ?", new String[]{student_name});

        if (cursor.getCount() > 0) {
            long result = MyDB.update("RegCardDetails", contentValues, "StudentName=?", new String[]{student_name});
            if (result == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    public boolean deleteUserData(String Sname){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from RegCardDetails where StudentName = ?", new String[] {Sname});

        if (cursor.getCount() > 0) {
            long result = MyDB.delete("RegCardDetails", "StudentName=?", new String[]{Sname});
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }


    public Cursor viewUserData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from RegCardDetails", null);
        return cursor;
    }
}
