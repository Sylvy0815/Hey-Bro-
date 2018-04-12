package com.heybro.pnuite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.heybro.pnuite.SoldierActivity.isattackClicked;
import static com.heybro.pnuite.SoldierActivity.isdefendClicked;
import static com.heybro.pnuite.SoldierActivity.isenterClicked;
import static com.heybro.pnuite.SoldierActivity.iskeeperClicked;
import static com.heybro.pnuite.SoldierActivity.isrecruitClicked;

public class PopupActivity extends Activity {
    public static String attackerPosition = "attacker";
    public static String defenderPosition = "defender";
    public static String keeperPosition = "keeper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        Intent intent = getIntent();
        final String locationtext = intent.getStringExtra("userID");
        final String datetext = intent.getStringExtra("userID");
        final int listnum = intent.getIntExtra("listnum", 0);

        Button cancelbtn = (Button) findViewById(R.id.cancelButton);
        Button okbtn = (Button) findViewById(R.id.okButton);
        final TextView tempText = (TextView) findViewById(R.id.tempText);
        tempText.setText(SoldierActivity.temptext.getText());

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int recruitNum = 12;
                String recruitID = HomeActivity.userID;
                String recruitName = HomeActivity.userName;

                String recruitLocation = SoldierActivity.locationtext.getText().toString();
                String recruitDate = SoldierActivity.datetext.getText().toString();
                int enterNum = 12;
                String enterID = HomeActivity.userID;
                String enterName = HomeActivity.userName;

                String enterLocation = locationtext;
                String enterDate = datetext;


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                if (SoldierActivity.temptext.getText().toString().equals("10100")) {
                    String recruitPosition="attacker";
                    RecruitRegisterRequest recruitregisterRequest =
                            new RecruitRegisterRequest(recruitNum, recruitID, recruitName, recruitPosition, recruitLocation, recruitDate, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(PopupActivity.this);
                    queue.add(recruitregisterRequest);
                }if (SoldierActivity.temptext.getText().toString().equals("10010")) {
                    String recruitPosition="defender";
                    RecruitRegisterRequest recruitregisterRequest =
                            new RecruitRegisterRequest(recruitNum, recruitID, recruitName, recruitPosition, recruitLocation, recruitDate, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(PopupActivity.this);
                    queue.add(recruitregisterRequest);
                }if (SoldierActivity.temptext.getText().toString().equals("10001")) {
                    String recruitPosition="keeper";
                    RecruitRegisterRequest recruitregisterRequest =
                            new RecruitRegisterRequest(recruitNum, recruitID, recruitName, recruitPosition, recruitLocation, recruitDate, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(PopupActivity.this);
                    queue.add(recruitregisterRequest);
                }
                if (SoldierActivity.temptext.getText().toString().equals("01100")) {
                    String enterPosition="attacker";
                    EnterRegisterRequest EnterregisterRequest =
                            new EnterRegisterRequest(enterNum, enterID, enterName, enterPosition, enterLocation, enterDate, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(PopupActivity.this);
                    queue.add(EnterregisterRequest);
                }if (SoldierActivity.temptext.getText().toString().equals("01010")) {
                    String enterPosition="defender";
                    EnterRegisterRequest EnterregisterRequest =
                            new EnterRegisterRequest(enterNum, enterID, enterName, enterPosition, enterLocation, enterDate, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(PopupActivity.this);
                    queue.add(EnterregisterRequest);
                }if (SoldierActivity.temptext.getText().toString().equals("01001")) {
                    String enterPosition="keeper";
                    EnterRegisterRequest EnterregisterRequest =
                            new EnterRegisterRequest(enterNum, enterID, enterName, enterPosition, enterLocation, enterDate, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(PopupActivity.this);
                    queue.add(EnterregisterRequest);
                }
                finish();

            }
        });
    }
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
