package kkmapp.application.timekeeper;

import android.os.Handler;
import android.widget.TextView;

import java.util.Locale;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import kkmapp.application.MainActivity;
import kkmapp.application.util.PropertiesIO;

public class TimeKeeper {
    private Timer timer;
    private TimeKeeperTask timerTask;
    private Handler handler = new Handler();
    private long count, delay, period;
    private String zero = "00:00.0";
    private TextView counter, text;

    public TimeKeeper(TextView counter, TextView text) {
        super();
        this.counter = counter;
        this.text =text;
        count = 0;
        delay = 0;
        period = 100;
    }

    public void runTask() {
        if(null != timer){
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timerTask = new TimeKeeperTask();
        timer.schedule(timerTask, delay, period);
        counter.setText(zero);
        text.setText("待機中");
    }

    public void cancelTask() {
        if(null != timer){
            timer.cancel();
            timer = null;
            counter.setText(zero);
            text.setText("待機中");
        }
    }

    class TimeKeeperTask extends TimerTask {
        int tlCount = 0;
        int tlSize;
        TimeLine tl = TimeKeepingActivity.tl;

        public TimeKeeperTask() {
            super();
            this.tlSize = tl.getItems().size();
        }

        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {
                    System.out.println("running");
                    count++;
                    long mm = count*100 / 1000 / 60;
                    long ss = count*100 / 1000 % 60;
                    long ms = (count*100 - ss * 1000 - mm * 1000 * 60)/100;
                    counter.setText(
                            String.format(Locale.US, "%1$02d:%2$02d.%3$01d", mm, ss, ms));

                    TimeLineItem item = tl.getItems().get(tlCount);
                    if((mm == (int)item.getTime()/60)&&(ss == item.getTime()%60)) {
                        tlCount++;
                        if(tlCount >= tlSize) {
                            cancel();
                            text.setText("終了");
                        }

                        else {
                            text.setText(item.getText());
                        }
                    }

                    /*if((ss%10 == 0)&&(ss >= 10)) {
                        text.setText(ss+"秒経過");
                    }

                    if(ss == 300) {
                        text.setText("終了");
                        cancel();
                    }*/
                }
            });
        }
    }
}
