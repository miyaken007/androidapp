package kkmapp.application.timekeeper;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import kkmapp.application.R;

public class TKDialogFragment extends DialogFragment {
    private AlertDialog.Builder builder;
    private Dialog dialog;
    private View view;
    private Button okBtn, removeBtn;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        view = getActivity().getLayoutInflater().inflate(R.layout.timekeeper_additem_dialog, null);
        builder.setView(view);
        dialog = builder.create();
        return dialog;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        okBtn = (Button)view.findViewById(R.id.timekeeper_item_button1);
        removeBtn = (Button)view.findViewById(R.id.timekeeper_item_button2);
        guiSetUp();
    }

    public void guiSetUp() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}