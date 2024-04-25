package com.kmj.hcbc;

import com.kmj.hcbc.model.Book;
import com.kmj.hcbc.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HcbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HcbcApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(BookRepository repo) {
        return args -> {
            repo.deleteAll(); // TODO: Quick hack to avoid tests from stepping on each other with constraint violations
            repo.save(new Book(1,"title1","author1","year1","ibsn1"));
        };
    }
}
