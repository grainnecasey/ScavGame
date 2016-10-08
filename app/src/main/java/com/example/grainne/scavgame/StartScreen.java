package com.example.grainne.scavgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class StartScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void buttonOnClick(View v) {
        Intent i = new Intent(StartScreen.this, StartGame.class);
        startActivity(i);



    }
}
