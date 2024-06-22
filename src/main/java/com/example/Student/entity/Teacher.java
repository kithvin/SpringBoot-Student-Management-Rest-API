package com.example.Student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")


public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Long id;

    public String firstName;

    private String lastName;

    private int age;

    private String parentName;

}
