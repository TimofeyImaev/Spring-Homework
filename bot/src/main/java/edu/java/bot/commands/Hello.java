package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hello implements Command {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public String command() {
        return "Hello";
    }

    @Override
    public String description() {
        return "Greets the user";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        String userName = update.message().from().firstName();
        String helloMessage = "Hello, " + userName + "!";

        LOGGER.trace("Handle message hello, chatId - {}", chatId);
        return new SendMessage(chatId, helloMessage);
    }
}
