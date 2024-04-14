package ru.hogwarts.School.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.School.exceptioms.NotFoundEntityException;
import ru.hogwarts.School.model.Faculty;
import ru.hogwarts.School.service.interfaces.FacultyService;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final HashMap<Long, Faculty> faculties;
    private static Long counter;

    public FacultyServiceImpl() {
        faculties = new HashMap<>();
        counter = 0L;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        faculties.put(++counter, faculty);
        return faculty;
    }

    @Override
    public Faculty getFaculty(Long id) {
        if (!faculties.containsKey(id)) {
            throw new NotFoundEntityException();
        }
        return faculties.get(id);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        if (!faculties.containsKey(faculty.getId())) {
            throw new NotFoundEntityException();
        }
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        if (!faculties.containsKey(id)) {
            throw new NotFoundEntityException();
        }
        return faculties.remove(id);
    }

    @Override
    public List<Faculty> sortByColor(String color) {
        String formattedColor = capitalize(lowerCase(color));
        return faculties.values().stream()
                .filter(e -> e.getColor().equals(formattedColor))
                .collect(Collectors.toList());
    }
}

