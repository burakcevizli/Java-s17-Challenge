package com.workintech.AlexGrade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private int coefficient;
    private String note;
}
