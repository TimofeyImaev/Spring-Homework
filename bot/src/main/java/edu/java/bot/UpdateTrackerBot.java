package edu.java.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.commands.AvailableCommands;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UpdateTrackerBot implements Bot {
    private final TelegramBot bot;

    public UpdateTrackerBot() {
        this.bot = new TelegramBot("6672905446:AAGkuAl9UFiP5mnnjp1zOOHKHjyuM8XbuPo");
        bot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        for (Update update : updates) {
            String request = update.message().text();
            SendMessage sendMessage = null;

            for (var command : AvailableCommands.values()) {
                if (command.getCommand().command().equals(request.split(" ")[0])) {
                    sendMessage = command.getCommand().handle(update);
                }
            }

            if (sendMessage == null) {
                sendMessage = AvailableCommands.HELLO.getCommand().handle(update);
            }

            bot.execute(sendMessage);
        }

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    @Override
    public void start() {
        bot.setUpdatesListener(this);
    }

    @Override
    public void close() {
        bot.removeGetUpdatesListener();
    }
}
