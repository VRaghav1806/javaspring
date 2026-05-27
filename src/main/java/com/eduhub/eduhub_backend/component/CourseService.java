package com.eduhub.eduhub_backend.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseService {

    List<Course> courses = new ArrayList<>();

    public CourseService() {

        courses.add(new Course("CS101","Java",4));
        courses.add(new Course("CS102","Spring",3));
        courses.add(new Course("CS103","Database",4));
        courses.add(new Course("CS104","Networking",3));
        courses.add(new Course("CS105","OS",4));
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourse(String code) {

        for(Course c:courses){
            if(c.getCourseCode().equalsIgnoreCase(code)){
                return c;
            }
        }

        return null;
    }

    public Course addCourse(Course course){
        courses.add(course);
        return course;
    }

    public Course updateCourse(
            String code,
            Course updatedCourse){

        for(Course c:courses){

            if(c.getCourseCode()
                    .equalsIgnoreCase(code)){

                c.setSubjectName(
                        updatedCourse.getSubjectName());

                c.setCredits(
                        updatedCourse.getCredits());

                return c;
            }
        }

        return null;
    }

    public String deleteCourse(String code){

        for(Course c:courses){

            if(c.getCourseCode()
                    .equalsIgnoreCase(code)){

                courses.remove(c);

                return "Deleted";
            }
        }

        return "Course Not Found";
    }

}