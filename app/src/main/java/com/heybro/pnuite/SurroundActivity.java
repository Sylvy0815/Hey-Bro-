package com.heybro.pnuite;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class SurroundActivity extends FragmentActivity implements OnMapReadyCallback {

    // 구글 맵 참조변수 선언
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surround);

        TextView locationtext3 = (TextView) findViewById(R.id.locationText3);
        locationtext3.setText(HomeActivity.locationtext.getText());
        TextView datetext2 = (TextView) findViewById(R.id.dateText2);
        datetext2.setText(HomeActivity.datetext.getText());
        Button selectbtn = (Button) findViewById(R.id.selectButton);

        selectbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent surround2Intent = new Intent(SurroundActivity.this, Surround2Activity.class);
                SurroundActivity.this.startActivity(surround2Intent);
                finish();
            }
        });

        //SupportMapFragment을 통해 레이아웃에 만든 fragment의 ID를 참조하고 구글맵을 호출한다.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //우측 상단에 위치 버튼
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
        //+,- 버튼
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        //서울 여의도에 대한 위치 설정
        LatLng seoul = new LatLng(37.52487, 126.92723);

        final LatLng PNUmiryang = new LatLng(35.456232, 128.806694);
        Marker mPNUmiryang = mMap.addMarker(new MarkerOptions()
                .position(PNUmiryang)
                .title("부산대학교 밀양캠퍼스 운동장")
                .snippet("사용시간 9:00 - 23:00"));

        final LatLng SoongjinPrimarySchool = new LatLng(35.452968, 128.800697);
        Marker mSoongjinPrimarySchool = mMap.addMarker(new MarkerOptions()
                .position(SoongjinPrimarySchool)
                .title("숭진초등학교 운동장")
                .snippet("사용시간 9:00 - 22:00"));

        // 구글 맵에 표시할 마커에 대한 옵션 설정

        Marker mSeoul = mMap.addMarker(new MarkerOptions()
                            .position(seoul)
                            .title("Perth"));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(seoul).title("원하는 위치(위도, 경도)에 마커를 표시했습니다.");

        final LatLng MELBOURNE = new LatLng(-37.81319, 144.96298);
        Marker melbourne = mMap.addMarker(new MarkerOptions()
                .position(MELBOURNE)
                .title("Melbourne")
                .snippet("Population: 4,137,400"));

        // 마커를 생성한다.
        mMap.addMarker(markerOptions);
        //mMap.addMarker(mPNUmiryang);
        //mMap.addMarker(mSoongjinPrimarySchool);

        // 카메라를 여의도에 위치한다ㅏ.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));


    }


    private void setPermission(){
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(this,
                    new String[]{ACCESS_COARSE_LOCATION}, 1);
            return;
        }
    }


}
