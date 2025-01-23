package com.aditya.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.aditya.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;
    @Override


    public void run(String... args) throws Exception {
        int id = 1;
        repository.insert(new Course(id, "learn Azure", "in28minutes"));
        repository.insert(new Course(++id, "learn Devops", "in28minutes"));
        repository.insert(new Course(++id, "learn SpringBoot", "in28minutes"));

    }
}
