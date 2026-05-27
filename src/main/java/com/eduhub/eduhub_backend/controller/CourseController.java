package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.component.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping
    public ResponseEntity<List<Course>> getAll(){

        return ResponseEntity.ok(courseService.getAllCourses());
    }


    @GetMapping("/{courseCode}")
    public ResponseEntity<Course> getCourse(
            @PathVariable String courseCode){

        return ResponseEntity.ok(courseService.getCourse(courseCode));
    }

    @GetMapping("/search")
    public ResponseEntity<Course> getByParam(
            @RequestParam String code){

        return ResponseEntity.ok(courseService.getCourse(code));
    }


    @PostMapping("/create")
    public ResponseEntity<Course> create(

            @RequestBody Course course){

        return ResponseEntity.ok(courseService.addCourse(course));
    }


    @PutMapping("/{courseCode}")
    public ResponseEntity<Course> update(

            @PathVariable String courseCode,

            @RequestBody Course course){

        return ResponseEntity.ok(courseService.updateCourse(courseCode, course));
    }

    @DeleteMapping("/{courseCode}")
    public ResponseEntity<String> delete(

            @PathVariable String courseCode){

        return ResponseEntity.ok(courseService.deleteCourse(courseCode));
    }

}