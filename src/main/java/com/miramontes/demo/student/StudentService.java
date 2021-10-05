package com.miramontes.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        if (findByEmail(student.getEmail()).isPresent())
            throw new IllegalStateException("email taken");

        studentRepository.save(student);
    }

    public void deleteStudentByEmail(Student student){
        Optional<Student> optionalStudent = findByEmail(student.getEmail());
        if(!optionalStudent.isPresent())
            throw new IllegalStateException("User doesn't exists");

        studentRepository.delete(optionalStudent.get());
    }

    public Optional<Student> findByEmail(String email){
        return studentRepository.findByEmail(email);
    }
}
