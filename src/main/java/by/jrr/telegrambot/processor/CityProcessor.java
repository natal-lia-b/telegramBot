package by.jrr.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class CityProcessor implements Processor{

    @Override
    public String run() {
        return "Выберите город";
    }
}
