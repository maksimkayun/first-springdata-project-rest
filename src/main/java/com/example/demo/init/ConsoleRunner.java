package com.example.demo.init;

import com.example.demo.models.Major;
import com.example.demo.models.Student;
import com.example.demo.services.MajorService;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;

    @Override
    public void run(String... args) throws Exception {
        majorService.register(new Major("IT"));
        majorService.register(new Major("Business"));

        Major major = majorService.findMajor(2);

        Student student = new Student("Petr", major);
        studentService.register(student);
    }
}
