package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.model.CourseTypeEnum;
import com.skni.workshopspring3.model.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class CourseResponse {
    private String category;

    private Integer version;

    private String location;

    private CourseTypeEnum courseType;

    private Set<Student> students;
}
