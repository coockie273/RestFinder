package org.example.abstraction.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.abstraction.service.KitchenService;
import org.example.repository.Kitchen;
import org.example.repository.KitchenRepo;
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