package com.heybro.pnuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        TextView idText = (TextView) findViewById(R.id.idText);
        TextView passwordText = (TextView) findViewById(R.id.passwordText);
        TextView nameText = (TextView) findViewById(R.id.nameText);
        TextView ageText = (TextView) findViewById(R.id.ageText);
        TextView emailText = (TextView) findViewById(R.id.emailText);
        TextView mainlocationText = (TextView) findViewById(R.id.mainlocationText);
        TextView mainpositionText = (TextView) findViewById(R.id.mainpositionText);
        idText.setText(HomeActivity.userID);
        passwordText.setText(HomeActivity.userPassword);
        nameText.setText(HomeActivity.userName);
        ageText.setText(HomeActivity.userAge);
        emailText.setText(HomeActivity.userEmail);
        mainlocationText.setText(HomeActivity.userLocation);
        mainpositionText.setText(HomeActivity.userPosition);

    }
}
