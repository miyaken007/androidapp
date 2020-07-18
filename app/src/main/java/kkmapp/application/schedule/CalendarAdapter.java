package kkmapp.application.schedule;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kkmapp.application.R;

public class CalendarAdapter extends BaseAdapter {

    private List<Date> dateList = new ArrayList();
    private Context context;
    private DateManager dateManager;
    private LayoutInflater inflater;

    private class ViewHolder {
        public TextView text;
    }

    public CalendarAdapter(Context context) {
        this.context = context;
        dateManager  = new DateManager();
        inflater = LayoutInflater.from(context);
        dateList = dateManager.getDays();
    }

    @Override
    public int getCount() {
        return dateList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.calendar_cell, null);
            holder = new ViewHolder();
            holder.text = convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        float dp = context.getResources().getDisplayMetrics().density;
        int dateSize = parent.getWidth()/7 - (int)dp;
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(dateSize, dateSize);
        convertView.setLayoutParams(lp);

        SimpleDateFormat dateFormat = new SimpleDateFormat("d", Locale.US);
        holder.text.setText(dateFormat.format(dateList.get(position)));

        int colorId;
        if(dateManager.isCurrentMonth(dateList.get(position))) {
            switch (dateManager.getDayOfWeek(dateList.get(position))){
                case 1:
                    colorId = Color.RED;
                    break;
                case 7:
                    colorId = Color.BLUE;
                    break;

                default:
                    colorId = Color.BLACK;
                    break;
            }
        }

        else {
            colorId = Color.LTGRAY;
        }

        holder.text.setTextColor(colorId);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return dateList.get(position).getTime();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    public String getTitle(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy"+"年"+"MM"+"月", Locale.US);
        return format.format(dateManager.getCalendar().getTime());
    }

    public void nextMonth(){
        dateManager.nextMonth();
        dateList = dateManager.getDays();
        this.notifyDataSetChanged();
    }

    public void prevMonth(){
        dateManager.prevMonth();
        dateList = dateManager.getDays();
        this.notifyDataSetChanged();
    }
}