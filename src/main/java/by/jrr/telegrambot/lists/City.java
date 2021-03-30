package by.jrr.telegrambot.lists;

/*
для Минска ссылка: https://afisha.tut.by/?city=minsk
для остальных городов: https://afisha.tut.by/grodno/
 */

public enum City {
    CITY ("Город"),
    VITEBSK ("Витебск"),
    BREST ("Брест"),
    GOMEL ("Гомель"),
    GRODNO ("Гродно"),
    MINSK ("Минск"),
    MOGILEV ("Могилев");

    String title;

    City(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
