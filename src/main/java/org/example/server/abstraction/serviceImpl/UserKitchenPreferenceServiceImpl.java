package org.example.server.abstraction.serviceImpl;

import org.example.server.abstraction.service.UserKitchenPreferenceService;
import org.example.server.repository.UserKitchenPreferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserKitchenPreferenceServiceImpl implements UserKitchenPreferenceService {
    @Autowired
    UserKitchenPreferenceRepo keywordUserRepo;

    @Override
    public void deleteKitchenPreference(Long u_id, Long k_id) {
        keywordUserRepo.deleteByIds(u_id, k_id);
    }
    public void addKitchenPreference(AddPreferenceDto dto){
        keywordUserRepo.save(AddPreferenceDto.toDbEntity(dto));
    }
}
