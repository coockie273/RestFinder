package org.example.abstraction.serviceImpl;

import org.example.abstraction.service.UserKeywordPreferenceService;
import org.example.repository.UserKeywordPreferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserKeywordPreferenceServiceImpl implements UserKeywordPreferenceService {
    @Autowired
    UserKeywordPreferenceRepo keywordUserRepo;

    @Override
    public void deleteKeywordPreference(Long u_id, Long k_id) {
        keywordUserRepo.deleteByIds(u_id, k_id);
    }

    public void addKeywordPreference(AddPreferenceDto dto){
        keywordUserRepo.save(AddPreferenceDto.toDbEntity(dto));
    }
}
