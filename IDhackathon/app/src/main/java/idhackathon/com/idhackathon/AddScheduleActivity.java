package idhackathon.com.idhackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class AddScheduleActivity extends AppCompatActivity {

    Button btnStart, btnEnd;
    TextView txtTimeEnd;
    NumberPicker npHour, npMin;
    Integer time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addschedule);

        npHour = (NumberPicker) findViewById(R.id.timer_npHour);
        npMin = (NumberPicker) findViewById(R.id.timer_npMin);
        btnStart = (Button) findViewById(R.id.timer_btnStart);
        btnEnd = (Button) findViewById(R.id.timer_btnEnd);
        txtTimeEnd = (TextView) findViewById(R.id.timer_txtTimeEnd);

        npHour.setMinValue(0);
        npMin.setMinValue(0);

        npHour.setMaxValue(23);
        npMin.setMaxValue(59);

        npHour.setWrapSelectorWheel(true);
        npMin.setWrapSelectorWheel(true);

        npMin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                if (npHour.getValue() == 0) {
                    if (newVal == 0) {
                        npHour.setValue(1);
                    }
                } else if (npHour.getValue() == 1) {
                    if (newVal == 0) {
                        npHour.setValue(0);
                    }
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
