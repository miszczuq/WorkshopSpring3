package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.model.CourseTypeEnum;
import com.skni.workshopspring3.model.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
public class CourseRequest {

    private Long id;

    @NotBlank(message = "Pole nie może być puste")
    private String category;

    @NotNull
    @Min(value = 0, message = "Musi to być liczba całkowita większa od zera")
    private Integer version;

    @NotBlank(message = "Pole nie może być puste")
    private String location;

    @NotNull
    private CourseTypeEnum courseType;

    private Set<Student> students;
}
