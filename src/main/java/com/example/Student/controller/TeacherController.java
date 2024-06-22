package com.example.Student.controller;

import com.example.Student.dto.StudentDto;
import com.example.Student.dto.TeacherDto;
import com.example.Student.repository.TeacherRepository;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/teacher")

public class TeacherController {

    private TeacherService teacherService;

    // Create Teacher by ID

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherDto student = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    // Get Teacher by ID
    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllStudents() {
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);


    }

    // Get Teacher by ID

    @GetMapping("{id}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable("id") Long teacherId) {
        TeacherDto teacherDto = teacherService.getTeacherById(teacherId);
        return new ResponseEntity<>(teacherDto, HttpStatus.OK);
    }

    // Update Teacher By ID

    @PutMapping("{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable  ("id") Long teacherId,
                                                    @RequestBody TeacherDto updatedTeacher){
        TeacherDto teacherDto = teacherService.updateTeacher(teacherId, updatedTeacher);
        return ResponseEntity.ok(teacherDto);


}

    // Delete Teacher by ID

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted successfully!.");

    }
}




