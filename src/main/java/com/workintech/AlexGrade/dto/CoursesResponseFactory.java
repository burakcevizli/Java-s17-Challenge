package com.workintech.AlexGrade.dto;

import com.workintech.AlexGrade.entity.*;


public class CoursesResponseFactory {
    public static CourseResponse coursesResponse(Course course, CourseGpa low,
                                                 CourseGpa medium, CourseGpa hight) {
        if (course.getCredit() <= 2) {
            return new CourseResponse(course, course.getGrade().getCoefficient()
                    * course.getCredit() * ((LowCourseGpa) low).getGpa());
        } else if (course.getCredit() == 3) {
            return new CourseResponse(course, course.getGrade().getCoefficient() * course.getCredit()
                    * ((MediumCourseGpa)medium).getGpa());
        }else if(course.getCredit() == 4){
            return new CourseResponse(course,
                    course.getCredit() * course.getGrade().getCoefficient()
                            * ((HighCourseGpa)hight).getGpa());
        }
        return null;
    }
}
