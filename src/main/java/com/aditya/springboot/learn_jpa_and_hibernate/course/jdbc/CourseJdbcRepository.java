package com.aditya.springboot.learn_jpa_and_hibernate.course.jdbc;
import com.aditya.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
// Using jpa we can directly map our entity class to database and no need to write sql queries
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
    private static String DELETE_QUERY =
            //THIS THREE DOUBLE QUOTES IS CALLED A TEXT BLOCK AND IN HERE WE CAN TYPE WHATEVER QUERY WE WANT
            """
                 DELETE FROM course WHERE id = ?;
            """;
    private static String  SELECT_QUERY =
            //THIS THREE DOUBLE QUOTES IS CALLED A TEXT BLOCK AND IN HERE WE CAN TYPE WHATEVER QUERY WE WANT
            """
                SELECT * FROM COURSE WHERE id = ?;
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
    public  Course findById(long id){
        //ResultSet -> Bean => Row mapper ------>
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }
}
