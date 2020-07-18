package kkmapp.application.util;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {
    protected Point DISPLAY_SIZE = new Point();
    protected abstract void guiSetUp();

    public BaseFragment() {
        super();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getWindowManager().getDefaultDisplay().getSize(DISPLAY_SIZE);
        guiSetUp();
    }
}
