package org.example.abstraction.serviceImpl;

import org.example.abstraction.service.UserRestarauntService;
import org.example.repository.UserRestarauntRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRestarauntServiceImpl implements UserRestarauntService {
    @Autowired
    UserRestarauntRepo userRestarauntRepo;

    @Override
    public void addVisitedRestaraunt(AddRestarauntDto dto){
        userRestarauntRepo.save(AddRestarauntDto.toDbEntity(dto));
    }
    @Override
    public void deleteVisitedRestaraunt(Long u_id, Long r_id){
        userRestarauntRepo.deleteByIds(u_id, r_id);
    }
}