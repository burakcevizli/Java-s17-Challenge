package com.workintech.AlexGrade.dto;

import com.workintech.AlexGrade.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private Course course;
    private double totalGpa;
}
