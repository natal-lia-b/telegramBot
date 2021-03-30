package by.jrr.telegrambot.bot;

public enum BotCommand {
    START("/start"),
    // команды 1го уровня
    CITY("/city"),
    SETTING("/settings"),
    NONE("/none");

    String command;

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        String result = "не знаю, что и сказать";

        if (this.name().equals("CITY")) {
            result = "Город";
        }
        return result;
    }

    BotCommand(String command) {
        this.command = command;
    }

}
