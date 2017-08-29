package com.manos.bootstrap;

import com.manos.model.Author;
import com.manos.model.Book;
import com.manos.repositories.AuthorRepository;
import com.manos.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Cartman");
        Book ddd = new Book("Domain driven desith", "1234", "Harper collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rob = new Author("Rob", "Stark");
        Book noEJB = new Book("J2EE Development without EJB", "2345", "Worx");
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);
        authorRepository.save(rob);
        bookRepository.save(noEJB);
    }
}
