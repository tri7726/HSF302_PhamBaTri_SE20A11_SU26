package com.example.execrise2.service;

import com.example.execrise2.entity.Student;
import com.example.execrise2.repository.StudentRepository;
import com.example.execrise2.repository.StudentRepositoryImpl;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository iStudentRepo;

    public StudentServiceImpl(String fileName) {
        this.iStudentRepo = new StudentRepositoryImpl(fileName);
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public void delete(int studentID) {
        iStudentRepo.delete(studentID);
    }

    @Override
    public Student findById(int studentID) {
        return iStudentRepo.findById(studentID);
    }

    @Override
    public void update(Student student) {
        iStudentRepo.update(student);
    }
}
