package com.miramontes.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student jesus = new Student("Jesus", "jesus@mail.com", LocalDate.of(1990,01,01));
            Student alex = new Student("Alex", "alex@mail.com", LocalDate.of(2001,01,01));

            repository.saveAll(List.of(jesus, alex));
        };
    }
}
