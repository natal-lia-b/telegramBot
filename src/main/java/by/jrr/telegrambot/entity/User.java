package by.jrr.telegrambot.entity;

import java.io.Serializable;
import java.util.Objects;

public class User{
    private String city;
    private String date;
    private String event;

    public User(String city, String date, String event) {
        this.city = city;
        this.date = date;
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(city, user.city) &&
                Objects.equals(date, user.date) &&
                Objects.equals(event, user.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, date, event);
    }

    @Override
    public String toString() {
        return "User{" +
                "city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", event='" + event + '\'' +
                '}';
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
