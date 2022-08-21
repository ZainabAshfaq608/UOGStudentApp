package com.example.assign_2_bscs_19011519_011;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText student_name;
    EditText father_name;
    EditText roll_no;
    EditText registration_no;
    EditText department;
    EditText semester;
    EditText degree_status;
    EditText contact_no;
    EditText subject;
    EditText student_signature;
    EditText program;
    EditText date;
    Button add, delete, update, view;
    DBHelper2 DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        student_name = findViewById(R.id.SName);
        father_name = findViewById(R.id.FName);
        roll_no = findViewById(R.id.rollNo);
        registration_no = findViewById(R.id.regNo);
        department = findViewById(R.id.dept);
        semester = findViewById(R.id.semester);
        degree_status = findViewById(R.id.degreeStatus);
        contact_no = findViewById(R.id.contactNo);
        subject = findViewById(R.id.subject);
        student_signature = findViewById(R.id.signature);
        program = findViewById(R.id.program);
        date = findViewById(R.id.date);

        DB = new DBHelper2(this);

        add= findViewById(R.id.btn_add);
        update = findViewById(R.id.btn_update);
        view = findViewById(R.id.btn_view);
        delete = findViewById(R.id.btn_delete);


    }


    public void  Add(View view) {


        String StuName = student_name.getText().toString();
        String FatName = father_name.getText().toString();
        String RollNo = roll_no.getText().toString();
        String Dept = department.getText().toString();
        String RegNo = registration_no.getText().toString();
        String Sem = semester.getText().toString();
        String DegSta = degree_status.getText().toString();
        String ContNo = contact_no.getText().toString();
        String Prog = program.getText().toString();
        String Date = date.getText().toString();
        String Sub = subject.getText().toString();
        String StuSign = student_signature.getText().toString();

        Boolean checkInsertData = DB.insertUserData(StuName, FatName, RollNo,
                Dept, RegNo, Sem, DegSta, ContNo, Prog, Date, Sub, StuSign);
        if (checkInsertData == true){
            Toast.makeText(HomeActivity.this, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(HomeActivity.this, "Data Not Inserted!", Toast.LENGTH_SHORT).show();
        }
    }


    public void Update(View view) {

        String StuName = student_name.getText().toString();
        String FatName = father_name.getText().toString();
        String RollNo = roll_no.getText().toString();
        String Dept = department.getText().toString();
        String RegNo = registration_no.getText().toString();
        String Sem = semester.getText().toString();
        String DegSta = degree_status.getText().toString();
        String ContNo = contact_no.getText().toString();
        String Prog = program.getText().toString();
        String Date = date.getText().toString();
        String Sub = subject.getText().toString();
        String StuSign = student_signature.getText().toString();

        Boolean checkUpdateData = DB.updateUserData(StuName, FatName, RollNo,
                Dept, RegNo, Sem, DegSta, ContNo, Prog, Date, Sub, StuSign);
        if (checkUpdateData == true){
            Toast.makeText(HomeActivity.this, "Data Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(HomeActivity.this, "Unable to update data!", Toast.LENGTH_SHORT).show();
        }
    }

    public void View(View view) {

        Cursor cursor = DB.viewUserData();
        if (cursor.getCount() == 0){
            Toast.makeText(HomeActivity.this, "No Data Exists!", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()){
            buffer.append("Student Name :" + cursor.getString(0)+"\n");
            buffer.append("Father Name :" + cursor.getString(1)+"\n");
            buffer.append("Roll No :" + cursor.getString(2)+"\n");
            buffer.append("Department :" + cursor.getString(3)+"\n");
            buffer.append("Registration No :" + cursor.getString(4)+"\n");
            buffer.append("Semester :" + cursor.getString(5)+"\n");
            buffer.append("Degree Status :" + cursor.getString(6)+"\n");
            buffer.append("Contact No :" + cursor.getString(7)+"\n");
            buffer.append("Program :" + cursor.getString(8)+"\n");
            buffer.append("Date :" + cursor.getString(9)+"\n");
            buffer.append("Subject :" + cursor.getString(10)+"\n");
            buffer.append("Student Signature :" + cursor.getString(11)+"\n\n\n");

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Registration Issuance Form");
        builder.setMessage(buffer.toString());
        builder.show();
    }

    public void Delete(View view) {
        String StuName = student_name.getText().toString();
        Boolean checkDeleteData = DB.deleteUserData(StuName);
        if (checkDeleteData == true){
            Toast.makeText(HomeActivity.this, "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(HomeActivity.this, "Unable to delete data!", Toast.LENGTH_SHORT).show();
        }
    }


    public void FetchData(View view) {
        startActivity(new Intent(getApplicationContext(), FetchData.class));
    }
}