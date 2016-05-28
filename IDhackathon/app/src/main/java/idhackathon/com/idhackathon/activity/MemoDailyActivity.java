package idhackathon.com.idhackathon.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.adapter.DailyFragmentAdapter;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class MemoDailyActivity extends AppCompatActivity {

    ViewPager pager;
    TabLayout tabLayout;
    TabLayout.Tab tab;
    Button btnCategory1, btnCategory2, btnCategory3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memodaily);

        initializeLayout();
        setListener();

    }


    /**
     * 레이아웃 초기화
     */
    private void initializeLayout(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.memodaily_pager);

        DailyFragmentAdapter dailyFragmentAdapter = new DailyFragmentAdapter(getSupportFragmentManager(), MemoDailyActivity.this);
        viewPager.setAdapter(dailyFragmentAdapter);


        tabLayout = (TabLayout) findViewById(R.id.mainTab);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tab = tabLayout.getTabAt(i);
            tab.setCustomView(dailyFragmentAdapter.getTabView(i));
        }
    }

    /**
     * 리스너 설정
     */
    private void setListener(){

    }

}
