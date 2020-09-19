package com.valaithalam.votingsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Voting extends AppCompatActivity {

    Button view,bn_vote;
    DbHelper regDb;

    VotingFinal votefinal;

    EditText vote,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        votefinal = new VotingFinal(this);
        regDb = new DbHelper(this);

        Button result = findViewById(R.id.result);


        view = findViewById(R.id.bn_view);
        vote = findViewById(R.id.id_vote);
        email = findViewById(R.id.vote_email);

        bn_vote = findViewById(R.id.vote);


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = votefinal.getAllData();
                if (res.getCount() == 0) {

                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Email :" + res.getString(0) + "\n");
                    buffer.append("Id :" + res.getString(1) + "\n");

                }

                // Show all data
                showMessage("Result", buffer.toString());
            }
                                  }
        );



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Cursor res = regDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :" + res.getString(0) + "\n");
                    buffer.append("Name :" + res.getString(1) + "\n");
                    buffer.append("Email :" + res.getString(2) + "\n");
                    buffer.append("Department :" + res.getString(3) + "\n\n");
                }

                // Show all data
                showMessage("Candidate Info", buffer.toString());
            }
            });

        bn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = votefinal.insertData(email.getText().toString(),
                        vote.getText().toString());

                if(isInserted)
                    Toast.makeText(Voting.this,"Vote Registered",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Voting.this,"Already Voted",Toast.LENGTH_LONG).show();

            }
        });

    }



    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}
