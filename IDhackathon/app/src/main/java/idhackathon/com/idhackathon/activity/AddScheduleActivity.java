package idhackathon.com.idhackathon.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import idhackathon.com.idhackathon.MainActivity;
import idhackathon.com.idhackathon.R;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class AddScheduleActivity extends AppCompatActivity {
    String Hour;
    String Min;
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

                if (npHour.getValue() < 10) {
                    Hour = 0 + npHour.getContext().toString();
                } else {
                    Hour = npHour.getContext().toString();
                }

                if (npMin.getValue() < 10) {
                    Min = 0 + npMin.getContext().toString();
                } else {
                    Min = npMin.getContext().toString();
                }

                new NetworkAddSchedule().execute();

            }
        });

        btnCencle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }




    class NetworkAddSchedule extends AsyncTask<String, String, Integer> {
        private String err_msg = "Network error.";

        private JSONObject jObjects;

        @Override
        protected Integer doInBackground(String... params) {
            return processing();
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            if (result == 0) {
                Toast.makeText(getApplicationContext(), "저장되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
            else {
                Toast.makeText(getApplicationContext(), "Error",
                        Toast.LENGTH_SHORT).show();
            }
        }

        private Integer processing() {
            try {
                HttpClient http_client = new DefaultHttpClient();
                http_client.getParams().setParameter("http.connection.timeout",
                        7000);

                HttpPost http_post = null;

                List<NameValuePair> name_value = new ArrayList<NameValuePair>();

                http_post = new HttpPost(
                        "https://flow-alarm-spb829.c9users.io/json/alarm_new");


                name_value.add(new BasicNameValuePair("time", Hour+":"+Min));
                name_value.add(new BasicNameValuePair("msg", "지금 기분이 어떠신가요"));
                name_value.add(new BasicNameValuePair("type", "하루일기"));


                UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(
                        name_value, "UTF-8");
                http_post.setEntity(entityRequest);

                HttpResponse response = http_client.execute(http_post);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                response.getEntity().getContent(), "UTF-8"), 8);
                StringBuilder builder = new StringBuilder();
                for (String line = null; (line = reader.readLine()) != null; ) {
                    builder.append(line).append("\n");
                }

                jObjects = new JSONObject(builder.toString());

            } catch (Exception e) {
                Log.i(err_msg, e.toString());
                return 100;
            }
            return 0;
        }

    }
}
