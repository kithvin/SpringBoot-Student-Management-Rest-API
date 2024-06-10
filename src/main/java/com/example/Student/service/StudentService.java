package com.example.Student.service;

import com.example.Student.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent (StudentDto studentDto);

    List <StudentDto> getAllStudents();
}
