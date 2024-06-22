package com.example.Student.service.impl;

import com.example.Student.dto.TeacherDto;
import com.example.Student.entity.Teacher;
import com.example.Student.exception.ResourceNotFoundException;
import com.example.Student.mapper.TeacherMapper;
import com.example.Student.repository.TeacherRepository;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;


    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = TeacherMapper.mapToTeacher(teacherDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.mapToTeacherDto(savedTeacher);

    }


    @Override
    public List<TeacherDto> getAllTeachers() {
         List<Teacher> teachers = teacherRepository.findAll();

        return teachers.stream().map((teacher) -> TeacherMapper.mapToTeacherDto(teacher))
                .collect(Collectors.toList());
    }


    @Override
    public TeacherDto getTeacherById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is Not Found :" + teacherId));
        return TeacherMapper.mapToTeacherDto(teacher);
    }


    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto updatedTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is Not Found :" + teacherId));

        teacher.setFirstName(updatedTeacher.getFirstName());
        teacher.setLastName(updatedTeacher.getLastName());
        teacher.setAge(updatedTeacher.getAge());
        teacher.setParentName(updatedTeacher.getParentName());

        Teacher updatedTeacherObj = teacherRepository.save(teacher);
        return TeacherMapper.mapToTeacherDto(teacher);
    }



    @Override
    public void deleteTeacher (Long teacherId){
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is Not Found :" + teacherId));
        teacherRepository.deleteById(teacherId);

    }

}

