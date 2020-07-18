package kkmapp.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;

import kkmapp.application.timekeeper.TKDialogFragment;
import kkmapp.application.timekeeper.TimeKeeperTab;
import kkmapp.application.timekeeper.TimeLine;
import kkmapp.application.util.BaseFragment;
import kkmapp.application.util.PropertiesIO;

public class TimeKeeperFragment extends BaseFragment {

    public static TimeLine selectedTL;
    DialogFragment dialog = new TKDialogFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.timekeeper, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        guiSetUp();
    }

    public void guiSetUp() {
        FragmentTabHost tabHost = (FragmentTabHost)getActivity().findViewById(android.R.id.tabhost);
        tabHost.setup(getActivity(), getActivity().getSupportFragmentManager(), R.id.container);

        TabHost.TabSpec tab1;
        tab1 = tabHost.newTabSpec("TimeLine");
        tab1.setIndicator("timeLine");
        tabHost.addTab(tab1, TimeKeeperTab.class, null);
        tabHost.setOnTabChangedListener(new TabChangeEvent());

        Button btn1 = (Button)getActivity().findViewById(R.id.addItem);
        Button btn2 = (Button)getActivity().findViewById(R.id.startBtn);


        btn1.getLayoutParams().width = (DISPLAY_SIZE.x -30)/2;
        btn2.getLayoutParams().width = (DISPLAY_SIZE.x -30)/2;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show(getFragmentManager(), "test");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(),
                        kkmapp.application.timekeeper.TimeKeepingActivity.class);
                intent.putExtra("TIMELINE_NUM", 0);
                startActivity(intent);
            }
        });
    }
}

class TabChangeEvent implements FragmentTabHost.OnTabChangeListener {
    @Override
    public void onTabChanged(String tabId) {
        Log.d("onTabChanged", "tabId: " + tabId);
    }
}
