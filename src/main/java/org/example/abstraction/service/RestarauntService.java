package org.example.abstraction.service;

import org.example.repository.Restaraunt;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
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
        public static RestarauntService.RestarauntDto fromDbEntity(Restaraunt restaraunt){
            return new RestarauntService.RestarauntDto(
                    restaraunt.getId(),
                    restaraunt.getName(),
                    restaraunt.getCoordinate_x(),
                    restaraunt.getCoordinate_y()
            );
        }
    }

}
