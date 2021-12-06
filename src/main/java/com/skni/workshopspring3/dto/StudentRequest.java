package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.model.Course;
import com.skni.workshopspring3.model.GenderEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentRequest {

    private Long id;

    @NotBlank(message = "Pole nie może być puste")
    private String firstname;

    @NotBlank(message = "Pole nie może być puste")
    private String lastname;

    @NotNull
    @PastOrPresent(message = "Data urodzenia nie może być z przyszłości")
    private LocalDate birthdate;

    @NotNull
    private GenderEnum gender;

    private Course course;
}
