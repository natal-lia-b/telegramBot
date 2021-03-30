package by.jrr.telegrambot.bot;

public enum BotCommand {
    START("/start"),
    HELP("/help"),
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
