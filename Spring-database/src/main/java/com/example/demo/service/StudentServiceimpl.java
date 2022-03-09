package com.example.demo.service;

import com.example.demo.dto.Student;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentMongoRepository;
import com.example.demo.repository.StudentRedisRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.Studentdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    Studentdb studentdb;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentMongoRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        for (StudentEntity student : studentRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        for (Student student : studentRedisRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        for (Student student : studentdb.getstudentList()) {

            Student student1=new Student();
            student1.setId(student.getId());
            student1.setBranch(student.getBranch());
            student1.setLname(student.getLname());
            student1.setPname(student.getPname());
            s.add(student1);
        }
        return s;
    }

    @Override
    public List<Student> getStudent() {

        return studentdb.getstudentList();
    }


    @Override
    public List<Student> getpgstudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        return s;
    }

    @Override
    public List<Student> getMgstudents() {
        List<Student> s = new ArrayList<>();
        for (StudentEntity student : studentMongoRepository.findAll()) {
            Student s1 = new Student();
            s1.setId(student.getId());
            s1.setPname(student.getPname());
            s1.setLname(student.getLname());
            s1.setBranch(student.getBranch());
            s.add(s1);
        }
        return s;
    }

    @Override
    public List<Student> getredisstudents() {
        return studentRedisRepository.findAll();
    }




    @Override
    public void updatingStudent(Student student) {
        for(Student stud:studentdb.getstudentList()){
            if(stud.getId()==student.getId()){

                stud.setPname(student.getPname());
                stud.setBranch(student.getBranch());
                stud.setLname(student.getLname());

            }
        }

    }

    @Override
    public void UpdatePgStudent(Student student) {

        for (StudentEntity studentEntity : studentRepository.findAll()) {
            if (student.getId() == studentEntity.getId()) {

                studentEntity.setPname(student.getPname());
                studentEntity.setLname(student.getLname());
                studentEntity.setBranch(student.getBranch());
                studentRepository.save(studentEntity);
            }
        }
    }

    @Override
    public void UpdateMgStudent(Student student) {

        for (StudentEntity studentEntity : studentMongoRepository.findAll()) {
            if (student.getId() == studentEntity.getId()) {

                studentEntity.setPname(student.getPname());
                studentEntity.setLname(student.getLname());
                studentEntity.setBranch(student.getBranch());
                studentMongoRepository.save(studentEntity);
            }
        }
    }

    @Override
    public void UpdateRedisStudent(Student student) {

        studentRedisRepository.updatingStudent(student);

    }

    @Override
    public void DeleteStudent(Integer id) {
        for(Student student:studentdb.getstudentList()){
            if(student.getId()==id){
                studentdb.delete(id);
                break;
            }
        }
    }



    @Override
    public void DeletePgStudent(Integer id){
        for(StudentEntity studentEntity:studentRepository.findAll()){
            if(studentEntity.id==id){
                studentRepository.delete(studentEntity);
            }
        }
    }

    @Override
    public void DeleteMgStudent(Integer id){
        for(StudentEntity studentEntity:studentMongoRepository.findAll()){
            if(studentEntity.id==id){
                studentMongoRepository.delete(studentEntity);
            }
        }
    }

    @Override
    public void DeleteRedisStudent(Integer id){
                studentRedisRepository.deleteOne(id);

        }






    @Override
    public void addStudent(Student student) {
        studentdb.add(student);

    }

    @Override
    public void addpgStudent(Student student) {
        StudentEntity se = new StudentEntity();
        se.setId(student.getId());
        se.setBranch(student.getBranch());
        se.setPname(student.getPname());
        se.setLname(student.getLname());
        studentRepository.save(new StudentEntity(se.getId(), se.getPname(), se.getLname(), se.getBranch()));
    }

    @Override
    public void addMgstudent(Student student) {
        StudentEntity se = new StudentEntity();
        se.setId(student.getId());
        se.setBranch(student.getBranch());
        se.setPname(student.getPname());
        se.setLname(student.getLname());
        studentMongoRepository.save(new StudentEntity(se.getId(), se.getPname(), se.getLname(), se.getBranch()));
    }

    @Override
    public void addredisStudent(Student student) {
        studentRedisRepository.addOne(student);

    }

}
