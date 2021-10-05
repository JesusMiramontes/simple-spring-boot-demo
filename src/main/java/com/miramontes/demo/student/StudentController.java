package com.miramontes.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudents();
    }

    @PostMapping
    public void insertStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping
    public void deleteStudentByEmail(@RequestBody Student student){
        studentService.deleteStudentByEmail(student);
    }

    @DeleteMapping("{studentID}")
    public void deleteStudentById(@PathVariable("studentID") Long id){
        studentService.deleteStudentById(id);
    }
}
