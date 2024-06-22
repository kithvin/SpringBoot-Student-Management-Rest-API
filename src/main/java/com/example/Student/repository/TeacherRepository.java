package com.example.Student.repository;

import com.example.Student.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository <Teacher,Long> {
}
