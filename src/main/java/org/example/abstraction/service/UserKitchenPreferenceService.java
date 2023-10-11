package org.example.abstraction.service;

import org.example.repository.UserKitchenPreference;

public interface UserKitchenPreferenceService {

    void addKitchenPreference(AddPreferenceDto dto);

    void deleteKitchenPreference(Long u_id, Long k_id);

    record AddPreferenceDto(
            Long user_id,

            Long keyword_id
    ){
        public static UserKitchenPreference toDbEntity(UserKitchenPreferenceService.AddPreferenceDto dto){
            return new UserKitchenPreference(
                    null,
                    dto.user_id(),
                    dto.keyword_id()
            );
        }
    }
}
