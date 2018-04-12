package com.heybro.pnuite;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;


public class HomeActivity extends AppCompatActivity {
    public static int year=0000, month=00, date=00;
    public static TextView datetext;
    public static TextView locationtext;
    public static TextView detailtext;
    public static LatLng currentPosition;
    public static String userID;
    public static String userPassword;
    public static String userName;
    public static String userAge;
    public static String userEmail;
    public static String userLocation ;
    public static String userPosition;
    public static String message = "환영합니다, "+userID+"님!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        locationtext = (TextView) findViewById(R.id.locationText);
        datetext = (TextView) findViewById(R.id.datetext);
        detailtext = (TextView) findViewById(R.id.detailText);

        //----------------------------------------- 기본 폼 -------------------------------------------------------
        ImageButton infobtn = (ImageButton) findViewById(R.id.infoButton);
        ImageButton surroundbtn = (ImageButton) findViewById(R.id.surroundButton);
        ImageButton homebtn = (ImageButton) findViewById(R.id.homeButton);
        ImageButton soldierbtn = (ImageButton) findViewById(R.id.soldierButton);
        ImageButton matchingbtn = (ImageButton) findViewById(R.id.matchingButton);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        locationtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationIntent = new Intent(HomeActivity.this, LocationInputActivity.class);
                HomeActivity.this.startActivity(locationIntent);
            }
        });
        datetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dateIntent = new Intent(HomeActivity.this, DatePickerActivity.class);
                HomeActivity.this.startActivity(dateIntent);
            }
        });
        detailtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(HomeActivity.this, DetailInputActivity.class);
                HomeActivity.this.startActivity(detailIntent);
            }
        });
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(HomeActivity.this, InfoActivity.class);
                HomeActivity.this.startActivity(infoIntent);
            }
        });
        surroundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationinputintent = new Intent(HomeActivity.this, LocationInputActivity.class);
                HomeActivity.this.startActivity(locationinputintent);
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(HomeActivity.this, HomeActivity.class);
                HomeActivity.this.startActivity(homeIntent);
            }
        });
        soldierbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soldierIntent = new Intent(HomeActivity.this, SoldierActivity.class);
                HomeActivity.this.startActivity(soldierIntent);
            }
        });
        matchingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent matchingIntent = new Intent(HomeActivity.this, MatchingActivity.class);
                HomeActivity.this.startActivity(matchingIntent);
            }
        });
        //-------------------------------------------------------------------------------------------------------
        //테스트용입니다
        ImageButton searchButton = (ImageButton) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationinputintent = new Intent(HomeActivity.this, LocationInputActivity.class);
                HomeActivity.this.startActivity(locationinputintent);
            }
        });
        //-----------------------------------------------------------------------------------------------------------
        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");
        userPassword = intent.getStringExtra("userPassword");
        userName = intent.getStringExtra("userName");
        userAge = intent.getStringExtra("userAge");
        userEmail = intent.getStringExtra("userEmail");
        userLocation = intent.getStringExtra("userLocation");
        userPosition = intent.getStringExtra("userPosition");
        message = "환영합니다, "+userID+"님!";

        locationtext.setText(userLocation);
    }
}
