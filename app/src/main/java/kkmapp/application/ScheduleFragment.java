package kkmapp.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;

import kkmapp.application.schedule.CalendarAdapter;
import kkmapp.application.util.BaseFragment;

public class ScheduleFragment extends BaseFragment {

    private TextView title;
    private Button prevBtn, nextBtn;
    private CalendarAdapter adapter;
    private GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.schedule, container, false);
    }

    @Override
    public void guiSetUp() {
        title    = getActivity().findViewById(R.id.titleText);
        prevBtn  = getActivity().findViewById(R.id.prevButton);
        nextBtn  = getActivity().findViewById(R.id.nextButton);
        gridView = getActivity().findViewById(R.id.gridLayout);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.prevMonth();
                title.setText(adapter.getTitle());
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.nextMonth();
                title.setText(adapter.getTitle());
            }
        });

        adapter = new CalendarAdapter(getActivity());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new ClickEvent());
        title.setText(adapter.getTitle());
    }
}

class ClickEvent implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int a, long l) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(l);
        int year  = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day   = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println(year+", "+month+", "+day);
    }
}
