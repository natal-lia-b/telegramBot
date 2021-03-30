package by.jrr.telegrambot.processor;

import by.jrr.telegrambot.bot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartProcessor implements Processor{

    @Override
    public String run() {
         return "Прива";
    }
}
