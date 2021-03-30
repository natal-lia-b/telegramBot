package by.jrr.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class EventProcessor implements Processor{

    @Override
    public String run() {
        return "Выберите мероприятие";
    }
}
