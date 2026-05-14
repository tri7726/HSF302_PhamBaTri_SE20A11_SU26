package com.example.execrise2.entity;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Entity
@Table(name = "Students")

public class Student {

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)

private  int id;
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "marks")
    private int marks;

    public Student() {
    }

    public Student(String firstName, String lastName, int marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    public Student(int id, String firstName, String lastName, int marks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }




    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMarks() {
        return marks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
