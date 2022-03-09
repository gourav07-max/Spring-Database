package com.example.demo.repository;

import com.example.demo.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Studentdb {
  private List<Student> studentList=new ArrayList<>();
    public List<Student> getstudentList() {
        if(studentList.size() ==0) {
            Student st1=new Student(1,"Gourav","Rudrawar","CSE");
            Student st2=new Student(2,"gpr","rwar","MECH");
            Student st3=new Student(3,"ppr","rao","EEE");

            studentList.add(st1);
            studentList.add(st2);
            studentList.add(st3);
        }
        return studentList;
    }

    public void add(Student s){
        studentList.add(s);
    }

    public void delete(Integer i){
        for(Student student :studentList ){
            if(student.getId() == i){
                studentList.remove(student);
                break;
            }
        }
    }
}
