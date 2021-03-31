package by.jrr.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class DateProcessor implements Processor{

    @Override
    public String run() { return "Выберите день"; }
}