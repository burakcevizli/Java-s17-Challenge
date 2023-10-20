package controller;


import dto.CourseResponse;
import dto.CoursesResponseFactory;
import entity.Course;
import entity.CourseGpa;
import exceptions.CourseValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {
    private List<Course> courses;
    private CourseGpa low;
    private CourseGpa medium;
    private CourseGpa hight;

    @PostConstruct
    public void init() {
        courses = new ArrayList<>();
    }

    @Autowired
    public CourseController(@Qualifier("lowCourseGpa") CourseGpa low,
                            @Qualifier("mediumCourseGpa") CourseGpa medium,
                            @Qualifier("hightCourseGpa")CourseGpa hight){
        this.low = low;
        this.medium=medium;
        this.hight=hight;
    }

    @GetMapping("/")
    public List<Course> getAll(){
        return courses;
    }

    @GetMapping("/{name}")
    public Course find(@PathVariable String name){
        Optional<Course> optionalCourse = courses.stream().filter(c -> c.getName().equals(name)).findFirst();
        if(optionalCourse.isPresent()){
            return optionalCourse.get();
        }
        return null;
    }

    @PostMapping("/")
    public CourseResponse save(@RequestBody Course course) {
        CourseValidation.isIdValid(course.getId());
        CourseValidation.checkCourseIsValid(course);
        CourseValidation.isDuplicateNameFound(courses, course.getName());
        courses.add(course);
        return CoursesResponseFactory.coursesResponse(course, low, medium, hight);
    }

}
