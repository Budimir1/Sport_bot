package ru.relex.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {
//    @Value("${bot.name")
//    private String botName;
//    @Value("${bot.token}")
//    private String botToken;
//private static final Logger log = Logger.getLogger(String.valueOf(TelegramBot.class));

    @Override
    public void onUpdateReceived(Update update) {
    var originalMessage = update.getMessage();
        System.out.println(originalMessage.getText());
    }
    @Override
    public String getBotToken() {
        return "7169679445:AAHVltB-x1nM40d1FNZHEn39kH_RdefbN6A";
    }

    @Override
    public String getBotUsername() {
        return "Gym12_sport_bot";
    }
}
