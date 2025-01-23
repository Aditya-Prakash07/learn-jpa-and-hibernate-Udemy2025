package com.aditya.springboot.learn_jpa_and_hibernate.course;

import com.aditya.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.aditya.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.aditya.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        int id = 1;
        repository.save(new Course(id, "learn Azure jpa", "in28minutes"));
        repository.save(new Course(++id, "learn Devops jpa", "in28minutes"));
        repository.save(new Course(++id, "learn SpringBoot jpa", "in28minutes"));
        repository.deleteById(1L);
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println();
        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println();
        System.out.println(repository.findByName("learn SpringBoot jpa"));
        System.out.println(repository.findByName("learn Devops jpa"));
    }
}
