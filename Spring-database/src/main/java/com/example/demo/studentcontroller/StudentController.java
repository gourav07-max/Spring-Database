package com.example.demo.studentcontroller;

import com.example.demo.dto.Student;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/DISPLAY")
    public List<Student> getAllStudent(@RequestParam String db){



        if(db.equals("POST")){
            return studentService.getpgstudents();

        }
        else if(db.equals("MONGO")){
            return studentService.getMgstudents();
        }
        else if(db.equals("REDIS")){
            return studentService.getredisstudents();
        }
        else {
            return studentService.getAllStudents();
        }
    }

    /*@GetMapping("/Student/{id}")
    public Student getStudent(@PathVariable Integer id){
        return ss.getStudent(id);
    }*/

    @GetMapping("/LIST")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping("/ADD")
    public void addStudent(@RequestBody @Valid Student student,@RequestParam String db){
        if(db.equals("POST")){
             studentService.addpgStudent(student);

        }
        else if(db.equals("MONGO")){
             studentService.addMgstudent(student);
        }
        else if(db.equals("REDIS")){
            studentService.addredisStudent(student);
        }
        else {
            studentService.addStudent(student);
        }
    }

    @PutMapping("/UPDATE")
    public void putStudent(@RequestBody @Valid Student student,@RequestParam String i){
        if(i.equals("POST")){
            studentService.UpdatePgStudent(student);

        }
        else if(i.equals("MONGO")){
            studentService.UpdateMgStudent(student);
        }
        else if(i.equals("REDIS")){
            studentService.UpdateRedisStudent(student);
        }
        else {
            studentService.updatingStudent(student);
        }

    }

    @DeleteMapping("/DELETE")
    public void deleteStudent(@RequestBody Integer i,@RequestParam String db){

        if(db.equals("POST")){
            studentService.DeletePgStudent(i);

        }
        else if(db.equals("MONGO")){
            studentService.DeleteMgStudent(i);
        }
        else if(db.equals("REDIS")){
            studentService.DeleteRedisStudent(i);
        }
        else {
            studentService.DeleteStudent(i);
        }
    }
}
