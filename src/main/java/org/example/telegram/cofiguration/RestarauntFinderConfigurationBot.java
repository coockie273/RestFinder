package org.example.telegram.cofiguration;


import com.squareup.okhttp.OkHttpClient;
import org.example.telegram.bot.RestarauntFinderBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class RestarauntFinderConfigurationBot {

    @Bean
    public TelegramBotsApi telegramBotsApi(RestarauntFinderBot bot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(bot);
        return api;
    }

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }
}
