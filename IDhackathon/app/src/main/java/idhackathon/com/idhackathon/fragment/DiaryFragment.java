package idhackathon.com.idhackathon.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.activity.AddScheduleActivity;
import idhackathon.com.idhackathon.activity.MemoAlarmActivity;
import idhackathon.com.idhackathon.adapter.ScheduleListAdapter;
import idhackathon.com.idhackathon.items.ScheduleItem;

/**
 * Created by Kim on 2016-05-29.
 */
public class DiaryFragment extends Fragment {
    ListView lvMainSchedule;
    ScheduleListAdapter adapter;
    ArrayList<ScheduleItem> arrSchedule = new ArrayList<>();

    private View cView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        cView = inflater.inflate(R.layout.fragment_diary, container, false);

        initializeLayout();
        setListener();
        return cView;

    }

    /**
     * 레이아웃 초기화
     */
    private void initializeLayout(){
        lvMainSchedule = (ListView)cView.findViewById(R.id.lvMainSchedule);

        adapter = new ScheduleListAdapter(cView.getContext(), R.layout.row_schedule, arrSchedule);

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
                    Intent itAddSchedule = new Intent(cView.getContext(),AddScheduleActivity.class);
                    startActivity(itAddSchedule);
                }else {
                    Intent itMemoAlarm = new Intent(cView.getContext(), MemoAlarmActivity.class);
                    startActivity(itMemoAlarm);
                }
            }
        });
    }

}
