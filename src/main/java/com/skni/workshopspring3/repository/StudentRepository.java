package com.skni.workshopspring3.repository;

import com.skni.workshopspring3.model.CourseTypeEnum;
import com.skni.workshopspring3.model.GenderEnum;
import com.skni.workshopspring3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   List<Student> findAll();

   List<Student> findAllByGenderAndCourse_CourseType(GenderEnum gender, CourseTypeEnum course);

   List<Student> findAllByLastname(String lastname);

   @Query(
           value = "SELECT distinct s.* FROM student s WHERE LENGTH(s.firstname) < ?1 ",
            nativeQuery = true)
   List<Student> findAllByFirstnameLengthShorterThan(Integer length);

}
