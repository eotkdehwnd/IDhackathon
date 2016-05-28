package idhackathon.com.idhackathon.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.adapter.ViewPaperAdapter;

/**
 * Created by Jungminki on 2016-05-28.
 */
public class MemoDailyActivity extends AppCompatActivity {

    ViewPager pager;
    Button btnCategory1, btnCategory2, btnCategory3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memodaily);

        pager= (ViewPager)findViewById(R.id.memodaily_pager);
        btnCategory1 = (Button)findViewById(R.id.memodaily_btnCategory1);
        btnCategory2 = (Button)findViewById(R.id.memodaily_btnCategory2);
        btnCategory3 = (Button)findViewById(R.id.memodaily_btnCategory3);

        ViewPaperAdapter adapter= new ViewPaperAdapter(getLayoutInflater());
        pager.setAdapter(adapter);

        btnCategory1.setText("Today");
        btnCategory2.setText("Week");
        btnCategory3.setText("Month");

    }

    public void mOnClick(View v){
        switch( v.getId() ){
            case R.id.memodaily_btnCategory1:

                pager.setCurrentItem(1,true);

                break;

            case R.id.memodaily_btnCategory2:

                pager.setCurrentItem(2,true);

                break;
            case R.id.memodaily_btnCategory3:
                pager.setCurrentItem(3,true);

                break;
        }
    }

}
