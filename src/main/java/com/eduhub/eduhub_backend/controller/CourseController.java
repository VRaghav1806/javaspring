package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.CourseService;
import com.eduhub.eduhub_backend.component.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    StudentService studentService;
    public CourseController(CourseService courseService,StudentService studentService){
        this.courseService=courseService;
        this.studentService=studentService;
    }

    @GetMapping("get-course")
    public String getcourse(){
        return courseService.getCourse();
    }
    @GetMapping("get-student")
    public String getstudent(){
        return studentService.getStudent();
    }
}