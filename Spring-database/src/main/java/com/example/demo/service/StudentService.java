package com.example.demo.service;

import com.example.demo.dto.Student;
import com.example.demo.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    List<Student> getpgstudents();
    List<Student> getMgstudents();
    List<Student> getredisstudents();
    List<Student> getStudent();

    void addpgStudent(Student student);
    void addMgstudent(Student student);
    void addredisStudent(Student student);
    void addStudent(Student student);

    void updatingStudent(Student student);
    void UpdatePgStudent(Student student);
    void UpdateMgStudent(Student student);
    void UpdateRedisStudent(Student student);

    void DeleteStudent(Integer id);
    void DeletePgStudent(Integer id);
    void DeleteMgStudent(Integer id);
    void DeleteRedisStudent(Integer id);
}
