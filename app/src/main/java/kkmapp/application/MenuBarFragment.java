package kkmapp.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kkmapp.application.util.BaseFragment;

public class MenuBarFragment extends BaseFragment {

    public MenuBarFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_bar, container, false);
    }

    @Override
    public void guiSetUp() {
        Button toTK = (Button)getActivity().findViewById(R.id.toTK);
        Button toTL = (Button)getActivity().findViewById(R.id.toTL);
        Button toCT = (Button)getActivity().findViewById(R.id.toCT);
        Button toSL = (Button)getActivity().findViewById(R.id.toSL);

        toTK.getLayoutParams().width = (DISPLAY_SIZE.x - 30)/ 2;
        toTL.getLayoutParams().width = (DISPLAY_SIZE.x - 30)/ 2;
        toCT.getLayoutParams().width = (DISPLAY_SIZE.x - 30)/ 2;
        toSL.getLayoutParams().width = (DISPLAY_SIZE.x - 30)/ 2;
    }
}
