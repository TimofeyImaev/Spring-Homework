package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Help implements Command {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return "Returns a list of available commands";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        StringBuilder helpMessage = new StringBuilder("Command list:\n");

        for (var each : AvailableCommands.values()) {
            helpMessage.append(each.getCommand().command())
                .append(" ")
                .append(each.getCommand().description())
                .append("\n");
        }

        LOGGER.trace("Handle message help, chatId - {}", chatId);
        return new SendMessage(chatId, helpMessage.toString());
    }
}
