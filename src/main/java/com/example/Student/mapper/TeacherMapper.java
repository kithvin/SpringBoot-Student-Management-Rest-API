package com.example.Student.mapper;


import com.example.Student.dto.TeacherDto;
import com.example.Student.entity.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherMapper {

    @Autowired
    private ModelMapper modelMapper;


    public  TeacherDto mapToTeacherDto(Teacher teacher){
        return modelMapper.map(teacher,TeacherDto.class);
    }

    public Teacher mapToTeacher(TeacherDto teacherDto){
        return modelMapper.map(teacherDto,Teacher.class);

    }
}
