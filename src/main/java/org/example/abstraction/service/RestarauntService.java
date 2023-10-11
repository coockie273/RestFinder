package org.example.abstraction.service;

import org.example.repository.Restaraunt;

public interface RestarauntService {
    Restaraunt getByName(String Name);

    record RestarauntDto(
            Long id,
            String name

    ){
        public static RestarauntService.RestarauntDto fromDbEntity(Restaraunt keyword){
            return new RestarauntService.RestarauntDto(
                    keyword.getId(),
                    keyword.getName()
            );
        }
    }
}
