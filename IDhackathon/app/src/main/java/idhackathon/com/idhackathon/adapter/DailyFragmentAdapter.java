package idhackathon.com.idhackathon.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.fragment.DetailFragment;
import idhackathon.com.idhackathon.fragment.DiaryFragment;
import idhackathon.com.idhackathon.fragment.ExerciseFragment;
import idhackathon.com.idhackathon.fragment.SmokingFragment;

/**
 * Created by Jungminki on 2016-05-29.
 */
public class DailyFragmentAdapter  extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Today", "Week", "Month"};
    private Fragment[] fragments = new Fragment[]{new DetailFragment(), new ExerciseFragment(), new SmokingFragment()};
    private Context context;

    public DailyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.tab_main_layout, null);
        TextView tv = (TextView) v.findViewById(R.id.txtMainTab);
        tv.setText(tabTitles[position]);
        return v;
    }
}
