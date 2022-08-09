package com.juhwan.dailyquest;

public class ScheduleItem {
    private String title;
    private int hour;
    private int minute;

    public void setTitle(String t) {
        title = t;
    }
    public void setHour(int h) {
        hour = h;
    }
    public void setMinute(int m) {
        minute = m;
    }

    public String getTitle() {
        return this.title;
    }
    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
}
