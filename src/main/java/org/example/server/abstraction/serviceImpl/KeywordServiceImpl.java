package org.example.server.abstraction.serviceImpl;

import org.example.server.abstraction.service.KeywordService;
import org.example.server.repository.Keyword;
import org.example.server.repository.KeywordRepo;
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