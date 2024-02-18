package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Start implements Command {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String description() {
        return "Registers a user";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        String startMessage = "You are registered, use /help for a list of commands";

        LOGGER.trace("Handle message start, chatId - {}", chatId);
        return new SendMessage(chatId, startMessage);
    }
}
