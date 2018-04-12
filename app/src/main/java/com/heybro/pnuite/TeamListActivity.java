package com.heybro.pnuite;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

public class TeamListActivity extends AppCompatActivity {
    ImageButton matchingbutton1;
    private List<Team> teamList;
    private TeamListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
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
                Intent infoIntent = new Intent(TeamListActivity.this, InfoActivity.class);
                TeamListActivity.this.startActivity(infoIntent);
            }
        });
        surroundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surroundIntent = new Intent(TeamListActivity.this, SurroundActivity.class);
                TeamListActivity.this.startActivity(surroundIntent);
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(TeamListActivity.this, HomeActivity.class);
                TeamListActivity.this.startActivity(homeIntent);
            }
        });
        soldierbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soldierIntent = new Intent(TeamListActivity.this, SoldierActivity.class);
                TeamListActivity.this.startActivity(soldierIntent);
            }
        });
        matchingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent matchingIntent = new Intent(TeamListActivity.this, MatchingActivity.class);
                TeamListActivity.this.startActivity(matchingIntent);
            }
        });
        //-------------------------------------------------------------------------------------------------------

        matchingbutton1 = (ImageButton) findViewById(R.id.matchingButton1);

        matchingbutton1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent teamlistpopupIntent = new Intent(TeamListActivity.this, TeamListPopup.class);
                TeamListActivity.this.startActivity(teamlistpopupIntent);
                return false;
            }
        });
    }
}
