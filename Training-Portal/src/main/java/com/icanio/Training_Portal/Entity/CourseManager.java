package com.icanio.Training_Portal.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

@Entity
@Data
@Table(name = "Coursemanager")
public class CourseManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String managerName;
    private String managerEmail;



}
