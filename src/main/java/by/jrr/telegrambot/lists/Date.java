package by.jrr.telegrambot.lists;

public enum Date {
    TODAY ("Сегодня"),
    TOMORROW ("Завтра"),
    WEEKEND ("Ближайший уикенд");

    String title;

    Date(String title) { this.title = title; }

    public String getTitle() {
        return title;
    }
}
