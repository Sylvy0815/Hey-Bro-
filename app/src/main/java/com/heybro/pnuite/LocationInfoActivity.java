package com.heybro.pnuite;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LocationInfoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_info);
        //----------------------------------------- 기본 폼 -------------------------------------------------------
        ImageButton infobtn = (ImageButton) findViewById(R.id.infoButton);
        ImageButton surroundbtn = (ImageButton) findViewById(R.id.surroundButton);
        ImageButton homebtn = (ImageButton) findViewById(R.id.homeButton);
        ImageButton soldierbtn = (ImageButton) findViewById(R.id.soldierButton);
        ImageButton matchingbtn = (ImageButton) findViewById(R.id.matchingButton);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(LocationInfoActivity.this, InfoActivity.class);
                LocationInfoActivity.this.startActivity(infoIntent);
            }
        });
        surroundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surroundIntent = new Intent(LocationInfoActivity.this, SurroundActivity.class);
                LocationInfoActivity.this.startActivity(surroundIntent);
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(LocationInfoActivity.this, HomeActivity.class);
                LocationInfoActivity.this.startActivity(homeIntent);
            }
        });
        soldierbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soldierIntent = new Intent(LocationInfoActivity.this, SoldierActivity.class);
                LocationInfoActivity.this.startActivity(soldierIntent);
            }
        });
        matchingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent matchingIntent = new Intent(LocationInfoActivity.this, MatchingActivity.class);
                LocationInfoActivity.this.startActivity(matchingIntent);
            }
        });
        //-------------------------------------------------------------------------------------------------------
        //--------------------------------------- 맵 기본 폼 -----------------------------------------------------

        ImageButton reservebutton1 = (ImageButton) findViewById(R.id.reserveButton1);
        ImageButton reservebutton2 = (ImageButton) findViewById(R.id.reserveButton2);
        ImageButton reservebutton3 = (ImageButton) findViewById(R.id.reserveButton3);
        ImageButton reservebutton4 = (ImageButton) findViewById(R.id.reserveButton4);
        ImageButton reservebutton5 = (ImageButton) findViewById(R.id.reserveButton5);
        ImageButton reservebutton6 = (ImageButton) findViewById(R.id.reserveButton6);
        reservebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationinfopopupIntent = new Intent(LocationInfoActivity.this, LocationInfoPopup.class);
                LocationInfoActivity.this.startActivity(locationinfopopupIntent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        //popup!

    }
}
