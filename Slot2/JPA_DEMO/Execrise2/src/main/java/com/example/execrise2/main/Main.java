package com.example.execrise2.main;

import com.example.execrise2.entity.Student;
import com.example.execrise2.service.StudentService;
import com.example.execrise2.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fileName = "JPAs"; // Tên của persistence unit hoặc config
        StudentService studentService = new StudentServiceImpl(fileName);
        
        // Tạo đối tượng Student mới để test (dùng 3 tham số như ảnh mẫu)
        Student student = new Student("Lam", "Nguyen", 9);
        
        // Lưu vào Database
        studentService.save(student);
        
        System.out.println("Đã lưu sinh viên thành công!");
    }
}
