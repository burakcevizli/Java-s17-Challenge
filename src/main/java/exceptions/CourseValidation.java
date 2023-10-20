package exceptions;

import entity.Course;
import org.springframework.http.HttpStatus;

import java.awt.*;
import java.util.Optional;
import java.util.List;

public class CourseValidation {
    public static void checkCourseIsValid(Course course){
        if((course.getCredit() < 0 || course.getCredit() > 4) ||
                (course.getName() == null || course.getName().isEmpty())){
            throw new CourseException("Course credentials are not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdValid(int id){
        if(id <= 0){
            throw new CourseException("Id is not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isDuplicateNameFound(List<Course> courses, String name){
        Optional<Course> courseOptional = courses.stream()
                .filter(course -> course.getName().equals(name)).findFirst();
        if(courseOptional.isPresent()){
            throw new CourseException("Course with given name already exist: " + name,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
