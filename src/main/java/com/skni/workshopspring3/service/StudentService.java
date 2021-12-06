package com.skni.workshopspring3.service;

import com.skni.workshopspring3.dto.StudentRequest;
import com.skni.workshopspring3.dto.StudentResponse;
import com.skni.workshopspring3.model.Course;
import com.skni.workshopspring3.model.CourseTypeEnum;
import com.skni.workshopspring3.model.GenderEnum;
import com.skni.workshopspring3.model.Student;
import com.skni.workshopspring3.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map( o -> modelMapper.map(o, StudentResponse.class))
                .collect(Collectors.toList());
    }

    public Optional<StudentResponse> getStudentById(Long id){
        return studentRepository.findById(id)
                .map(o -> modelMapper.map(o,StudentResponse.class));
    }

    public Student addStudent(String firstname, String lastname, LocalDate birthdate, GenderEnum gender, Course course) {
        Student student = Student.builder()
                .firstname(firstname)
                .lastname(lastname)
                .birthdate(birthdate)
                .gender(gender)
                .course(course)
                .build();

        studentRepository.save(student);

        return student;
    }

    public Optional<StudentResponse> addStudent(StudentRequest studentRequest) {
        return Optional.of(modelMapper.map(studentRequest, Student.class))
                .map(studentRepository::save)
                .map(o -> modelMapper.map(o, StudentResponse.class));

    }

    public Optional<StudentResponse> updateStudent(Long studentId, StudentRequest studentRequest){
        return studentRepository.findById(studentId)
                .map(o -> toEntityWithId(studentRequest, o))
                .map(studentRepository::save)
                .map(o -> modelMapper.map(o,StudentResponse.class));
    }

    private Student toEntityWithId(StudentRequest productDto, Student student) {
        Student entity = modelMapper.map(productDto, Student.class);
        entity.setId(student.getId());
        return entity;
    }

    public Optional<StudentResponse> deleteStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(this::deleteById)
                .map(o -> modelMapper.map(o, StudentResponse.class));
    }

    private Student deleteById(Student student) {
        studentRepository.deleteById(student.getId());
        return student;
    }

    public List<Student> findAllByLastName(String lastName) {
        return studentRepository.findAllByLastname(lastName);
    }



    public List<Student> getStudentByGenderAndByCourseType(GenderEnum genderEnum, CourseTypeEnum courseTypeEnum) {
        return studentRepository.findAllByGenderAndCourse_CourseType(genderEnum, courseTypeEnum);
    }



    public List<Student> getStudentsByFirstnameLengthShorterThan(Integer length) {
        return studentRepository.findAllByFirstnameLengthShorterThan(length);
    }
}
