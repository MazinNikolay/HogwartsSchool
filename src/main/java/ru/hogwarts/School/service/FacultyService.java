package ru.hogwarts.School.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.School.model.Faculty;

import java.util.HashMap;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> facultyes = new HashMap<>();
    private static Long counter = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++counter);
        facultyes.put(counter, faculty);
        return faculty;
    }

    public Faculty getFaculty(Long id) {
        return facultyes.get(id);
    }

    public Faculty updateFaculty(Faculty faculty) {
        facultyes.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long id) {
        counter--;
        return facultyes.remove(id);
    }
}

