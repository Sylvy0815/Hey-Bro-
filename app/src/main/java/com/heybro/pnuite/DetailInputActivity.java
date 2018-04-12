package com.heybro.pnuite;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class DetailInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_input);

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
                Intent infoIntent = new Intent(DetailInputActivity.this, InfoActivity.class);
                DetailInputActivity.this.startActivity(infoIntent);
            }
        });
        surroundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surroundIntent = new Intent(DetailInputActivity.this, SurroundActivity.class);
                DetailInputActivity.this.startActivity(surroundIntent);
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(DetailInputActivity.this, HomeActivity.class);
                DetailInputActivity.this.startActivity(homeIntent);
            }
        });
        soldierbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soldierIntent = new Intent(DetailInputActivity.this, SoldierActivity.class);
                DetailInputActivity.this.startActivity(soldierIntent);
            }
        });
        matchingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent matchingIntent = new Intent(DetailInputActivity.this, MatchingActivity.class);
                DetailInputActivity.this.startActivity(matchingIntent);
            }
        });
        //-------------------------------------------------------------------------------------------------------
        final CheckBox sortDistance = (CheckBox) findViewById(R.id.sortDistance);
        final CheckBox sortCheap = (CheckBox) findViewById(R.id.sortCheap);
        final CheckBox facilityParking = (CheckBox) findViewById(R.id.facilityParking);
        final CheckBox facilityShower = (CheckBox) findViewById(R.id.facilityShower);
        final RadioButton radio5km = (RadioButton) findViewById(R.id.radio5km);
        final RadioButton radio10km = (RadioButton) findViewById(R.id.radio10km);
        final RadioButton radio20km = (RadioButton) findViewById(R.id.radio20km);

        ImageView detailButton = (ImageView) findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Distance = sortDistance.isChecked()?"거리순,":"";
                String Cheap = sortCheap.isChecked()?"낮은가격순,":"";
                String Parking = facilityParking.isChecked()?"주차장,":"";
                String Shower = facilityShower.isChecked()?"샤워장,":"";
                String r5km = radio5km.isChecked()?"5km":"";
                String r10km = radio5km.isChecked()?"10km":"";
                String r20km = radio5km.isChecked()?"20km":"";
                HomeActivity.detailtext.setText(Distance+Cheap+Parking+Shower+r5km+r10km+r20km);
                finish();
            }
        });

    }
}
