package ru.hogwarts.School.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.School.model.Student;
import ru.hogwarts.School.service.interfaces.StudentService;

import java.util.List;

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
    public Student getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
    /* Для примера
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        return service.getStudent(id) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.deleteStudent(id));
    }*/

    @GetMapping("/sortedByAge/{age}")
    public List<Student> sortedByAge(@PathVariable int age) {
        return service.sortByAge(age);
    }
}
