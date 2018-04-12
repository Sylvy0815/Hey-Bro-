package com.heybro.pnuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Surround2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surround);

        TextView locationtext2 = (TextView) findViewById(R.id.locationText2);
        locationtext2.setText(HomeActivity.locationtext.getText());
    }
}
