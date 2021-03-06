package idhackathon.com.idhackathon.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
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

import idhackathon.com.idhackathon.R;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class MemoAlarmActivity extends AppCompatActivity {
    int id = 0;
    TextView txtTitle;
    ImageButton btnStart, btnCencle, imgGood, imgSad, imgAngry;
    boolean Good = false, Sad = false, Angry = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoalarm);
        setTitle("서비스 이름");

        id = getIntent().getExtras().getInt("id");

        txtTitle = (TextView)findViewById(R.id.memoalarm_txtTitle);
        btnStart = (ImageButton) findViewById(R.id.memoalarm_btnStart);
        btnCencle = (ImageButton) findViewById(R.id.memoalarm_btnCencle);
        imgGood = (ImageButton) findViewById(R.id.memoalarm_imgGood);
        imgSad = (ImageButton) findViewById(R.id.memoalarm_imgSad);
        imgAngry = (ImageButton) findViewById(R.id.memoalarm_imgAngry);

        txtTitle.setText("지금 기분이 어떠세요?");

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkAddMemo().execute();
            }
        });

        btnCencle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        imgGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Good) {
                    imgGood.setImageResource(R.drawable.feeling_icon_01_pressed);
                    Good = false;
                }else {
                    imgGood.setImageResource(R.drawable.feeling_icon_01_normal);
                    Good = true;
                    Sad = false;
                    Angry= false;
                }
            }
        });

        imgSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Sad) {
                    imgSad.setImageResource(R.drawable.feeling_icon_02_pressed);
                    Sad = false;
                }else {
                    imgSad.setImageResource(R.drawable.feeling_icon_02_normal);
                    Sad = true;
                    Good = false;
                    Angry = false;
                }
            }
        });

        imgAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Angry) {
                    imgAngry.setImageResource(R.drawable.feeling_icon_03_pressed);
                    Angry = false;
                }else {
                    imgAngry.setImageResource(R.drawable.feeling_icon_03_normal);
                    Angry = true;
                    Sad = false;
                    Good = false;
                }
            }
        });

    }

    class NetworkAddMemo extends AsyncTask<String, String, Integer> {
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
                        "https://flow-alarm-spb829.c9users.io/json/alarm_list");

                EditText memoalarm_editMemoContent = (EditText)findViewById(R.id.memoalarm_editMemoContent);
                String memo = memoalarm_editMemoContent.getText().toString();

                name_value.add(new BasicNameValuePair("alarm_id", id + ""));
                name_value.add(new BasicNameValuePair("memo", memo));
                if(Good) {
                    name_value.add(new BasicNameValuePair("feeling", "좋아요"));
                }else if(Sad) {
                    name_value.add(new BasicNameValuePair("feeling", "슬퍼요"));
                }else if(Angry) {
                    name_value.add(new BasicNameValuePair("feeling", "화나요"));
                }else {
                    Toast.makeText(getApplicationContext(), "채크해주세요.", Toast.LENGTH_SHORT).show();
                    return 0;
                }


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
