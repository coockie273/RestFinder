package org.example.abstraction.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.abstraction.service.KeywordService;
import org.example.abstraction.service.RestarauntService;
import org.example.abstraction.service.UserService;
import org.example.repository.Keyword;
import org.example.repository.KeywordRepo;
import org.example.repository.Restaraunt;
import org.example.repository.RestarauntRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class RestarauntServiceImpl implements RestarauntService {

    @Autowired
    RestarauntRepo restarauntRepo;

    @Override
    public Restaraunt getByName(String name) {
        return restarauntRepo.findByName(name);
    }
    @Override
    public RestarauntDto getById() {
        return RestarauntDto.fromDbEntity((restarauntRepo.findById(new Random().nextLong(1,20)).get()));
    }

    @Override
    public List<RestarauntDto> getRestaraunts(String criteria) {
        return restarauntRepo.getRestaraunts(criteria);
    }


}