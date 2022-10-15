package com.example.Api.Controller;
import com.example.Api.Entities.Student;
import com.example.Api.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping(value = "/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveStudents(@RequestBody Student student){
        studentRepository.save(student);
        return "Saved";
    }

    @PutMapping(value = "update/{Id}")
    public String UpdateStudent(@PathVariable int Id, @RequestBody Student student){
        Student updateStudent = studentRepository.findById(Id).get();

        updateStudent.setName(student.getName());
        updateStudent.setAge(student.getAge());

        return "Updated";
    }

    public String deleteStudent(@PathVariable int Id){

        Student deleteStudent = studentRepository.findById(Id).get();
        studentRepository.delete(deleteStudent);

        return "Deleted the Student with Id: " + Id;
    }
}
