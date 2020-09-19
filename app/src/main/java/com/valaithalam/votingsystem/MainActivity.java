package com.valaithalam.votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void candidate(View view) {

        startActivity(new Intent(MainActivity.this,RegisterCandidate.class));

    }

    public void voter(View view) {
        startActivity(new Intent(MainActivity.this,RegisterVoter.class));

    }

    public void vote(View view) {
        startActivity(new Intent(MainActivity.this,Voting.class));
    }
}
