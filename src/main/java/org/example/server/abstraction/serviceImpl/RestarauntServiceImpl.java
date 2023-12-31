package org.example.server.abstraction.serviceImpl;

import org.example.server.abstraction.service.RestarauntService;
import org.example.server.repository.Restaraunt;
import org.example.server.repository.RestarauntRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Object> getRestarauntsForLocation(String criteriaX1,
                                               String criteriaX2,
                                               String criteriaY1,
                                               String criteriaY2) {
        return restarauntRepo.getRestarauntsForLocation(criteriaX1,
                                                        criteriaX2,
                                                        criteriaY1,
                                                        criteriaY2);

    }
    @Override
    public List<Object> getRestarauntsForKitchen(String criteria) {
        return restarauntRepo.getRestarauntsForKitchen(criteria);
    }
    @Override
    public List<Object> getRestarauntsForKeyword(String criteria) {
        return restarauntRepo.getRestarauntsForKeyword(criteria);
    }


}