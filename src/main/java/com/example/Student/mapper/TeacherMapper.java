package com.example.Student.mapper;


import com.example.Student.dto.TeacherDto;
import com.example.Student.entity.Teacher;

public class TeacherMapper {

    public static TeacherDto mapToTeacherDto(Teacher teacher){
        return new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getAge(),
                teacher.getParentName()
        );
    }

    public static Teacher mapToTeacher(TeacherDto teacherDto){
        return new Teacher(
                teacherDto.getId(),
                teacherDto.getFirstName(),
                teacherDto.getLastName(),
                teacherDto.getAge(),
                teacherDto.getParentName()
        );
    }
}
