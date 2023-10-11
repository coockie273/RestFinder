package org.example.abstraction.service;

import org.example.repository.UserKeywordPreference;

public interface UserKeywordPreferenceService {

    void addKeywordPreference(AddPreferenceDto dto);

    void deleteKeywordPreference(Long u_id, Long k_id);

    record AddPreferenceDto(
            Long user_id,

            Long keyword_id
    ){
        public static UserKeywordPreference toDbEntity(UserKeywordPreferenceService.AddPreferenceDto dto){
            return new UserKeywordPreference(
                    null,
                    dto.user_id(),
                    dto.keyword_id()
            );
        }
    }
}
