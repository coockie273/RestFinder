package org.example.abstraction.service;

import org.example.repository.UserRestaraunt;

public interface UserRestarauntService {

    void addVisitedRestaraunt(AddRestarauntDto dto);

    void deleteVisitedRestaraunt(Long u_id, Long r_id);

    record AddRestarauntDto(
            Long user_id,

            Long restaraunt_id
    ){
        public static UserRestaraunt toDbEntity(UserRestarauntService.AddRestarauntDto dto){
            return new UserRestaraunt(
                    null,
                    dto.user_id(),
                    dto.restaraunt_id()
            );
        }
    }
}