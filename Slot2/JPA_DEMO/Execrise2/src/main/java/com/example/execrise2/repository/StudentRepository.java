package com.example.execrise2.repository;

import com.example.execrise2.entity.Student;
import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    void save(Student student);
    void delete(int studentID);
    Student findById(int studentID);
    void update(Student student);
}
