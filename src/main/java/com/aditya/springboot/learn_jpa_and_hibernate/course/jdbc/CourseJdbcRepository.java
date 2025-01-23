package com.aditya.springboot.learn_jpa_and_hibernate.course.jdbc;
import com.aditya.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
  private  JdbcTemplate springJdbcTemplate;
  private static String INSERT_QUERY =
          //THIS THREE DOUBLE QUOTES IS CALLED A TEXT BLOCK AND IN HERE WE CAN TYPE WHATEVER QUERY WE WANT
          """ 
          insert into course (id, name, author) 
          values(?, ?, ?);
          
          """;
    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }
}
