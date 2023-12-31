package org.example.server.abstraction.serviceImpl;

import org.example.server.abstraction.service.KitchenService;
import org.example.server.repository.Kitchen;
import org.example.server.repository.KitchenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KitchenServiceImpl implements KitchenService {

    @Autowired
    KitchenRepo kitchenRepo;


    @Override
    public Kitchen getByName(String name) {
        return kitchenRepo.findByName(name);
    }
}