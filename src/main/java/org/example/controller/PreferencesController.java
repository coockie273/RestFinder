package org.example.controller;

import org.example.abstraction.service.*;
import org.example.repository.Keyword;
import org.example.repository.UserRestaraunt;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public record PreferencesController(
        KeywordService keywordService,
        UserKeywordPreferenceService userKeywordPreferenceService,

        KitchenService kitchenService,
        UserKitchenPreferenceService userKitchenPreferenceService,

        RestarauntService restarauntService,

        UserRestarauntService userRestarauntService

) {

    record PreferencesDto(
            String preference
    ){}

    record RestarauntDto(
            String restaraunt
    ){}
    @PostMapping("/addKeywordPreference")
    void addKeywordPreference(@RequestBody PreferencesDto dto, @CookieValue(name = "userId") Long user_id) {

        Long keyword_id = keywordService.getByName(dto.preference()).getId();
        userKeywordPreferenceService.addKeywordPreference(new UserKeywordPreferenceService.AddPreferenceDto(user_id, keyword_id));
    }

    @GetMapping("/deleteKeywordPreference/{name}")
    void deleteKeywordPreference(@PathVariable String name, @CookieValue(name = "userId") Long u_id) {
        Long k_id = keywordService.getByName(name).getId();
        userKeywordPreferenceService.deleteKeywordPreference(u_id, k_id);
    }

    @PostMapping("/addKitchenPreference")
    void addKitchenPreference(@RequestBody PreferencesDto dto, @CookieValue(name = "userId") Long user_id) {

        Long kitchen_id = kitchenService.getByName(dto.preference()).getId();
        userKitchenPreferenceService.addKitchenPreference(new UserKitchenPreferenceService.AddPreferenceDto(user_id, kitchen_id));
    }

    @GetMapping("/deleteKitchenPreference/{name}")
    void deleteKitchenPreference(@PathVariable String name, @CookieValue(name = "userId") Long u_id) {
        Long k_id = kitchenService.getByName(name).getId();
        userKeywordPreferenceService.deleteKeywordPreference(u_id, k_id);
    }

    @PostMapping("/addVisitedRestaraunt")
    void addVisitedRestaraunt(@RequestBody RestarauntDto dto, @CookieValue(name = "userId") Long user_id) {

        Long r_id = restarauntService.getByName(dto.restaraunt()).getId();
        userRestarauntService.addVisitedRestaraunt(new UserRestarauntService.AddRestarauntDto(user_id, r_id));
    }

    @PostMapping("/deleteRestarauntFromVisited")
    void deleteRestarauntFromVisited(@RequestBody RestarauntDto dto, @CookieValue(name = "userId") Long u_id) {
        Long r_id = restarauntService.getByName(dto.restaraunt()).getId();
        userRestarauntService.deleteVisitedRestaraunt(u_id, r_id);
    }

}
