package com.valaithalam.votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterCandidate extends AppCompatActivity {

    EditText candi_name, candi_email;
    EditText candi_dep;
    Button register;
    DbHelper regDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_candidate);

        regDb = new DbHelper(this);
        candi_name = findViewById(R.id.candi_name);
        candi_dep = findViewById(R.id.candi_dept);
        candi_email = findViewById(R.id.candi_email);
        register = findViewById(R.id.bn_register);

        InsertData();
    }

        public void InsertData(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = regDb.insertData(candi_name.getText().toString(),
                        candi_email.getText().toString(),
                        candi_dep.getText().toString());

                if(isInserted)
                    Toast.makeText(RegisterCandidate.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(RegisterCandidate.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        });

    }


}
