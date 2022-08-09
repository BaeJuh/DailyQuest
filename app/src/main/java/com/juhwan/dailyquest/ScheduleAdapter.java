package com.juhwan.dailyquest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleAdapter extends BaseAdapter {
    private TextView titleTextView;
    private TextView hourTextView;
    private TextView minuteTextView;

    private ArrayList<ScheduleItem> items = new ArrayList<ScheduleItem>(); // item

    public ScheduleAdapter() {
        // 생성자
    }

    // item 추가
    public void addItem(String t, int h, int m) {
        ScheduleItem item = new ScheduleItem();
        item.setTitle(t);
        item.setHour(h);
        item.setMinute(m);

        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_schedule, viewGroup, false);
        }

        titleTextView = (TextView) view.findViewById(R.id.scheduletitle);
        hourTextView = (TextView) view.findViewById(R.id.schedulehour);
        minuteTextView = (TextView) view.findViewById(R.id.scheduleminute);

        ScheduleItem scheduleItem = items.get(i);

        titleTextView.setText(scheduleItem.getTitle());
        hourTextView.setText(scheduleItem.getHour() + "");
        minuteTextView.setText(scheduleItem.getMinute() + "");

        return view;
    }
}
