package ru.hogwarts.School.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.School.model.Student;

import java.util.HashMap;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private static Long counter = 0L;

    public Student createStudent(Student student) {
        student.setId(++counter);
        students.put(counter, student);
        return student;
    }

    public Student getStudent(Long id) {
        return students.get(id);
    }

    public Student updateStudent(Long id, Student student) {
        students.put(id, student);
        return student;
    }

    public Student deleteStudent(Long id) {
        return students.remove(id);
    }
}
