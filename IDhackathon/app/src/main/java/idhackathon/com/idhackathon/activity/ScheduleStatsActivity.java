package idhackathon.com.idhackathon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.adapter.ScheduleStatsAdapter;

/**
 * Created by Kim on 2016-05-29.
 */
public class ScheduleStatsActivity extends AppCompatActivity {
    LayoutInflater inflater;
    ViewPager vpScheduleStats;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_stats);

        initializeLayout();
        setListener();
        initializeTab();
    }

    private void initializeLayout(){
        vpScheduleStats = (ViewPager)findViewById(R.id.vpScheduleStats);
    }

    private void setListener(){

    }

    private void initializeTab() {
//        View itemView;
//
//        itemView = View.inflate(getApplicationContext(),R.layout.row_schedule_stats,null);
//
//        vpScheduleStats.addView(itemView);
        ScheduleStatsAdapter statsFragmentAdapter = new ScheduleStatsAdapter(getLayoutInflater());
        vpScheduleStats.setAdapter(statsFragmentAdapter);
        statsFragmentAdapter.setCount(5);
        statsFragmentAdapter.notifyDataSetChanged();


    }
}
