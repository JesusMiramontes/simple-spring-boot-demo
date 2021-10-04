package com.miramontes.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(1L,"Jesus", "jesus@mail.com", LocalDate.of(1990,01,01), 31)
        );
    }
}
