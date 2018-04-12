package com.heybro.pnuite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TeamListPopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list_popup);

        Button okbtn = (Button) findViewById(R.id.okButton);
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"매칭신청이 완료되었습니다.",Toast.LENGTH_LONG);
                finish();
            }
        });
    }
}
