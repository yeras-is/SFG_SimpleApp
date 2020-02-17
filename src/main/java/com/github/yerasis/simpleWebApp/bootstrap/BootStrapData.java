package com.github.yerasis.simpleWebApp.bootstrap;

import com.github.yerasis.simpleWebApp.domain.Address;
import com.github.yerasis.simpleWebApp.domain.Author;
import com.github.yerasis.simpleWebApp.domain.Book;
import com.github.yerasis.simpleWebApp.domain.Publisher;
import com.github.yerasis.simpleWebApp.repositories.AddressRepository;
import com.github.yerasis.simpleWebApp.repositories.AuthorRepository;
import com.github.yerasis.simpleWebApp.repositories.BookRepository;
import com.github.yerasis.simpleWebApp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, AddressRepository addressRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book tdd = new Book("TDD", "123123");
        eric.getBooks().add(tdd);
        tdd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(tdd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE DB", "123123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher nyt = new Publisher("New Yourk Times");
        Address mainAddress = new Address("1", "NY", "NYS", "010028", null);
        Address address = new Address("2", "CA", "CAS", "010040", null);
        addressRepository.save(mainAddress);
        addressRepository.save(address);


        nyt.getAddress().add(mainAddress);
        nyt.getAddress().add(address);

        publisherRepository.save(nyt);

        noEJB.setPublisher(nyt);
        tdd.setPublisher(nyt);
        nyt.getBooks().add(noEJB);
        nyt.getBooks().add(tdd);


        bookRepository.save(noEJB);

        System.out.println("Start in Bootstrap");

        System.out.println("Count of publishers:" + publisherRepository.count());
        System.out.println("Count of address:" + addressRepository.count());
        System.out.println("CountOfBooks:" + bookRepository.count());
        System.out.println("Count of books:" + nyt.getBooks().size());

    }

}
