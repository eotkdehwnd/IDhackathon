package idhackathon.com.idhackathon.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import idhackathon.com.idhackathon.MainActivity;
import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.activity.ScheduleStatsActivity;

/**
 * Created by Jungminki on 2016-05-29.
 */
public class DetailFragment extends Fragment {

    private View cView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        cView = inflater.inflate(R.layout.child_memodaily, container, false);

        TextView txtTime= (TextView)cView.findViewById(R.id.memodaily_txtTime);
        SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy.MM.dd", java.util.Locale.getDefault());
        Date date = new Date();
        txtTime.setText("< " + dateFormat.format(date) + " >");


        //이미지추가
        ImageButton imgDetail = (ImageButton)cView.findViewById(R.id.memodaily_imgDetail);
        imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itScheduleStats = new Intent(cView.getContext(),ScheduleStatsActivity.class);
                cView.getContext().startActivity(itScheduleStats);
            }
        });

        //상황에 따라 바뀜
        TextView txtPrint = (TextView)cView.findViewById(R.id.memodaily_txtPrint);
        txtPrint.setText("오늘은 힘든 날이었네요..\n내일은 날씨가 좋을거라고 합니다.\nGood Night!\n");

        Button btnEnd = (Button)cView.findViewById(R.id.memodaily_btnEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itMain = new Intent(cView.getContext(),MainActivity.class);
                cView.getContext().startActivity(itMain);
            }
        });

        //이미지 생성
        ImageView imgGood = (ImageView)cView.findViewById(R.id.memodaily_imgGood);
        ImageView imgSad = (ImageView)cView.findViewById(R.id.memodaily_imgSad);
        ImageView imgAngry = (ImageView)cView.findViewById(R.id.memodaily_imgAngry);

        return cView;
    }
}
