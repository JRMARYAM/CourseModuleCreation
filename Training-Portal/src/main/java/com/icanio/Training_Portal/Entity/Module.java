package com.icanio.Training_Portal.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module id")
    private int id;
    private int courseid;

    private String tittle;
    private  String topic;
    private  String assignment;
    private String assignmentLink;

}
