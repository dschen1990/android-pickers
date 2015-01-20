package test.datepicker.com.datepickertest;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;

import net.simonvt.datepicker.DatePicker;
import net.simonvt.numberpicker.NumberPicker;
import net.simonvt.timepicker.TimePicker;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
        np.setMaxValue(20);
        np.setMinValue(0);
        np.setFocusable(true);
        np.setFocusableInTouchMode(true);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        boolean showCalendar = false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            showCalendar = getResources().getConfiguration().smallestScreenWidthDp >= 600;
        } else {
            showCalendar =
                    (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
        }

        datePicker.setCalendarViewShown(showCalendar);

        TimePicker mTimePicker = (TimePicker) findViewById(R.id.timePicker);
        mTimePicker.setIs24HourView(true);
    }
}
