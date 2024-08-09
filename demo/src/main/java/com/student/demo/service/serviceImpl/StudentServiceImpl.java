package com.student.demo.service.serviceImpl;

import com.student.demo.domain.Student;
import com.student.demo.dto.StudentRequestDto;
import com.student.demo.dto.StudentResponseDto;
import com.student.demo.exeptionhandler.ResourceNotFoundException;
import com.student.demo.mapper.StudentRequestDto_TO_Student;
import com.student.demo.repository.StudentRepository;
import com.student.demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponseDto save(StudentRequestDto studentRequestDto) {
        Student student = StudentRequestDto_TO_Student.requestDto_To_domain(studentRequestDto);

//               student.setStudentNumber(studentRequestDto.getStudentNumber());
//               student.setFirstName(studentRequestDto.getFirstName());
//               student.setLastName(studentRequestDto.getLastName());
//               student.setMiddleName(studentRequestDto.getMiddleName());
//               student.setCgpa(studentRequestDto.getCgpa());
//                student.setEnrollmentDate(studentRequestDto.getEnrollmentDate());
//                student.setIsInternational(studentRequestDto.getIsInternational());

        studentRepository.save(student);

        StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
//                studentResponseDto.setStudentId(student.getStudent_id());
//                studentResponseDto.setStudentNumber(student.getStudentNumber());
//                studentResponseDto.setFirstName(student.getFirstName());
//                studentResponseDto.setLastName(student.getLastName());
//                studentResponseDto.setMiddleName(student.getMiddleName());
//                studentResponseDto.setCgpa(student.getCgpa());
//                studentResponseDto.setEnrollmentDate(student.getEnrollmentDate());
//                studentResponseDto.setIsInternational(student.getIsInternational());

        return studentResponseDto;

    }

    public List<StudentResponseDto> findAll() {
        List<Student> students = studentRepository.findAll();

        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();

        for(Student student : students) {
            StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);

//                 studentResponseDto.setStudentId(student.getStudent_id());
//                 studentResponseDto.setStudentNumber(student.getStudentNumber());
//                 studentResponseDto.setFirstName(student.getFirstName());
//                 studentResponseDto.setLastName(student.getLastName());
//                 studentResponseDto.setMiddleName(student.getMiddleName());
//                 studentResponseDto.setCgpa(student.getCgpa());
//                 studentResponseDto.setEnrollmentDate(student.getEnrollmentDate());
//                 studentResponseDto.setIsInternational(student.getIsInternational());

            studentResponseDtos.add(studentResponseDto);
        }
        return studentResponseDtos;
    }

    public StudentResponseDto findById(Integer student_id){
        Student student = studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("studentId is not Found"));

        StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);

//             studentResponseDto.setStudentId(student.getStudent_id());
//             studentResponseDto.setStudentNumber(student.getStudentNumber());
//             studentResponseDto.setFirstName(student.getFirstName());
//             studentResponseDto.setLastName(student.getLastName());
//             studentResponseDto.setMiddleName(student.getMiddleName());
//             studentResponseDto.setCgpa(student.getCgpa());
//             studentResponseDto.setEnrollmentDate(student.getEnrollmentDate());
//             studentResponseDto.setIsInternational(student.getIsInternational());

        return studentResponseDto;
    }

    public StudentResponseDto update(Integer student_id, Double cgpa, LocalDate enrollmentDate, Boolean isInternational) {
        Student student = studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("studentId is not Found"));

        student.setCgpa(cgpa);
        student.setEnrollmentDate(enrollmentDate);
        student.setIsInternational(isInternational);

        studentRepository.save(student);

        StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
//             studentResponseDto.setStudentId(student.getStudent_id());
//             studentResponseDto.setStudentNumber(student.getStudentNumber());
//             studentResponseDto.setFirstName(student.getFirstName());
//             studentResponseDto.setLastName(student.getLastName());
//             studentResponseDto.setMiddleName(student.getMiddleName());
//             studentResponseDto.setCgpa(cgpa);
//             studentResponseDto.setEnrollmentDate(enrollmentDate);
//             studentResponseDto.setIsInternational(isInternational);

        return studentResponseDto;
    }

    public StudentResponseDto deleteById(Integer student_id) {
        Student student = studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("studentId is not Found"));
        studentRepository.deleteById(student_id);

        StudentResponseDto studentResponseDto = StudentRequestDto_TO_Student.domain_TO_responseDto(student);
//             studentResponseDto.setStudentId(student.getStudent_id());
//             studentResponseDto.setStudentNumber(student.getStudentNumber());
//             studentResponseDto.setFirstName(student.getFirstName());
//             studentResponseDto.setLastName(student.getLastName());
//             studentResponseDto.setMiddleName(student.getMiddleName());
//             studentResponseDto.setCgpa(student.getCgpa());
//             studentResponseDto.setEnrollmentDate(student.getEnrollmentDate());
//             studentResponseDto.setIsInternational(student.getIsInternational());

        return studentResponseDto;
    }

}