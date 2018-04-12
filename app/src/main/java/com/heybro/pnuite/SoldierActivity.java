package com.heybro.pnuite;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SoldierActivity extends AppCompatActivity{
    public static boolean isrecruitClicked = true;
    public static boolean isenterClicked = false;
    public static boolean isattackClicked = true;
    public static boolean isdefendClicked = false;
    public static boolean iskeeperClicked = false;
    public static TextView temptext;
    public static TextView temptext2;

    ImageButton recruitbutton;
    ImageButton enterbutton;
    ImageButton attackbutton;
    ImageButton defendbutton;
    ImageButton keeperbutton;
    public static TextView locationtext;
    public static TextView datetext;
    public int listnum;

    private ListView listView;
    private ListView listView2;
    private UserListAdapter adapter;
    private RecruitListAdapter recruitadapter;
    private EnterListAdapter enteradapter;
    private List<User> userList;
    private List<User> saveList;
    private List<Recruit> recruituserList;
    private List<Recruit> recruitsaveList;
    private List<Enter> enteruserList;
    private List<Enter> entersaveList;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soldier);

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
                Intent infoIntent = new Intent(SoldierActivity.this, InfoActivity.class);
                SoldierActivity.this.startActivity(infoIntent);
            }
        });
        surroundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surroundIntent = new Intent(SoldierActivity.this, SurroundActivity.class);
                SoldierActivity.this.startActivity(surroundIntent);
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SoldierActivity.this, HomeActivity.class);
                SoldierActivity.this.startActivity(homeIntent);
            }
        });
        soldierbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soldierIntent = new Intent(SoldierActivity.this, SoldierActivity.class);
                SoldierActivity.this.startActivity(soldierIntent);
            }
        });
        matchingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent matchingIntent = new Intent(SoldierActivity.this, MatchingActivity.class);
                SoldierActivity.this.startActivity(matchingIntent);
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
        locationtext = (TextView) findViewById(R.id.locationText);
        locationtext.setText(HomeActivity.locationtext.getText());
        datetext = (TextView) findViewById(R.id.datetext);
        datetext.setText(HomeActivity.datetext.getText());
        temptext = (TextView) findViewById(R.id.checker);
        temptext2 = (TextView) findViewById(R.id.checker2);

        recruitbutton = (ImageButton) findViewById(R.id.recruitButton);
        enterbutton = (ImageButton) findViewById(R.id.enterButton);
        attackbutton = (ImageButton) findViewById(R.id.attackButton);
        defendbutton = (ImageButton) findViewById(R.id.defendButton);
        keeperbutton = (ImageButton) findViewById(R.id.keeperButton);
        ImageButton commitbutton = (ImageButton) findViewById(R.id.commitButton);
        commitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent popupIntent = new Intent(SoldierActivity.this, PopupActivity.class);
                popupIntent.putExtra("isrecruitClicked", isrecruitClicked);
                popupIntent.putExtra("isenterClicked", isenterClicked);
                popupIntent.putExtra("isattackClicked", isattackClicked);
                popupIntent.putExtra("isdefendClicked", isdefendClicked);
                popupIntent.putExtra("iskeeperClicked", iskeeperClicked);
                popupIntent.putExtra("locationtext", locationtext.getText());
                popupIntent.putExtra("datetext", datetext.getText());
                popupIntent.putExtra("listnum",listnum);
                SoldierActivity.this.startActivity(popupIntent);
            }
        });
        datetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dateIntent = new Intent(SoldierActivity.this, DatePickerActivity.class);
                SoldierActivity.this.startActivity(dateIntent);
                datetext.setText(HomeActivity.datetext.getText());
            }
        });
        locationtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationIntent = new Intent(SoldierActivity.this, LocationInputActivity.class);
                SoldierActivity.this.startActivity(locationIntent);
                locationtext.setText(HomeActivity.locationtext.getText());
            }
        });

        recruitbutton.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isrecruitClicked=true;
                isenterClicked=false;
                recruitbutton.setImageResource(R.drawable.soldier_recruit_button_pressed);
                enterbutton.setImageResource(R.drawable.soldier_enter_button_default);
                temptext.setText((isrecruitClicked?"1":"0")+(isenterClicked?"1":"0")+(isattackClicked?"1":"0")+(isdefendClicked?"1":"0")+(iskeeperClicked?"1":"0"));
                recruitadapter = new RecruitListAdapter(getApplicationContext(), recruituserList);
                listView.setAdapter(recruitadapter);
                //listView.setVisibility(View.VISIBLE);
                //listView2.setVisibility(View.INVISIBLE);
                new BackgroundTask().execute();
                return false;
            }
        });
        enterbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isrecruitClicked=false;
                isenterClicked=true;
                recruitbutton.setImageResource(R.drawable.soldier_recruit_button_default);
                enterbutton.setImageResource(R.drawable.soldier_enter_button_pressed);
                temptext.setText((isrecruitClicked?"1":"0")+(isenterClicked?"1":"0")+(isattackClicked?"1":"0")+(isdefendClicked?"1":"0")+(iskeeperClicked?"1":"0"));
                //enteradapter = new EnterListAdapter(getApplicationContext(), enteruserList);
                //0listView.setAdapter(enteradapter);
                //listView2.setAdapter(enteradapter);
                //listView.setVisibility(View.INVISIBLE);
                //listView2.setVisibility(View.VISIBLE);
                new BackgroundTask().execute();
                return false;
            }
        });
        attackbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isattackClicked=true;
                isdefendClicked=false;
                iskeeperClicked=false;
                attackbutton.setImageResource(R.drawable.soldier_attack_button_pressed);
                defendbutton.setImageResource(R.drawable.soldier_defend_button_default);
                keeperbutton.setImageResource(R.drawable.soldier_keeper_button_default);
                temptext.setText((isrecruitClicked?"1":"0")+(isenterClicked?"1":"0")+(isattackClicked?"1":"0")+(isdefendClicked?"1":"0")+(iskeeperClicked?"1":"0"));
                return false;
            }
        });
        defendbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isattackClicked=false;
                isdefendClicked=true;
                iskeeperClicked=false;
                attackbutton.setImageResource(R.drawable.soldier_attack_button_default);
                defendbutton.setImageResource(R.drawable.soldier_defend_button_pressed);
                keeperbutton.setImageResource(R.drawable.soldier_keeper_button_default);
                temptext.setText((isrecruitClicked?"1":"0")+(isenterClicked?"1":"0")+(isattackClicked?"1":"0")+(isdefendClicked?"1":"0")+(iskeeperClicked?"1":"0"));
                return false;
            }
        });
        keeperbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isattackClicked=false;
                isdefendClicked=false;
                iskeeperClicked=true;
                attackbutton.setImageResource(R.drawable.soldier_attack_button_default);
                defendbutton.setImageResource(R.drawable.soldier_defend_button_default);
                keeperbutton.setImageResource(R.drawable.soldier_keeper_button_pressed);
                temptext.setText((isrecruitClicked?"1":"0")+(isenterClicked?"1":"0")+(isattackClicked?"1":"0")+(isdefendClicked?"1":"0")+(iskeeperClicked?"1":"0"));
                return false;
            }
        });

    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target="http://hjune08.cafe24.com/RecruitList.php";

        @Override
        protected void onPreExecute(){
            if(temptext.getText().toString().equals("10100")) target.replaceAll("Enter","Recruit");
            if(temptext.getText().toString().equals("10010")) target.replaceAll("Enter","Recruit");
            if(temptext.getText().toString().equals("10001")) target.replaceAll("Enter","Recruit");
            if(temptext.getText().toString().equals("01100")) target.replaceAll("Recruit","Enter");
            if(temptext.getText().toString().equals("01010")) target.replaceAll("Recruit","Enter");
            if(temptext.getText().toString().equals("01001")) target.replaceAll("Recruit","Enter");
            //if(isrecruitClicked) target = "http://hjune08.cafe24.com/RecruitList.php";
            //if(isenterClicked) target = "http://hjune08.cafe24.com/EnterList.php";
        }

        @Override
        protected String doInBackground(Void... voids){
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                listnum=0;
                while((temp = bufferedReader.readLine())!=null){
                    stringBuilder.append(temp + "\n");
                    listnum++;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch(Exception e){
                e.printStackTrace();
            }
            //publishProgress();
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate(values);
            //temptext2.setText(listnum);
        }

        @Override
        public void onPostExecute(String result){
            //Intent recruitintent = new Intent(SoldierActivity.this, ManagementActivity.class);
            //recruitintent.putExtra("userList", result);
            //SoldierActivity.this.startActivity(recruitintent);
            //-------------------------------------------------------------------------------------

            //TextView userListTextView = (TextView) findViewById(R.id.userListTextView);
            //Intent intent = getIntent();
            //userListTextView.setText(intent.getStringExtra("userList"));

            listView = (ListView) findViewById(R.id.listView);
            //listView2 = (ListView) findViewById(R.id.listView2);
            recruituserList = new ArrayList<Recruit>();
            recruitsaveList = new ArrayList<Recruit>();
            enteruserList = new ArrayList<Enter>();
            entersaveList = new ArrayList<Enter>();

/*
        userList.add(new User("홍길동", "홍길동", "홍길동", "20"));
        userList.add(new User("이효준", "이효준", "이효준", "23"));
        userList.add(new User("이수진", "이수진", "이수진", "22"));
        userList.add(new User("주현수", "주현수", "주현수", "24"));
*/


            try{
                if(isrecruitClicked) {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    int count = 0;
                    int recruitNum;
                    String recruitID, recruitName, recruitPosition, recruitLocation, recruitDate;
                    while (count < jsonArray.length()) {
                        JSONObject object = jsonArray.getJSONObject(count);
                        recruitNum = object.getInt("recruitNum");
                        recruitID = object.getString("recruitID");
                        recruitName = object.getString("recruitName");
                        recruitPosition = object.getString("recruitPosition");
                        recruitLocation = object.getString("recruitLocation");
                        recruitDate = object.getString("recruitDate");
                        Recruit recruit = new Recruit(recruitNum, recruitID, recruitName, recruitPosition, recruitLocation, recruitDate);
                        recruituserList.add(recruit);
                        recruitsaveList.add(recruit);
                        count++;
                    }
                } else{
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    int count = 0;
                    int enterNum;
                    String enterID, enterName, enterPosition, enterLocation, enterDate;
                    while (count < jsonArray.length()) {
                        JSONObject object = jsonArray.getJSONObject(count);
                        enterNum = object.getInt("enterNum");
                        enterID = object.getString("enterID");
                        enterName = object.getString("enterName");
                        enterPosition = object.getString("enterPosition");
                        enterLocation = object.getString("enterLocation");
                        enterDate = object.getString("enterDate");
                        Enter enter = new Enter(enterNum, enterID, enterName, enterPosition, enterLocation, enterDate);
                        enteruserList.add(enter);
                        entersaveList.add(enter);
                        count++;
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }

}
