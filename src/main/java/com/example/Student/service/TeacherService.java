package com.example.Student.service;

import com.example.Student.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    TeacherDto createTeacher (TeacherDto teacherDto);

    List <TeacherDto> getAllTeachers ();

    TeacherDto getTeacherById(Long teacherId);

    TeacherDto updateTeacher (Long teacherId, TeacherDto teacherDto);

    void deleteTeacher (Long teacherId);
}
