package com.icanio.Training_Portal.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String CourseTitle;
@ManyToOne
@JoinColumn(name = "managerId")
public CourseManager courseManager;
}
