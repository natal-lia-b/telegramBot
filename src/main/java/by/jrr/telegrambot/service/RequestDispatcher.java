package by.jrr.telegrambot.service;

import by.jrr.telegrambot.bot.BotCommand;
import by.jrr.telegrambot.bot.TelegramBot;
import by.jrr.telegrambot.entity.User;
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
    @Autowired
    EventChangeProcessor eventChangeProcessor;
    @Autowired
    MessageEventService messageEventService;
    @Autowired
    EventProcessor eventProcessor;
    @Autowired
    EventChangeProcessor dateChangeProcessor;
    @Autowired
    MessageEventService messageDateService;
    @Autowired
    EventProcessor dateProcessor;

    public User user = new User("minsk", "today", "film");

    public void dispatch(Update update) {
        switch (getCommand(update)) {
            case CITY:
                messageCityService.sendMessage(update.getMessage(), cityProcessor.run());
                break;
            case START:
                messageService.sendMessage(update.getMessage(), startProcessor.run());
                break;
            case MINSK:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                break;
            case BREST:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                user.setCity("brest");
                break;
            case VITEBSK:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                user.setCity("vitebsk");
                break;
            case GRODNO:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                user.setCity("grodno");
                break;
            case MOGILEV:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                user.setCity("mogilev");
                break;
            case GOMEL:
                messageService.sendMessage(update.getMessage(), cityChangeProcessor.run());
                user.setCity("gomel");
                break;
            case EVENTS:
                messageEventService.sendMessage(update.getMessage(), eventProcessor.run());
                break;
            case EXHIBITION:
                messageService.sendMessage(update.getMessage(), eventChangeProcessor.run());
                user.setEvent("exhibition");
                break;
            case FILM:
                messageService.sendMessage(update.getMessage(), eventChangeProcessor.run());
                user.setEvent("film");
                break;
            case THEATRE:
                messageService.sendMessage(update.getMessage(), eventChangeProcessor.run());
                user.setEvent("theatre");
                break;
            case CONCERT:
                messageService.sendMessage(update.getMessage(), eventChangeProcessor.run());
                user.setEvent("concert");
                break;
            case PARTY:
                messageService.sendMessage(update.getMessage(), eventChangeProcessor.run());
                user.setEvent("party");
                break;
            case ONLINE:
                messageService.sendMessage(update.getMessage(), eventChangeProcessor.run());
                user.setEvent("online");
                break;
            case TODAY:
                messageService.sendMessage(update.getMessage(), dateChangeProcessor.run());
                user.setDate("today");
                break;
            case TOMORROW:
                messageService.sendMessage(update.getMessage(), dateChangeProcessor.run());
                user.setDate("tomorrow");
                break;
            case WEEKEND:
                messageService.sendMessage(update.getMessage(), dateChangeProcessor.run());
                user.setDate("weekend");
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
                } else if (msgText.startsWith(BotCommand.EVENTS.getCommand())) {
                    return BotCommand.EVENTS;
                } else if (msgText.startsWith(BotCommand.EXHIBITION.getCommand())) {
                    return BotCommand.EXHIBITION;
                } else if (msgText.startsWith(BotCommand.FILM.getCommand())) {
                    return BotCommand.FILM;
                } else if (msgText.startsWith(BotCommand.THEATRE.getCommand())) {
                    return BotCommand.THEATRE;
                } else if (msgText.startsWith(BotCommand.CONCERT.getCommand())) {
                    return BotCommand.CONCERT;
                } else if (msgText.startsWith(BotCommand.PARTY.getCommand())) {
                    return BotCommand.PARTY;
                } else if (msgText.startsWith(BotCommand.ONLINE.getCommand())) {
                    return BotCommand.ONLINE;
                } else if (msgText.startsWith(BotCommand.TODAY.getCommand())) {
                    return BotCommand.TODAY;
                } else if (msgText.startsWith(BotCommand.TOMORROW.getCommand())) {
                    return BotCommand.TOMORROW;
                } else if (msgText.startsWith(BotCommand.WEEKEND.getCommand())) {
                    return BotCommand.WEEKEND;
            }
        }
        return BotCommand.NONE;
    }
}
}
