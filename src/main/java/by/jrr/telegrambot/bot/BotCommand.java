package by.jrr.telegrambot.bot;

public enum BotCommand {
    START("/start"),
    SETTING("/settings"),
    NONE("/none"),
    CITY ("Город"),
    VITEBSK ("Витебск"),
    BREST ("Брест"),
    GOMEL ("Гомель"),
    GRODNO ("Гродно"),
    MINSK ("Минск"),
    MOGILEV ("Могилев"),
    EXHIBITION ("Выставки"),
    FILM ("Кино"),
    THEATRE ("Театры"),
    CONCERT ("Концерты"),
    PARTY ("Вечеринки"),
    ONLINE ("Онлайн-мероприятия");

    String command;

    public String getCommand() {
        return command;
    }

    BotCommand(String command) {
        this.command = command;
    }
}
