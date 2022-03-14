package com.example.bookmanager.service;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import com.example.bookmanager.repository.AuthorRepository;
import com.example.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void putBookAndAuthor(){
        Book book = new Book();
        book.setName("JPA 시작하기");
        bookRepository.save(book);

        try {
            authorService.putAuthor();
        } catch (RuntimeException e){

        }

        throw new RuntimeException("오류가 발생하였습니다. transaction은 어떻게 될까요?");

//        Author author = new Author();
//        author.setName("martin");
//        authorRepository.save(author);
//        throw new RuntimeException("오류가 나서 DB Commit이 발생하지 않습니다.");
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id){
        System.out.println(">>> "+bookRepository.findById(id));
        System.out.println(">>> "+bookRepository.findAll());

        System.out.println(">>> "+bookRepository.findById(id));
        System.out.println(">>> "+bookRepository.findAll());

    }

    @Transactional
    public List<Book> getAll(){
        List<Book> books = bookRepository.findAll();

        books.forEach(System.out::println);

        return books;
    }

}

