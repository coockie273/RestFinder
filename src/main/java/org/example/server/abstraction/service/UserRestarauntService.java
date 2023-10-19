package org.example.server.abstraction.service;

import org.example.server.repository.UserRestaraunt;

public interface UserRestarauntService {

    void addVisitedRestaraunt(AddRestarauntDto dto);

    void deleteVisitedRestaraunt(Long u_id, Long r_id);

    record AddRestarauntDto(
            Long user_id,

            Long restaraunt_id
    ){
        public static UserRestaraunt toDbEntity(AddRestarauntDto dto){
            return new UserRestaraunt(
                    null,
                    dto.user_id(),
                    dto.restaraunt_id()
            );
        }
    }
}