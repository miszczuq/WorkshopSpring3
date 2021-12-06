package com.skni.workshopspring3.service;

import com.skni.workshopspring3.dto.CourseRequest;
import com.skni.workshopspring3.dto.CourseResponse;
import com.skni.workshopspring3.dto.CourseRequest;
import com.skni.workshopspring3.dto.CourseResponse;
import com.skni.workshopspring3.model.Course;
import com.skni.workshopspring3.model.CourseTypeEnum;
import com.skni.workshopspring3.model.Course;
import com.skni.workshopspring3.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(o -> modelMapper.map(o, CourseResponse.class))
                .collect(Collectors.toList());
    }

    public Optional<CourseResponse> getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(o -> modelMapper.map(o, CourseResponse.class));
    }

    public Optional<CourseResponse> addCourse(CourseRequest courseRequest) {
        return Optional.of(modelMapper.map(courseRequest, Course.class))
                .map(courseRepository::save)
                .map(o -> modelMapper.map(o, CourseResponse.class));

    }

    public Optional<CourseResponse> updateCourse(Long courseId, CourseRequest courseRequest) {
        return courseRepository.findById(courseId)
                .map(o -> toEntityWithId(courseRequest, o))
                .map(courseRepository::save)
                .map(o -> modelMapper.map(o, CourseResponse.class));
    }

    private Course toEntityWithId(CourseRequest productDto, Course course) {
        Course entity = modelMapper.map(productDto, Course.class);
        entity.setId(course.getId());
        return entity;
    }

    public Optional<CourseResponse> deleteCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .map(this::deleteById)
                .map(o -> modelMapper.map(o, CourseResponse.class));
    }

    private Course deleteById(Course course) {
        courseRepository.deleteById(course.getId());
        return course;
    }


    public Course addCourse(String category, Integer version, String location, CourseTypeEnum courseType) {
        Course course = Course.builder()
                .category(category)
                .version(version)
                .location(location)
                .courseType(courseType)
                .build();
        courseRepository.save(course);

        return course;
    }
}
