package com.skni.workshopspring3.service;

import com.skni.workshopspring3.model.Course;
import com.skni.workshopspring3.model.CourseTypeEnum;
import com.skni.workshopspring3.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;

    public Course addCourse(String category, Integer version, String location, CourseTypeEnum courseType){
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
