package com.example.bookmanager.service;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

//    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.NEVER)
    @Transactional(propagation = Propagation.NESTED)
    public void putAuthor(){
        Author author = new Author();
        author.setName("martin");
        authorRepository.save(author);

//        throw new RuntimeException("오류가 발생하였습니다. transaction은 어떻게 될까요?");
    }
}
