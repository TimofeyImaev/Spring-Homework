package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.URLParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.URI;

public class Untrack implements Command{
    private final static Logger LOGGER = LogManager.getLogger();
    @Override
    public String command() {
        return "/untrack";
    }

    @Override
    public String description() {
        return "Stop tracking link";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        String untrackMessage = "Stop tracking";
        URI url = URI.create(update.message().text().split(" ")[1]);
        String address = URLParser.parse(url);

        /*
        Adding address to bd
        ...
         */

        LOGGER.trace("Handle message untrack, chatId - {}", chatId);
        return new SendMessage(chatId, untrackMessage);
    }
}
