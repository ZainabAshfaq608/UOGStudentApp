package com.example.assign_2_bscs_19011519_011;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RegistrationAdapter extends RecyclerView.Adapter<RegistrationAdapter.myViewHolder> {

    ArrayList<RegistrationModel> dataHolder;

    public RegistrationAdapter(ArrayList<RegistrationModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    // convert xml to view
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_registration_adapter,parent,false);
        return new myViewHolder(view);
    }

    @Override
    //set data in arraylist through references
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.stuname.setText(dataHolder.get(position).getStudent_Name());
        holder.fatname.setText(dataHolder.get(position).getFather_Name());
        holder.rollno.setText(dataHolder.get(position).getRoll_No());
        holder.dept.setText(dataHolder.get(position).getDepartment());
        holder.regno.setText(dataHolder.get(position).getRegistration_No());
        holder.semester.setText(dataHolder.get(position).getSemester());
        holder.degreestatus.setText(dataHolder.get(position).getDegree_status());
        holder.contactno.setText(dataHolder.get(position).getContact_no());
        holder.program.setText(dataHolder.get(position).getProgram());
        holder.date.setText(dataHolder.get(position).getDate());
        holder.subject.setText(dataHolder.get(position).getSubject());
        holder.studentsignature.setText(dataHolder.get(position).getStudent_Signature());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView stuname,fatname,rollno, dept, regno, semester, degreestatus, contactno, program, date, subject, studentsignature;
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);
            stuname=(TextView)itemView.findViewById(R.id.StudentName);
            fatname=(TextView)itemView.findViewById(R.id.FatherName);
            rollno=(TextView)itemView.findViewById(R.id.RollNo);
            dept=(TextView)itemView.findViewById(R.id.Department);
            regno=(TextView)itemView.findViewById(R.id.RegistrationNo);
            semester=(TextView)itemView.findViewById(R.id.Semester);
            degreestatus=(TextView)itemView.findViewById(R.id.DegreeStatus);
            contactno=(TextView)itemView.findViewById(R.id.ContactNo);
            program=(TextView)itemView.findViewById(R.id.Program);
            date=(TextView)itemView.findViewById(R.id.Date);
            subject=(TextView)itemView.findViewById(R.id.Subject);
            studentsignature=(TextView)itemView.findViewById(R.id.StuSignature);
        }
    }
}
