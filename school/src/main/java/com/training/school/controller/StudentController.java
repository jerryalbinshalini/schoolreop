package com.training.school.controller;

import com.training.school.model.Student;
import com.training.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/student")

public class StudentController {


    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String studentName) {
        try {
            List<Student> students = new ArrayList<Student>();

            if (studentName == null)
                studentRepository.findAll().forEach(students::add);
            else
                studentRepository.findByStudentNameContaining(studentName).forEach(students::add);

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student ouputstudent = studentRepository
                    .save(new Student(student.getStudentName(), student.getBloodGroup(), student.getCourse(), student.getEmailId()));
            return new ResponseEntity<>(ouputstudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student newstudentdata) {
        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            Student oldstudentdata = studentData.get();
            oldstudentdata.setStudentName(newstudentdata.getStudentName());
            oldstudentdata.setBloodGroup(newstudentdata.getBloodGroup());
            oldstudentdata.setCourse(newstudentdata.getCourse());
            oldstudentdata.setEmailId(newstudentdata.getEmailId());
            return new ResponseEntity<>(studentRepository.save(oldstudentdata), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students")
    public ResponseEntity<HttpStatus> deleteAllStudents() {
        try {
            studentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/students/course")
    public ResponseEntity<List<Student>> findByCourse() {
        try {
            Object course;
            List<Student> students = studentRepository.findByCourse("BE");

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

