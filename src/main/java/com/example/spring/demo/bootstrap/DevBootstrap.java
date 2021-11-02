package com.example.spring.demo.bootstrap;

import com.example.spring.demo.model.Author;
import com.example.spring.demo.model.Book;
import com.example.spring.demo.repositories.AuthorRepository;
import com.example.spring.demo.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        // MMM
        Author mmm = new Author("MMM", "SM");
        Book bbb = new Book("Crime of History", "1234", "Qanun");
        mmm.getBooks().add(bbb);
        bbb.getAuthors().add(mmm);

        authorRepository.save(mmm);
        bookRepository.save(bbb);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        initData();
    }
}
