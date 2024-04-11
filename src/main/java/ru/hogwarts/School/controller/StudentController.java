package ru.hogwarts.School.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.School.model.Student;
import ru.hogwarts.School.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return service.getStudent(id) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.getStudent(id));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return service.getStudent(student.getId()) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.updateStudent(student.getId(), student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        return service.getStudent(id) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.deleteStudent(id));
    }
}
