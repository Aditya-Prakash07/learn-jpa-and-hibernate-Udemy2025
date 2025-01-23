package com.aditya.springboot.learn_jpa_and_hibernate.course.springdatajpa;
import com.aditya.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

}
