package kkmapp.application.util;

import android.app.Activity;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

public abstract class Views {

    protected static Activity activity;
    protected static final Point DISPLAY_SIZE = new Point();

    protected final int ID;
    protected final View content;

    public abstract void guiSetUp();

    protected Views(int ID) {
        this.ID = ID;
        this.content = activity.getLayoutInflater().inflate(ID, null);
    }

    protected final ConstraintLayout.LayoutParams getCLP(ViewGroup vg) {
        return (ConstraintLayout.LayoutParams)vg.getLayoutParams();
    }

    public final int getID() {
        return ID;
    }

    public final View getContent() {
        return content;
    }

    public static final void setup(Activity newActivity) {
        activity = newActivity;
        Display display = activity.getWindowManager().getDefaultDisplay();
        display.getSize(DISPLAY_SIZE);
    }
}
