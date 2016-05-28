package idhackathon.com.idhackathon.adapter;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import idhackathon.com.idhackathon.MainActivity;
import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.activity.ScheduleStatsActivity;

/**
 * Created by Jungminki on 2016-05-29.
 */
public class ViewPaperAdapter extends PagerAdapter{
    LayoutInflater inflater;
    Integer count = 1;

    public ViewPaperAdapter(LayoutInflater inflater) {
        // TODO Auto-generated constructor stub

        this.inflater=inflater;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        View view=null;
        view= inflater.inflate(R.layout.child_memodaily, null);

        TextView txtTime= (TextView)view.findViewById(R.id.memodaily_txtTime);
        SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy.MM.dd", java.util.Locale.getDefault());
        Date date = new Date();
        txtTime.setText("< " + dateFormat.format(date) + " >");


        //이미지추가
        ImageButton imgDetail = (ImageButton)view.findViewById(R.id.memodaily_imgDetail);
        imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itScheduleStats = new Intent(inflater.getContext(),ScheduleStatsActivity.class);
                inflater.getContext().startActivity(itScheduleStats);
            }
        });

        //상황에 따라 바뀜
        TextView txtPrint = (TextView)view.findViewById(R.id.memodaily_txtPrint);
        txtPrint.setText("오늘은 힘든 날이었네요..\n내일은 날씨가 좋을거라고 합니다.\nGood Night!\n"+count);
        count++;

        Button btnEnd = (Button)view.findViewById(R.id.memodaily_btnEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itMain = new Intent(inflater.getContext(),MainActivity.class);
                inflater.getContext().startActivity(itMain);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView((View)object);

    }

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v==obj;
    }


}
