package org.example.server.abstraction.service;

import org.example.server.repository.Kitchen;

public interface KitchenService {

    Kitchen getByName(String Name);

    record KitchenDto(
            Long id,
            String name

    ){
        public static KitchenDto fromDbEntity(Kitchen keyword){
            return new KitchenDto(
                    keyword.getId(),
                    keyword.getName()
            );
        }
    }
}
