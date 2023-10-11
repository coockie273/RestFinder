package org.example.controller;

import org.example.abstraction.service.*;
import org.example.repository.Keyword;
import org.example.repository.UserRestaraunt;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
            Integer coordinate_x1,
            Integer coordinate_x2,
            Integer coordinate_y1,
            Integer coordinate_y2,
            String kitchen,
            String keyword
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

    @GetMapping("/requestRandomRestaraunt")
    RestarauntService.RestarauntDto requestRandomRestaraunt() {
        return restarauntService.getById();
    }

    @PostMapping("/RequestRestaraunt")
    void requestRestaraunt(@RequestBody RestarauntRequestDto dto, @CookieValue(name = "userId") Long u_id) {


        String locationX = " r.coordinate_x";
        boolean lx = false;
        if ((Objects.equals(dto.coordinate_x1(), null)) && (Objects.equals(dto.coordinate_x2(), null))) {
            if (!(Objects.equals(dto.coordinate_x1(), "skip") || Objects.equals(dto.coordinate_x2(), "skip"))) {
                locationX += " > " + dto.coordinate_x1().toString();
                locationX += "AND r.coordinate_x < " + dto.coordinate_x1().toString();
                lx = true;
            }
        }

        String locationY = " r.coordinate_y";
        boolean ly = false;
        if ((Objects.equals(dto.coordinate_y1(), null)) && (Objects.equals(dto.coordinate_y2(), null))) {
            if (!(Objects.equals(dto.coordinate_y1(), "skip") || Objects.equals(dto.coordinate_y2(), "skip"))) {
                locationY += " > " + dto.coordinate_y1().toString();
                locationY += "AND r.coordinate_y < " + dto.coordinate_x1().toString();
                ly = true;
            }
        }

        String kitchen = " kt.name ";
        boolean kt = false;
        if (Objects.equals(dto.kitchen(), null)) {
            if (!(Objects.equals(dto.kitchen(), "skip"))) {
                kitchen += "= " + dto.kitchen;
                kt = true;
            }
        } else {
            List<String> kitchens = userService.showKitchenPreference(u_id);
            for (String k: kitchens) {
                kitchen += " = " + k;
                if (kitchens.indexOf(k) != kitchens.size() - 1){
                    kitchen += " AND kt.name";
                }

            }
            if (kitchens.size() != 0) {
                kt = true;
            }
        }

        String keyword = " k.name ";
        boolean k = false;
        if (Objects.equals(dto.keyword(), null)) {
            if (!(Objects.equals(dto.kitchen(), "skip"))) {
                keyword += "= " + dto.keyword;
                k = true;
            }
        } else {
            List<String> keywords = userService.showKeywordPreference(u_id);
            for (String key: keywords) {
                kitchen += " = " + key;
                if (keywords.indexOf(key) != keywords.size() - 1){
                    keyword += " AND k.name";
                }

            }
            if (keywords.size() != 0) {
                k = true;
            }
        }
        boolean first = true;
        String criteria = "WHERE ";
        if (lx) {
            first = false;
            criteria += locationX;
        }

        if (ly) {
            if (first) {
                first = false;
                criteria += locationY;
            } else {
                criteria += "AND " + locationY;
            }
        }

        if (kt) {
            if (first) {
                first = false;
                criteria += kitchen;
            } else {
                criteria += "AND " + kitchen;
            }
        }

        if (k) {
            if (first) {
                first = false;
                criteria += keyword;
            } else {
                criteria += "AND " + keyword;
            }
        }
        if (! first){
            criteria = "";
        }
        restarauntService.getRestaraunts(criteria);
    }

}
