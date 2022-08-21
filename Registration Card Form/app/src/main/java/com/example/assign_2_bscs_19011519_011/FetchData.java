package com.example.assign_2_bscs_19011519_011;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class FetchData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<RegistrationModel> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        recyclerView = findViewById(R.id.Rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DBHelper2(this).viewUserData();
        dataHolder = new ArrayList<>();
        //feed data from cursor to dataHolder

        while (cursor.moveToNext()){
            RegistrationModel obj = new RegistrationModel(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6),
                    cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10),
                    cursor.getString(11));

            dataHolder.add(obj);
        }
        RegistrationAdapter adapter = new RegistrationAdapter(dataHolder);
        recyclerView.setAdapter(adapter);
    }
}