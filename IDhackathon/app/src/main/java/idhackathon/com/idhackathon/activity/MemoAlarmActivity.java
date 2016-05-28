package idhackathon.com.idhackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import idhackathon.com.idhackathon.MainActivity;
import idhackathon.com.idhackathon.R;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class MemoAlarmActivity extends AppCompatActivity {

    TextView txtTitle;
    Button btnStart, btnCencle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoalarm);

        txtTitle = (TextView)findViewById(R.id.memoalarm_txtTitle);
        btnStart = (Button) findViewById(R.id.memoalarm_btnStart);
        btnCencle = (Button) findViewById(R.id.memoalarm_btnCencle);

        txtTitle.setText("지금 기분이 어떠세요?");

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(itMain);
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
