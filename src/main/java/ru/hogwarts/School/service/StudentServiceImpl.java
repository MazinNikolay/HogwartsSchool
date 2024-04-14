package ru.hogwarts.School.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.School.model.Student;
import ru.hogwarts.School.service.interfaces.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final HashMap<Long, Student> students;
    private static Long counter;

    public StudentServiceImpl() {
        students = new HashMap<>();
        counter = 0L;
    }

    @Override
    public Student createStudent(Student student) {
        student.setId(++counter);
        students.put(counter, student);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        return students.get(id);
    }

    @Override
    public Student updateStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student deleteStudent(Long id) {
        return students.remove(id);
    }

    @Override
    public List<Student> sortByAge(int age) {
        return students.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}
