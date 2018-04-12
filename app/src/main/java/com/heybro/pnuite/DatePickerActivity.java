package com.heybro.pnuite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        DatePicker dp = (DatePicker) findViewById(R.id.datePicker1);

        PickerListener listener = new PickerListener();

        Calendar c = Calendar.getInstance();
        int cyear = c.get(Calendar.YEAR);
        int cmonth = c.get(Calendar.MONTH);
        int cday = c.get(Calendar.DAY_OF_MONTH);

        dp.init(cyear, cmonth, cday, listener);
    }

    class PickerListener implements DatePicker.OnDateChangedListener {

        @Override
        public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
            HomeActivity.year=i; HomeActivity.month=i1+1; HomeActivity.date=i2;
            HomeActivity.datetext.setText(String.format("%4d.%2d.%2d", i, i1 + 1, i2));
            finish();
        }
    }
}
