package idhackathon.com.idhackathon.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void onResume() {
        super.onResume();

        arrSchedule.clear();
        new NetworkGetScheduleList().execute();
    }

    /**
     * 레이아웃 초기화
     */
    private void initializeLayout(){
        lvMainSchedule = (ListView)cView.findViewById(R.id.lvMainSchedule);

        adapter = new ScheduleListAdapter(cView.getContext(), R.layout.row_schedule, arrSchedule);

        lvMainSchedule.setAdapter(adapter);
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
                    itMemoAlarm.putExtra("id",arrSchedule.get(i).getId());
                    startActivity(itMemoAlarm);
                }
            }
        });
    }

    /**
     * 스케줄 리스트 받아오는 클래스
     */
    class NetworkGetScheduleList extends AsyncTask<String, String, Integer> {
        private String err_msg = "Network error.";

        // JSON에서 받아오는 객체
        private JSONObject jObjects;

        // AsyncTask 실행되는거
        @Override
        protected Integer doInBackground(String... params) {
            return processing();
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            if (result == 200) {

                try {
                    JSONArray ret_arr = jObjects.getJSONArray("Alarm");
                    for (int index = 0; index < ret_arr.length(); index++) {
                        JSONObject obj_boothIdeas = ret_arr.getJSONObject(index);

                        int id = obj_boothIdeas.getInt("id");
                        String time = obj_boothIdeas.getString("time");
                        String msg = obj_boothIdeas.getString("msg");
                        String type = obj_boothIdeas.getString("type");


                        ScheduleItem items = new ScheduleItem(id, time, msg, type,(index/2==0?true:false));

                        arrSchedule.add(items);

                        // Adapter에게 데이터를 넣었으니 갱신하라고 알려줌
                        adapter.notifyDataSetChanged();
                    }
                    arrSchedule.add(new ScheduleItem());

                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return;
            }
            // Error 상황
            else {
                Toast.makeText(cView.getContext(), "Error",
                        Toast.LENGTH_SHORT).show();
            }
        }

        private Integer processing() {
            try {

                HttpClient http_client = new DefaultHttpClient();
                // 요청한 후 7초 이내에 오지 않으면 timeout 발생하므로 빠져나옴
                http_client.getParams().setParameter("http.connection.timeout",7000);

                // data를 Post방식으로 보냄
                HttpPost http_post = null;

                List<NameValuePair> name_value = new ArrayList<NameValuePair>();

                http_post = new HttpPost("https://flow-alarm-spb829.c9users.io/json/alarm_list");

                UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(
                        name_value, "UTF-8");
                http_post.setEntity(entityRequest);

                // 실행
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
                // 오류발생시
                Log.i(err_msg, e.toString());
                return 100;
            }
            return 200;
        }

    }
}
