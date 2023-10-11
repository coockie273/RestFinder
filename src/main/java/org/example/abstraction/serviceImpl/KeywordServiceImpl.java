package org.example.abstraction.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.abstraction.service.KeywordService;
import org.example.repository.Keyword;
import org.example.repository.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    KeywordRepo keywordRepo;

    @Override
    public Keyword getByName(String name) {
        return keywordRepo.findByName(name);
    }
}