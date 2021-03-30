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

    BotCommand(String command) {
        this.command = command;
    }

}
