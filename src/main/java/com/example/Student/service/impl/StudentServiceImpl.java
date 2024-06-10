package com.example.Student.service.impl;


import com.example.Student.dto.StudentDto;
import com.example.Student.entity.Student;
import com.example.Student.exception.ResourceNotFoundException;
import com.example.Student.mapper.StudentMapper;
import com.example.Student.repository.StudentRepository;
import com.example.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;


    /**
     * @param studentDto
     * @return
     */
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);

    }

    /**
     * @return
     */
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    /**
     * @param studentId
     * @return
     */
    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student is not found : " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * @param studentId
     * @param studentDto
     * @return
     */
    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        return null;
    }

    /**
     * @param studentId
     */
    @Override
    public void deleteStudent(Long studentId) {

    }
}
