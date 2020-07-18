package kkmapp.application.timekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.util.Properties;

import kkmapp.application.MainActivity;
import kkmapp.application.R;
import kkmapp.application.TimeKeeperFragment;
import kkmapp.application.util.ExtendedProperties;
import kkmapp.application.util.PropertiesIO;

public class TimeKeepingActivity extends AppCompatActivity {

    private TimeKeeper tk;
    private TextView counter;
    private TextView text;
    String url = "time_line1.properties";
    static ExtendedProperties prop;
    public static TimeLine tl = new TimeLine(TimeKeepingActivity.prop);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timekeeper_excuting);
        counter =(TextView)findViewById(R.id.counter);
        text    =(TextView)findViewById(R.id.time_line_text);
        tk = new TimeKeeper(counter, text);
        prop = PropertiesIO.loadEProperties(url, getApplicationContext());
        System.out.println(prop.getProperty("KEY0"));
    }

    public void backToMain(View view) {
        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }

    public void runTask(View view) {
        tk.runTask();
    }

    public void cancelTask(View view) {
        tk.cancelTask();
    }
}
