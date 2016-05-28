package idhackathon.com.idhackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import idhackathon.com.idhackathon.MainActivity;
import idhackathon.com.idhackathon.R;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class MemoAlarmActivity extends AppCompatActivity {

    TextView txtTitle;
    ImageButton btnStart, btnCencle, imgGood, imgSad, imgAngry;
    boolean Good = false, Sad = false, Angry = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoalarm);

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

        imgGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Good) {
                    imgGood.setImageResource(R.drawable.feeling_icon_01_pressed);
                    Good = false;
                }else {
                    imgGood.setImageResource(R.drawable.feeling_icon_01_normal);
                    Good = true;
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
                }
            }
        });

    }



}
