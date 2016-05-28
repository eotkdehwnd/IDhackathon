package idhackathon.com.idhackathon.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import idhackathon.com.idhackathon.R;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class MemoAlarmActivity extends AppCompatActivity {

    TextView txtTitle, txtAlarmCount;
    Integer count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoalarm);

        txtTitle = (TextView)findViewById(R.id.memoalarm_txtTitle);
        txtAlarmCount = (TextView)findViewById(R.id.memoalarm_txtAlarmCount);

        txtTitle.setText("지금 기분이 어떠세요?");
        txtAlarmCount.setText("오늘의 알람" + count + "번 째");

    }



}
