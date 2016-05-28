package idhackathon.com.idhackathon.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import idhackathon.com.idhackathon.R;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class AddScheduleActivity extends AppCompatActivity {

    Button btnStart, btnCencle;
    NumberPicker npHour, npMin;
    Spinner spinCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addschedule);

        String[] category={"운동", "하루 일기", "흡연"};

        spinCategory=(Spinner)findViewById(R.id.timer_spinCategory);
        npHour = (NumberPicker) findViewById(R.id.timer_npHour);
        npMin = (NumberPicker) findViewById(R.id.timer_npMin);
        btnStart = (Button) findViewById(R.id.timer_btnStart);
        btnCencle = (Button) findViewById(R.id.timer_btnCencle);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category);
        spinCategory.setAdapter(adapter);

        npHour.setMinValue(0);
        npMin.setMinValue(0);

        npHour.setMaxValue(23);
        npMin.setMaxValue(59);

        npHour.setWrapSelectorWheel(true);
        npMin.setWrapSelectorWheel(true);

        spinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int chack = spinCategory.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnCencle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
}
