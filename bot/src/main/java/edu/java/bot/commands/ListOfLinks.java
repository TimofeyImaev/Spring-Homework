package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListOfLinks implements Command {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public String command() {
        return "/list";
    }

    @Override
    public String description() {
        return "Show list of tracked links";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        List<String> listOfLinks = List.of();
        StringBuilder listMessage = new StringBuilder("No tracked links");

        if (!listOfLinks.isEmpty()) {
            listMessage = new StringBuilder("Tracked links:\n");

            for (String link : listOfLinks) {
                listMessage.append(link).append("\n");
            }
        }

        LOGGER.trace("Handle message list, chatId - {}", chatId);
        return new SendMessage(chatId, listMessage.toString());
    }
}
