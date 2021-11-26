package com.skni.workshopspring3.service;

import com.skni.workshopspring3.model.Course;
import com.skni.workshopspring3.model.CourseTypeEnum;
import com.skni.workshopspring3.model.GenderEnum;
import com.skni.workshopspring3.model.Student;
import com.skni.workshopspring3.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public Student addStudent(String firstname, String lastname, LocalDate birthdate, GenderEnum gender, Course course){
        Student student =  Student.builder()
                .firstname(firstname)
                .lastname(lastname)
                .birthdate(birthdate)
                .gender(gender)
                .course(course)
                .build();

        studentRepository.save(student);

        return student;
    }

    public List<Student> findAllByLastName(String lastName){
        return studentRepository.findAllByLastname(lastName);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentByGenderAndByCourseType(GenderEnum genderEnum, CourseTypeEnum courseTypeEnum){
        return studentRepository.findAllByGenderAndCourse_CourseType(genderEnum,courseTypeEnum);
    }

    public Student deleteStudentById(Long studentId){
        Student deletedStudent = studentRepository.findById(studentId).get();
        studentRepository.deleteById(studentId);
        return deletedStudent;
    }
}
