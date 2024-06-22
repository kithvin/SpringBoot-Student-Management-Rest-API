package com.example.Student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeacherDto {

    private Long id;

    public String firstName;

    private String lastName;

    private int age;

    private String parentName;
}