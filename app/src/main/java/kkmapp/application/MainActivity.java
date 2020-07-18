package kkmapp.application;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Properties;

import kkmapp.application.timekeeper.TimeLine;
import kkmapp.application.util.ExtendedProperties;
import kkmapp.application.util.PropertiesIO;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        toTK(new View(this));
    }

    public void toTK(View view) {
        Fragment fragment = new TimeKeeperFragment();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void toTL(View view) {
        Fragment fragment = new TodoListFragment();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void toCT(View view) {
        Fragment fragment = new ContactFragment();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void toSL(View view) {
        Fragment fragment = new ScheduleFragment();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}