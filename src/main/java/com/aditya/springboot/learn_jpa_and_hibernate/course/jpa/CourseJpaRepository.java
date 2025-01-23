package com.aditya.springboot.learn_jpa_and_hibernate.course.jpa;

import com.aditya.springboot.learn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
   // @Autowired ---> this also works but below is the best pactice
    @PersistenceContext
    private EntityManager entityManager;
    public void insert(Course course){
        entityManager.merge(course);
    }
    public Course findById(long id){
        Course course = entityManager.find(Course.class, id);
        return course;
    }
    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }
}
