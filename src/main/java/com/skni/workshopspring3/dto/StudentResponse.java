package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.model.Course;
import com.skni.workshopspring3.model.GenderEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentResponse {

    private String firstname;

    private String lastname;

    private LocalDate birthdate;

    private GenderEnum gender;

    private Course course;
}
