package com.example.Student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {

    private  Long id;

    private String firstName;

    private String lastName;

    private int age;

    private String parentName;


}
