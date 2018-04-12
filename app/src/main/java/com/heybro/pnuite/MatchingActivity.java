package com.heybro.pnuite;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MatchingActivity extends AppCompatActivity {

    static EditText locationtext;
    boolean ishighClicked = true;
    boolean ismiddleClicked = false;
    boolean islowClicked = false;
    ImageButton highbutton;
    ImageButton middlebutton;
    ImageButton lowbutton;
    ImageButton searchbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);

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
                Intent infoIntent = new Intent(MatchingActivity.this, InfoActivity.class);
                MatchingActivity.this.startActivity(infoIntent);
            }
        });
        surroundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surroundIntent = new Intent(MatchingActivity.this, SurroundActivity.class);
                MatchingActivity.this.startActivity(surroundIntent);
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(MatchingActivity.this, HomeActivity.class);
                MatchingActivity.this.startActivity(homeIntent);
            }
        });
        soldierbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soldierIntent = new Intent(MatchingActivity.this, SoldierActivity.class);
                MatchingActivity.this.startActivity(soldierIntent);
            }
        });
        matchingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent matchingIntent = new Intent(MatchingActivity.this, MatchingActivity.class);
                MatchingActivity.this.startActivity(matchingIntent);
            }
        });
        //-------------------------------------------------------------------------------------------------------
        ImageButton back = (ImageButton) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        locationtext = (EditText) findViewById(R.id.locationText);
        locationtext.setText(HomeActivity.locationtext.getText());
        final TextView datetext = (TextView) findViewById(R.id.datetext);
        datetext.setText(HomeActivity.datetext.getText());



        highbutton = (ImageButton) findViewById(R.id.highButton);
        middlebutton = (ImageButton) findViewById(R.id.middleButton);
        lowbutton = (ImageButton) findViewById(R.id.lowButton);
        searchbutton = (ImageButton) findViewById(R.id.searchButton);
        ImageButton resetbutton = (ImageButton) findViewById(R.id.resetButton);
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetintent = new Intent(MatchingActivity.this, MatchingActivity.class);
                MatchingActivity.this.startActivity(resetintent);
                finish();
            }
        });
        datetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dateIntent = new Intent(MatchingActivity.this, DatePickerActivity.class);
                MatchingActivity.this.startActivity(dateIntent);
                datetext.setText(HomeActivity.datetext.getText());
            }
        });
        locationtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationIntent = new Intent(MatchingActivity.this, LocationInputActivity.class);
                MatchingActivity.this.startActivity(locationIntent);
                locationtext.setText(HomeActivity.locationtext.getText());
            }
        });

        searchbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent teamlistIntent = new Intent(MatchingActivity.this, TeamListActivity.class);
                MatchingActivity.this.startActivity(teamlistIntent);
                return false;
            }
        });

        highbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ishighClicked=true;
                ismiddleClicked=false;
                islowClicked=false;
                highbutton.setImageResource(R.drawable.matching_level_high_pressed);
                middlebutton.setImageResource(R.drawable.matching_level_middle_default);
                lowbutton.setImageResource(R.drawable.matching_level_low_default);
                return false;
            }
        });
        middlebutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ishighClicked=false;
                ismiddleClicked=true;
                islowClicked=false;
                highbutton.setImageResource(R.drawable.matching_level_high_default);
                middlebutton.setImageResource(R.drawable.matching_level_middle_pressed);
                lowbutton.setImageResource(R.drawable.matching_level_low_default);
                return false;
            }
        });
        lowbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ishighClicked=false;
                ismiddleClicked=false;
                islowClicked=true;
                highbutton.setImageResource(R.drawable.matching_level_high_default);
                middlebutton.setImageResource(R.drawable.matching_level_middle_default);
                lowbutton.setImageResource(R.drawable.matching_level_low_pressed);
                return false;
            }
        });
    }
}
