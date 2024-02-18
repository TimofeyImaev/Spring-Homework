package edu.java.bot;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

public interface Command {
    String command();

    String description();

    SendMessage handle(Update update);

    default boolean supports(Update update) {
        return true;
    }

    default BotCommand toApiCommand() {
        return new BotCommand(command(), description());
    }
}
