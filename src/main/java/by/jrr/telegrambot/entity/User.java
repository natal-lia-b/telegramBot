package by.jrr.telegrambot.entity;

public class User {
    private String city;
    private String date;
    private String event;

    public User(String city, String date, String event) {
        this.city = city;
        this.date = date;
        this.event = event;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
