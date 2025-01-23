package com.aditya.springboot.learn_jpa_and_hibernate.course;

import com.aditya.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.aditya.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        int id = 1;
        repository.insert(new Course(id, "learn Azure jpa", "in28minutes"));
        repository.insert(new Course(++id, "learn Devops jpa", "in28minutes"));
        repository.insert(new Course(++id, "learn SpringBoot jpa", "in28minutes"));
        repository.deleteById(1);
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));

    }
}
