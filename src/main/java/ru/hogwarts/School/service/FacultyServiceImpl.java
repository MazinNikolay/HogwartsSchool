package ru.hogwarts.School.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.School.model.Faculty;
import ru.hogwarts.School.service.interfaces.FacultyService;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final HashMap<Long, Faculty> facultyes;
    private static Long counter;

    public FacultyServiceImpl() {
        facultyes = new HashMap<>();
        counter = 0L;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++counter);
        facultyes.put(counter, faculty);
        return faculty;
    }

    @Override
    public Faculty getFaculty(Long id) {
        return facultyes.get(id);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        facultyes.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        return facultyes.remove(id);
    }

    @Override
    public List<Faculty> sortByColor(String color) {
        String formattedColor = capitalize(lowerCase(color));
        return facultyes.values().stream()
                .filter(e -> e.getColor().equals(formattedColor))
                .collect(Collectors.toList());
    }
}

