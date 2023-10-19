package org.example.server.abstraction.service;

import org.example.server.repository.Keyword;

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
