package by.jrr.telegrambot.service;

import by.jrr.telegrambot.bot.BotCommand;
import by.jrr.telegrambot.processor.CityProcessor;
import by.jrr.telegrambot.processor.NoneProcessor;
import by.jrr.telegrambot.processor.SettingsProcessor;
import by.jrr.telegrambot.processor.StartProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.jrr.telegrambot.lists.City.CITY;

@Service
public class RequestDispatcher {
    @Autowired
    MessageService messageService;
    @Autowired
    CityProcessor cityProcessor;
    @Autowired
    SettingsProcessor settingsProcessor;
    @Autowired
    StartProcessor startProcessor;
    @Autowired
    NoneProcessor noneProcessor;

    public void dispatch(Update update) {
        switch (getCommand(update)) {
            case CITY:
                messageService.sendMessage(update.getMessage(), cityProcessor.run());
                break;
            case START:
                messageService.sendMessage(update.getMessage(), startProcessor.run());
                break;
            case SETTING:
                messageService.sendMessage(update.getMessage(), settingsProcessor.run());
                break;
            case NONE:
                messageService.sendMessage(update.getMessage(), noneProcessor.run());
                break;
        }
    }

    private BotCommand getCommand(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                String msgText = message.getText();
                if (msgText.startsWith(CITY.getTitle())) {
                    return BotCommand.CITY;
                } else if (msgText.startsWith(BotCommand.START.getCommand())) {
                    return BotCommand.START;
                } else if (msgText.startsWith(BotCommand.SETTING.getCommand())) {
                    return BotCommand.SETTING;
                }
            }
        }
        return BotCommand.NONE;
    }
}
