package by.jrr.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class DateChangeProcessor implements Processor{

    @Override
    public String run() { return "Настройка установлена"; }
}