package com.student.demo.service;

import com.student.demo.dto.StudentRequestDto;
import com.student.demo.dto.StudentResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    StudentResponseDto save(StudentRequestDto studentRequestDto);
    List<StudentResponseDto> findAll();
    StudentResponseDto findById(Integer student_id);
    StudentResponseDto update(Integer student_id, Double cgpa, LocalDate enrollmentDate, Boolean isInternational);

    StudentResponseDto deleteById(Integer student_id);
}
