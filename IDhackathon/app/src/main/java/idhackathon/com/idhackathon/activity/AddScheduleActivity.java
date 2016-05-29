package idhackathon.com.idhackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Spinner;

import idhackathon.com.idhackathon.MainActivity;
import idhackathon.com.idhackathon.R;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class AddScheduleActivity extends AppCompatActivity {

    ImageButton btnStart, btnCencle;
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
        btnStart = (ImageButton) findViewById(R.id.timer_btnStart);
        btnCencle = (ImageButton) findViewById(R.id.timer_btnCencle);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner, category);
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
                Intent itMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(itMain);

                if (Integer.parseInt(npHour.getContext().toString()) < 10) {
                    String Hour = 0 + npHour.getContext().toString();
                } else {
                    String Hour = npHour.getContext().toString();
                }

                if (Integer.parseInt(npMin.getContext().toString()) < 10) {
                    String Min = 0 + npMin.getContext().toString();
                } else {
                    String Min = npMin.getContext().toString();
                }

            }
        });

        btnCencle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(itMain);
            }
        });

    }
}
