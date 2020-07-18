package kkmapp.application.timekeeper;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kkmapp.application.util.ExtendedProperties;
import kkmapp.application.util.PropertiesIO;

public class TimeLine {
    public static List<TimeLine> timeLineList = new ArrayList<>();
    private List<TimeLineItem> items = new ArrayList<>();
    private ExtendedProperties properties;

    public TimeLine(ExtendedProperties properties) {
        this.properties = properties;
        loadItems(properties);
    }

    public void addItem(TimeLineItem item) {
        items.add(item);
        properties.setProperty("KEY"+(items.size()), item.toString());
    }

    public void addItem(int sec, String text) {
        addItem(new TimeLineItem(sec, text));
    }

    private void loadItems(Properties properties) {
        int i = 0;
        String none = "NONE";
        String key = "KEY0";
        String value = none;
        while(true) {
            key = "KEY" + i;
            value = properties.getProperty(key, none);
            if(value.equals(none)) {
                break;
            }

            else {
                String[] splitted = value.split(",", 2);
                int sec = Integer.parseInt(splitted[0]);
                String text = splitted[1];
                addItem(sec, text);
            }
            i++;
        }
    }

    public void saveItems(String title) {
        properties.clear();
        int i = 0;
        for(TimeLineItem item : items) {
            properties.setProperty("KEY"+i, item.toString());
        }
        PropertiesIO.saveProperties(properties, "TIMELINE", title);
    }

    public List<TimeLineItem> getItems() {
        return items;
    }
}

class TimeLineItem {
    private int sec;
    private String text;

    public TimeLineItem(int sec, String text) {
        this.sec = sec;
        this.text = text;
    }

    public int getTime() {
        return sec;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return getTime()+","+getText();
    }
}
