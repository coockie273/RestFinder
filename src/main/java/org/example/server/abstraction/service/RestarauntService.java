package org.example.server.abstraction.service;

import org.example.server.repository.Restaraunt;

import java.util.List;

public interface RestarauntService {
    Restaraunt getByName(String Name);
    RestarauntDto getById();

    List<Object> getRestarauntsForLocation(String criteriaX1,
                                               String criteriaX2,
                                               String criteriaY1,
                                               String criteriaY2);

    List<Object> getRestarauntsForKitchen(String criteria);
    List<Object> getRestarauntsForKeyword(String criteria);


    record RestarauntDto(
            Long id,
            String name,
            int coordinate_x,
            int coordinate_y


    ){
        public static RestarauntDto fromDbEntity(Restaraunt restaraunt){
            return new RestarauntDto(
                    restaraunt.getId(),
                    restaraunt.getName(),
                    restaraunt.getCoordinate_x(),
                    restaraunt.getCoordinate_y()
            );
        }
    }

}
