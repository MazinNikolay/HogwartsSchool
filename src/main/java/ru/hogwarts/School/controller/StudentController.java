package ru.hogwarts.School.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.School.model.Student;
import ru.hogwarts.School.service.interfaces.StudentService;

import java.util.List;

@RestController
@RequestMapping("student")
@Tag(name = "API для работы со студентами")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Создание студента")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение студента")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @PutMapping
    @Operation(summary = "Обновление студента")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление студента")
    public Student deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
    /* Для примера
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        return service.getStudent(id) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.deleteStudent(id));
    }*/

    @GetMapping("/sortedByAge/{age}")
    @Operation(summary = "Получение студентов по возрасту")
    public List<Student> sortedByAge(@PathVariable int age) {
        return service.sortByAge(age);
    }
}
