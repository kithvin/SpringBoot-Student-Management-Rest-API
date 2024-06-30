package com.example.Student.service.impl;


import com.example.Student.dto.StudentDto;
import com.example.Student.dto.TeacherDto;
import com.example.Student.entity.Student;
import com.example.Student.exception.ResourceNotFoundException;
import com.example.Student.repository.StudentRepository;
import com.example.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ModelMapper modelMapper;

    private StudentRepository studentRepository;



    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto,Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);

    }


    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map((student) -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student is not found : " + studentId));
//        return StudentMapper.mapToStudentDto(student);
        return modelMapper.map(student,StudentDto.class);
    }


    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student is not found : " + studentId));

        modelMapper.map(updatedStudent,student);

        Student updatedStudentObj = studentRepository.save(student);
        return modelMapper.map(updatedStudentObj, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long studentId) {Student student = studentRepository.findById(studentId)
            .orElseThrow(()-> new ResourceNotFoundException("Student is not found : " + studentId));
        studentRepository.deleteById(studentId);

    }


}
