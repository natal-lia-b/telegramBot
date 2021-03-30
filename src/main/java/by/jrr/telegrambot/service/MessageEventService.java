package by.jrr.telegrambot.service;

import by.jrr.telegrambot.bot.BotCommand;
import by.jrr.telegrambot.bot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageEventService {

    @Autowired
    TelegramBot telegramBot;

    public void sendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        getMarkup(sendMessage);
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void getMarkup(SendMessage sendMessage) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(markup);
        markup.setSelective(true);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton(BotCommand.EXHIBITION.getCommand()));
        keyboardFirstRow.add(new KeyboardButton(BotCommand.FILM.getCommand()));
        keyboardFirstRow.add(new KeyboardButton(BotCommand.THEATRE.getCommand()));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton(BotCommand.CONCERT.getCommand()));
        keyboardSecondRow.add(new KeyboardButton(BotCommand.PARTY.getCommand()));
        keyboardSecondRow.add(new KeyboardButton(BotCommand.ONLINE.getCommand()));
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);

        markup.setKeyboard(keyboard);
    }
}
