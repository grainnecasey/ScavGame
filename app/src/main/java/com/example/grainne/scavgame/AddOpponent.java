package com.example.grainne.scavgame;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class AddOpponent extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_opponent2);
    }

    public void createNew(View v)
    {
        Intent i = new Intent(AddOpponent.this, NewLobby.class);
        startActivity(i);
    }

}
