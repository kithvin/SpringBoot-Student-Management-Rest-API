package com.example.Student.service.impl;

import com.example.Student.dto.TeacherDto;
import com.example.Student.entity.Teacher;
import com.example.Student.exception.ResourceNotFoundException;
import com.example.Student.repository.TeacherRepository;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private ModelMapper modelMapper;

    private TeacherRepository teacherRepository;


    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto,Teacher.class);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return modelMapper.map(savedTeacher,TeacherDto.class);

    }


    @Override
    public List<TeacherDto> getAllTeachers() {
         List<Teacher> teachers = teacherRepository.findAll();

        return teachers.stream().map((teacher) -> modelMapper.map(teacher,TeacherDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public TeacherDto getTeacherById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is Not Found :" + teacherId));
//        return TeacherMapper.mapToTeacherDto(teacher);
        return modelMapper.map(teacher,TeacherDto.class);
    }


    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto updatedTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is Not Found :" + teacherId));

       modelMapper.map(updatedTeacher,teacher);

        Teacher updatedTeacherObj = teacherRepository.save(teacher);
        return modelMapper.map(updatedTeacherObj,TeacherDto.class);
    }



    @Override
    public void deleteTeacher (Long teacherId){
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is Not Found :" + teacherId));
        teacherRepository.deleteById(teacherId);

    }

}

