package com.skni.workshopspring3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "version")
    private Integer version;

    @Column(name = "location")
    private String location;

    @Column(name = "course_type")
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Set<Student> students;

}
