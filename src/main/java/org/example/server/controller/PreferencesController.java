package org.example.server.controller;

import org.example.server.abstraction.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public record PreferencesController(
        KeywordService keywordService,
        UserKeywordPreferenceService userKeywordPreferenceService,

        KitchenService kitchenService,
        UserKitchenPreferenceService userKitchenPreferenceService,

        RestarauntService restarauntService,

        UserRestarauntService userRestarauntService,

        UserService userService

) {

    record PreferencesDto(
            String preference
    ){}

    record RestarauntDto(
            String restaraunt
    ){}

    record RestarauntRequestDto(
            Integer x1,
            Integer x2,
            Integer y1,
            Integer y2,
            List<String> kitchens,
            List<String> keywords
    ){}

    record LocationDto(
            Integer x1,
            Integer x2,
            Integer y1,
            Integer y2
    ){

    }
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

    @GetMapping("/requestRandomRestaraunt")
    RestarauntService.RestarauntDto requestRandomRestaraunt() {
        return restarauntService.getById();
    }

    @PostMapping("/RequestRestarauntForLocation")
    List<Object> requestRestarauntForLocation(@RequestBody LocationDto dto) {
        return restarauntService.getRestarauntsForLocation(dto.x1().toString(), dto.x2().toString(), dto.y1().toString(), dto.y2().toString());
    }

    @GetMapping("/RequestRestarauntForKitchen/{name}")
    List<Object> requestRestarauntForKitchen(@PathVariable String name) {
        return restarauntService.getRestarauntsForKitchen(name);
    }

    @GetMapping("/RequestRestarauntForKeyword/{name}")
    List<Object> requestRestarauntForKeyword(@PathVariable String name) {
        return restarauntService.getRestarauntsForKeyword(name);
    }

}
