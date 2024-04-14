package ru.hogwarts.School.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.School.model.Faculty;
import ru.hogwarts.School.service.interfaces.FacultyService;

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
    public Faculty getFaculty(@PathVariable Long id) {
        return service.getFaculty(id);
    }

    @PutMapping
    public Faculty updatefaculty(@RequestBody Faculty faculty) {
        return service.updateFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public Faculty deletefaculty(@PathVariable Long id) {
        return service.deleteFaculty(id);
    }

    @GetMapping("/sortedByColor/{color}")
    public List<Faculty> sortedByColor(@PathVariable String color) {
        return service.sortByColor(color);
    }
}
