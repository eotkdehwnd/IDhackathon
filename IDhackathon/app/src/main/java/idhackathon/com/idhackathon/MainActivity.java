package idhackathon.com.idhackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import idhackathon.com.idhackathon.activity.AddScheduleActivity;
import idhackathon.com.idhackathon.activity.MemoAlarmActivity;
import idhackathon.com.idhackathon.activity.MemoDailyActivity;
import idhackathon.com.idhackathon.adapter.ScheduleListAdapter;
import idhackathon.com.idhackathon.items.ScheduleItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;

    ListView lvMainSchedule;
    ScheduleListAdapter adapter;
    ArrayList<ScheduleItem> arrSchedule = new ArrayList<>();
    Button btnstats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLayout();
        setListener();

        btnstats = (Button)findViewById(R.id.btnstats);
        btnstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itMemoDaily = new Intent(getApplicationContext(),MemoDailyActivity.class);
                startActivity(itMemoDaily);
            }
        });
    }

    /**
     * 레이아웃 초기화
     */
    private void initializeLayout(){
        lvMainSchedule = (ListView)findViewById(R.id.lvMainSchedule);

        adapter = new ScheduleListAdapter(getApplicationContext(), R.layout.row_schedule, arrSchedule);

        lvMainSchedule.setAdapter(adapter);

        arrSchedule.add(new ScheduleItem("테스트1"));
        arrSchedule.add(new ScheduleItem("테스트2"));
        arrSchedule.add(new ScheduleItem("테스트3"));
        arrSchedule.add(new ScheduleItem("테스트4"));

        arrSchedule.add(new ScheduleItem("추가하기"));

        adapter.notifyDataSetChanged();



    }

    /**
     * 리스너 설정
     */
    private void setListener(){
        lvMainSchedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i+1 == arrSchedule.size()){
                    // 추가하기
                    Intent itAddSchedule = new Intent(getApplicationContext(),AddScheduleActivity.class);
                    startActivity(itAddSchedule);
               }else {
                    Intent itMemoAlarm = new Intent(getApplicationContext(), MemoAlarmActivity.class);
                    startActivity(itMemoAlarm);
                }
            }
        });
    }
}