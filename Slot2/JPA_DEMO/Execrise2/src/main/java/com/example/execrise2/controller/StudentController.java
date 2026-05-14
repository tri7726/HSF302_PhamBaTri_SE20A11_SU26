package com.example.execrise2.controller;

import com.example.execrise2.entity.Student;
import com.example.execrise2.service.StudentService;
import com.example.execrise2.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // Khởi tạo service với tên persistence-unit "JPAs" giống như bạn đã làm
    private final StudentService studentService = new StudentServiceImpl("JPAs");

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentService.findAll();
        
        // Nếu database đang trống (hoặc trả về null), tự động thêm 10 học sinh mẫu cho bạn dễ nhìn
        if (students == null || students.isEmpty()) {
            studentService.save(new Student("Lâm", "Nguyễn", 9));
            studentService.save(new Student("Trí", "Phạm", 10));
            studentService.save(new Student("Hoa", "Lê", 8));
            studentService.save(new Student("Tuấn", "Trần", 7));
            studentService.save(new Student("Mai", "Vũ", 9));
            studentService.save(new Student("Hùng", "Đặng", 6));
            studentService.save(new Student("Lan", "Bùi", 8));
            studentService.save(new Student("Minh", "Hồ", 10));
            studentService.save(new Student("Thảo", "Đỗ", 7));
            studentService.save(new Student("Khang", "Ngô", 9));
            students = studentService.findAll(); // Lấy lại danh sách sau khi thêm
        }
        
        return students;
    }
}
