package com.example.Student.controller;
import com.example.Student.dto.StudentDto;
import com.example.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    // Create Student RESTAPI

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    // Get All Students RESTAPI

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);


    }

    // Get Student by ID RESTAPI
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long studentId){
        StudentDto studentDto = studentService.getStudentById(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);

    }

    // Delete Student By ID REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully!.");
}

    // Update Student By ID REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,
                                                    @RequestBody StudentDto updatedStudent ){
        StudentDto studentDto = studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(studentDto);
}



}
