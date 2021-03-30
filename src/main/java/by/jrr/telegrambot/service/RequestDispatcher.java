package by.jrr.telegrambot.service;

import by.jrr.telegrambot.bot.BotCommand;
import by.jrr.telegrambot.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class RequestDispatcher {
    @Autowired
    MessageService messageService;
    @Autowired
    CityChangeProcessor cityChangeProcessor;
    @Autowired
    MessageCityService messageCityService;
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
                messageCityService.sendMessage(update.getMessage(), cityProcessor.run());
                break;
            case MINSK:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                break;
            case BREST:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                break;
            case VITEBSK:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                break;
            case GRODNO:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                break;
            case MOGILEV:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                break;
            case GOMEL:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
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
                if (msgText.startsWith(BotCommand.CITY.getCommand())) {
                    return BotCommand.CITY;
                } else if (msgText.startsWith(BotCommand.START.getCommand())) {
                    return BotCommand.START;
                } else if (msgText.startsWith(BotCommand.SETTING.getCommand())) {
                    return BotCommand.SETTING;
                } else if (msgText.startsWith(BotCommand.MINSK.getCommand())) {
                    return BotCommand.MINSK;
                } else if (msgText.startsWith(BotCommand.BREST.getCommand())) {
                    return BotCommand.BREST;
                } else if (msgText.startsWith(BotCommand.VITEBSK.getCommand())) {
                    return BotCommand.VITEBSK;
                } else if (msgText.startsWith(BotCommand.GOMEL.getCommand())) {
                    return BotCommand.GOMEL;
                } else if (msgText.startsWith(BotCommand.GRODNO.getCommand())) {
                    return BotCommand.GRODNO;
                } else if (msgText.startsWith(BotCommand.MOGILEV.getCommand())) {
                    return BotCommand.MOGILEV;
                }
            }
        }
        return BotCommand.NONE;
    }
}
