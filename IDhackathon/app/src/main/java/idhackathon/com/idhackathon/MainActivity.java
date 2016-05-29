package idhackathon.com.idhackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import idhackathon.com.idhackathon.activity.ScheduleStatsActivity;
import idhackathon.com.idhackathon.adapter.MainFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mDrawer;
    private NavigationView mNavigationView;
    private TabLayout tabLayout;
    private TabLayout.Tab tab;
    private ListView lvNav;

    Button btnstats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLayout();
        setListener();

//        btnstats = (Button)findViewById(R.id.btnstats);
//        btnstats.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent itMemoDaily = new Intent(getApplicationContext(),MemoDailyActivity.class);
//                startActivity(itMemoDaily);
//            }
//        });
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

        mDrawer = (LinearLayout)View.inflate(getApplicationContext(),R.layout.nav_drawer,null);
        lvNav = (ListView)mDrawer.findViewById(R.id.lvNav);
    }

    /**
     * 리스너 설정
     */
    private void setListener(){
        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    // 통계
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), ScheduleStatsActivity.class);
                        startActivity(intent);
                        break;

                    // 설정
                    case 1:
//                        Intent itPurchaseList = new Intent(getApplicationContext(), PurchaseListActivity.class);
//                        startActivity(itPurchaseList);
//                        break;

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}