package com.valaithalam.votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterVoter extends AppCompatActivity {

    EditText voter_name,voter_email;
    EditText voter_dep;
    Button register;

    VoterDbHelper vDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_voter);


        vDb = new VoterDbHelper(this);

        voter_name = findViewById(R.id.candi_name);
        voter_dep = findViewById(R.id.candi_dept);
        voter_email = findViewById(R.id.candi_email);
        register = findViewById(R.id.bn_register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = vDb.VinsertData(voter_name.getText().toString(),
                        voter_email.getText().toString(),
                        voter_dep.getText().toString());

                if(isInserted)
                    Toast.makeText(RegisterVoter.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(RegisterVoter.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        });


    }
}
