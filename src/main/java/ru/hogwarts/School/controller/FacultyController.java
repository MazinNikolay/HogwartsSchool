package ru.hogwarts.School.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.School.model.Faculty;
import ru.hogwarts.School.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return service.createFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        return service.getFaculty(id) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.getFaculty(id));
    }

    @PutMapping
    public ResponseEntity<Faculty> updatefaculty(@RequestBody Faculty faculty) {
        return service.getFaculty(faculty.getId()) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.updateFaculty(faculty));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deletefaculty(@PathVariable Long id) {
        return service.getFaculty(id) == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.deleteFaculty(id));
    }

    @GetMapping("/sortedByColor/{color}")
    public List<Faculty> sortedByColor(@PathVariable String color) {
        return service.sortByColor(color);
    }
}
