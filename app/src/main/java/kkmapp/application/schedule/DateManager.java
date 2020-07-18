package kkmapp.application.schedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateManager {
    private Calendar calendar;

    public DateManager() {
        calendar = Calendar.getInstance();
    }

    public List<Date> getDays() {
        Date today = calendar.getTime();
        int dayNum = getWeeks() * 7;

        calendar.set(Calendar.DATE, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) -1;
        calendar.add(Calendar.DATE, -dayOfWeek);

        List<Date> days = new ArrayList<>();

        for (int i = 0; i < dayNum; i ++){
            days.add(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        calendar.setTime(today);

        return days;
    }

    public boolean isCurrentMonth(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM", Locale.US);
        String currentMonth = format.format(calendar.getTime());
        if (currentMonth.equals(format.format(date))){
            return true;
        }else {
            return false;
        }
    }

    public int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public int getWeeks(){
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

    public void nextMonth(){
        calendar.add(Calendar.MONTH, 1);
    }

    public void prevMonth(){
        calendar.add(Calendar.MONTH, -1);
    }

    public Calendar getCalendar() {
        return calendar;
    }
}