package org.example.server.abstraction.service;

import org.example.server.repository.UserKitchenPreference;

public interface UserKitchenPreferenceService {

    void addKitchenPreference(AddPreferenceDto dto);

    void deleteKitchenPreference(Long u_id, Long k_id);

    record AddPreferenceDto(
            Long user_id,

            Long keyword_id
    ){
        public static UserKitchenPreference toDbEntity(AddPreferenceDto dto){
            return new UserKitchenPreference(
                    null,
                    dto.user_id(),
                    dto.keyword_id()
            );
        }
    }
}
