package org.example.telegram.bot;

import jakarta.servlet.http.Cookie;
import org.example.server.abstraction.service.*;
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

    @Autowired
    UserService userService;

    @Autowired
    KeywordService keywordService;
    @Autowired
    UserKeywordPreferenceService userKeywordPreferenceService;

    @Autowired
    KitchenService kitchenService;
    @Autowired
    UserKitchenPreferenceService userKitchenPreferenceService;

    @Autowired
    UserRestarauntService userRestarauntService;

    private static final String START = "/start";

    private static final String SHOW_PREFERENCE = "/show_preference";

    private static final String ADD_PREFERENCE = "/add_preference";

    private static final String DELETE_PREFERENCE = "/delete_preference";

    private static final String ADD_RESTARAUNT_TO_VISITED = "/add_restaurant_to_visited";

    private static final String DELETE_RESTARAUNT_TO_VISITED = "/delete_restaurant_from_visited";

    private static final String SHOW_VISITED_RESTARAUNTS = "/visited_list";

    private static final String REQUEST_RANDOM_RESTARAUNT = "/random_restaurant";
    


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
            case START -> start(chatId, update.getMessage().getChat().getUserName());
            case REQUEST_RANDOM_RESTARAUNT -> getRestaraunt(chatId);
            case SHOW_PREFERENCE -> showPreference(chatId);
            case ADD_PREFERENCE -> addPreference(chatId, messages[1]);
            case DELETE_PREFERENCE -> deletePreference(chatId, messages[1]);
            case ADD_RESTARAUNT_TO_VISITED -> addRestarauntToVisited(chatId, messages);
            case SHOW_VISITED_RESTARAUNTS -> showVisitedList(chatId);
            case DELETE_RESTARAUNT_TO_VISITED -> deleteRestarauntFromVisited(chatId, messages);
        }
    }

    @Override
    public String getBotUsername() {
        return "hsai_restaurant_finder_bot";
    }

    public void start(Long chatId, String username) {
        userService.addUser(new UserService.AddUserDto(chatId, "", "", username, ""));
        sendMessage(chatId, "Welcome to Restaraunt finder bot, %s".formatted(username));
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

    public void showPreference(Long chatId) {
        List<String> preferenceKeywords = userService.showKeywordPreference(chatId);
        List<String> preferenceKitchens = userService.showKitchenPreference(chatId);
        String response;
        if ( preferenceKeywords.size() == 0 && preferenceKitchens.size() == 0){
            sendMessage(chatId, "You don't have preferences");
        } else {
            response = "Your preferences: \n";
            for (String key: preferenceKeywords) {
                response += key + ", ";
            }

            for (String key: preferenceKitchens) {
                response += key;
                if (key != preferenceKitchens.get(preferenceKitchens.size() - 1)) {
                    response += ", ";
                }
            }
            sendMessage(chatId, response);
        }
    }

    public void addPreference(Long chatId, String name) {
        try {
            Long keyword_id = keywordService.getByName(name).getId();
            userKeywordPreferenceService.addKeywordPreference(new UserKeywordPreferenceService.
                    AddPreferenceDto(chatId, keyword_id));
            sendMessage(chatId, "Success");
        } catch (NullPointerException e1) {
            try {
                Long kitchen_id = kitchenService.getByName(name).getId();
                userKitchenPreferenceService.addKitchenPreference(new UserKitchenPreferenceService.
                        AddPreferenceDto(chatId, kitchen_id));
                sendMessage(chatId, "Success");
            } catch (NullPointerException e2) {
                sendMessage(chatId, "There is no such preference in the database");
            }
        }
    }

    public void deletePreference(Long chatId, String name) {
        try {
            Long keyword_id = keywordService.getByName(name).getId();
            userKeywordPreferenceService.deleteKeywordPreference(chatId, keyword_id);
            sendMessage(chatId, "Success");
        } catch (NullPointerException e1) {
            try {
                Long kitchen_id = kitchenService.getByName(name).getId();
                userKitchenPreferenceService.deleteKitchenPreference(chatId, kitchen_id);
                sendMessage(chatId, "Success");
            } catch (NullPointerException e2) {
                sendMessage(chatId, "You are not having such preference");
            }
        }
    }

    void addRestarauntToVisited(Long chatId, String[] messages) {
        String restaraunt = "";
        for (int i = 1; i < messages.length; i++){
            restaraunt += messages[i];
            if (i != messages.length - 1) {
                restaraunt += " ";
            }
        }
        try {
            Long r_id = restarauntService.getByName(restaraunt).getId();
            userRestarauntService.addVisitedRestaraunt(new UserRestarauntService.AddRestarauntDto(chatId, r_id));
            sendMessage(chatId, "Success");
        } catch(NullPointerException e ) {
            sendMessage(chatId, "There is no such restaurant in the database");
        }
    }

    void showVisitedList(Long chatId) {
        List<String> restaraunts = userService.showVisitedRestaraunts(chatId);
        if (restaraunts.size() == 0) {
            sendMessage(chatId, "Visited list is empty");
            return;
        }
        String response = "";
        for (String r: restaraunts) {
            response += r;
            if (r != restaraunts.get(restaraunts.size() - 1)) {
                response += ", ";
            }
        }
        sendMessage(chatId, response);
    }

    void deleteRestarauntFromVisited(Long chatId, String[] messages) {
        String restaraunt = "";
        for (int i = 1; i < messages.length; i++){
            restaraunt += messages[i];
            if (i != messages.length - 1) {
                restaraunt += " ";
            }
        }
        try {
            Long r_id = restarauntService.getByName(restaraunt).getId();
            userRestarauntService.deleteVisitedRestaraunt(chatId, r_id);
            sendMessage(chatId, "Success");
        } catch(NullPointerException e ) {
            sendMessage(chatId, "You are not having such restaurant in visited list");
        }
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
