package kkmapp.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kkmapp.application.util.BaseFragment;

public class ContactFragment extends BaseFragment {

    private Button toCI;
    private Button toNM;
    private Button toMT;


    public ContactFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact, container, false);
    }

    @Override
    public void guiSetUp() {
        toCI = (Button)getActivity().findViewById(R.id.toCI);
        toNM = (Button)getActivity().findViewById(R.id.toNM);
        toMT = (Button)getActivity().findViewById(R.id.toMT);


        toCI.getLayoutParams().width = (DISPLAY_SIZE.x - 40) / 2;
        toNM.getLayoutParams().width = (DISPLAY_SIZE.x - 40) / 2;
        toMT.getLayoutParams().width = (DISPLAY_SIZE.x - 20);

        toCI.getLayoutParams().height = (DISPLAY_SIZE.y - 60) *2 /3;
        toNM.getLayoutParams().height = (DISPLAY_SIZE.y - 60) *2 /3;
        toMT.getLayoutParams().height = (DISPLAY_SIZE.y - 60) *1 /5;


        toCI.setOnClickListener((new ButtonEvent()));
        toNM.setOnClickListener((new ButtonEvent()));
        toMT.setOnClickListener((new ButtonEvent()));
    }
}

class ButtonEvent implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.toCI:
                    System.out.println("1");// クリック処理連絡先
                    break;

                case R.id.toNM:
                    System.out.println("2");/// クリック処理メール作成
                    break;

                case R.id.toMT:
                    System.out.println("3");/// クリック処理メールテンプレート作成
                    break;

                default:
                    break;
            }
        }
    }
}
