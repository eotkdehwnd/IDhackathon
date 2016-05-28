package idhackathon.com.idhackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import idhackathon.com.idhackathon.activity.MemoDailyActivity;
import idhackathon.com.idhackathon.adapter.MainFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private TabLayout tabLayout;
    private TabLayout.Tab tab;

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
        ViewPager viewPager = (ViewPager) findViewById(R.id.mainViewPager);

        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(mainFragmentAdapter);


        tabLayout = (TabLayout) findViewById(R.id.mainTab);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tab = tabLayout.getTabAt(i);
            tab.setCustomView(mainFragmentAdapter.getTabView(i));
        }
    }

    /**
     * 리스너 설정
     */
    private void setListener(){

    }
}