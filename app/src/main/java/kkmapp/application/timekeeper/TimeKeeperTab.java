package kkmapp.application.timekeeper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kkmapp.application.R;
import kkmapp.application.util.BaseFragment;

public class TimeKeeperTab extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.timekeeper_tab, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        guiSetUp();
    }

    @Override
    public void guiSetUp() {

    }
}
