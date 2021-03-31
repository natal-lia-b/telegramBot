package by.jrr.telegrambot.processor;

import by.jrr.telegrambot.entity.User;
import org.springframework.stereotype.Service;

@Service
public class FindEventProcessor implements Processor {
    User user;

    @Override
    public String run() {
        return generateLink();
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String generateLink() {
        StringBuilder link = new StringBuilder("https://afisha.tut.by/");

        link.append(user.getDate() + user.getCity() + "/");
        if (!user.getEvent().equals("")) {
            link.append(user.getEvent() + "/");
        }

        return link.toString();
    }
}
