package org.example.abstraction.service;

import org.example.repository.KeywordUser;
import org.example.repository.User;

import java.util.Random;

public interface KeywordUserService {

    void addPreference(AddPreferenceDto dto);

    record AddPreferenceDto(
            Long user_id,

            Long keyword_id
    ){
        public static KeywordUser toDbEntity(KeywordUserService.AddPreferenceDto dto){
            return new KeywordUser(
                    dto.user_id(),
                    dto.keyword_id()
            );
        }
    }
}
