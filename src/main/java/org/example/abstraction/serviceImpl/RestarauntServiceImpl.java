package org.example.abstraction.serviceImpl;

import org.example.abstraction.service.KeywordService;
import org.example.abstraction.service.RestarauntService;
import org.example.repository.Keyword;
import org.example.repository.KeywordRepo;
import org.example.repository.Restaraunt;
import org.example.repository.RestarauntRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestarauntServiceImpl implements RestarauntService {

    @Autowired
    RestarauntRepo restarauntRepo;

    @Override
    public Restaraunt getByName(String name) {
        return restarauntRepo.findByName(name);
    }
}