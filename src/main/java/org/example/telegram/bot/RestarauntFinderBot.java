package org.example.telegram.bot;

import jakarta.servlet.http.Cookie;
import org.example.server.abstraction.service.RestarauntService;
import org.example.server.abstraction.service.UserService;
import org.example.server.repository.Restaraunt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class RestarauntFinderBot extends TelegramLongPollingBot {

    private static final Logger LOG = LoggerFactory.getLogger(RestarauntFinderBot.class);

    @Autowired
    RestarauntService restarauntService;

    Long user_id;

    @Autowired
    UserService userService;

    private static final String HELP = "/help";
    private static final String SIGN_IN = "/signin";
    private static final String SIGN_UP = "/signup";

    private static final String SHOW_PREFERENCE = "/show_preference";

    private static final String ADD_PREFERENCE = "/add_preference";

    private static final String DELETE_PREFERENCE = "/delete_preference";

    private static final String ADD_RESTARAUNT_TO_VISITED = "/add_restaurant_to_visited";

    private static final String DELETE_RESTARAUNT_TO_VISITED = "/delete_restaurant_to_visited";

    private static final String SHOW_VISITED_RESTARAUNTS = "/add_restaurant_to_visited";

    private static final String REQUEST_RANDOM_RESTARAUNT = "/random_restaurant";

    private static final String REQUEST_RESTARAUNT_KITCHEN = "/request_restaraunt_by_kitchen";

    private static final String REQUEST_RESTARAUNT_KEYWORD = "/request_restaraunt_by_keyword";


    public RestarauntFinderBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        var messages = update.getMessage().getText().split(" ");
        var chatId = update.getMessage().getChatId();
        switch (messages[0]) {
            case REQUEST_RANDOM_RESTARAUNT -> getRestaraunt(chatId);
            case SIGN_IN -> signIn(chatId, messages);
        }
    }

    @Override
    public String getBotUsername() {
        return "hsai_restaurant_finder_bot";
    }

    public void getRestaraunt(Long chatId) {
        RestarauntService.RestarauntDto restaraunt = restarauntService.getById();
        sendMessage(chatId, "You can visit restaurant %s at location (%s, %s) "
                .formatted(restaraunt.name(), restaraunt.coordinate_x(), restaraunt.coordinate_y()));
    }

    public void getRestarauntKitchen(Long chatId, String kitchen) {
        RestarauntService.RestarauntDto restaraunt = restarauntService.getById();
        sendMessage(chatId, "You can visit restaurant %s".formatted(restaraunt.name()));
    }

    public void signIn(Long chatId, String[] messages) {
        UserService.UserDto user = userService.signIn(new UserService.SignInDto(messages[1], messages[2]));
        if (user != null) {
            sendMessage(chatId, "Welcome %s %s".formatted(user.first_name(), user.second_name()));
        }

        sendMessage(chatId, "Пользователь не найден");
    }


    private void sendMessage(Long chatId, String text) {
        var chatIdStr = String.valueOf(chatId);
        var sendMessage = new SendMessage(chatIdStr, text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            LOG.error("Sending message error", e);
        }
    }
}
