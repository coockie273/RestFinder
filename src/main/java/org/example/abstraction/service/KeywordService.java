package org.example.abstraction.service;

import org.example.repository.Keyword;
import org.example.repository.User;

public interface KeywordService {

    Keyword getByName(String Name);

    record KeywordDto(
            Long id,
            String name

    ){
        public static KeywordDto fromDbEntity(Keyword keyword){
            return new KeywordDto(
                    keyword.getId(),
                    keyword.getName()
            );
        }
    }
}
