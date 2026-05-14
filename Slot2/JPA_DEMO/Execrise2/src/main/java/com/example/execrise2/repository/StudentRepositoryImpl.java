package com.example.execrise2.repository;

import com.example.execrise2.dao.StudentDao;
import com.example.execrise2.entity.Student;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private StudentDao studentDAO;

    public StudentRepositoryImpl(String fileConfig) {
        this.studentDAO = new StudentDao(fileConfig);
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.getStudent();
    }

    @Override
    public void delete(int studentID) {
        studentDAO.deleted(studentID);
    }

    @Override
    public Student findById(int studentID) {
        return studentDAO.Fing(studentID);
    }

    @Override
    public void update(Student student) {
        studentDAO.upd(student);
    }
}
