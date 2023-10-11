package org.example.abstraction.service;

import org.example.repository.Kitchen;

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
