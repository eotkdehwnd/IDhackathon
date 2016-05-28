package idhackathon.com.idhackathon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import idhackathon.com.idhackathon.R;
import idhackathon.com.idhackathon.items.ScheduleItem;

/**
 * Created by Kim on 2016-05-28.
 */
public class ScheduleListAdapter  extends ArrayAdapter<ScheduleItem> {
    private LayoutInflater inflater = null;
    private Context context = null;

    public ScheduleListAdapter(Context context, int resource, ArrayList<ScheduleItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_schedule, null);

            holder = new ViewHolder();

            //row에 있는 정보들을 holder로 가져옴
            holder.tvScheduleTime=(TextView)convertView.findViewById(R.id.tvScheduleTime);

            convertView.setTag(holder);
        }


        holder = (ViewHolder) convertView.getTag();

        ScheduleItem item = getItem(position);

        holder.tvScheduleTime.setText(item.getTime());
        return convertView;
    }

    class ViewHolder {
        TextView tvScheduleTime;
    }

}