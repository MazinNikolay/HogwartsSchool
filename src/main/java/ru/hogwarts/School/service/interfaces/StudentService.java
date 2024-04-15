package ru.hogwarts.School.service.interfaces;

import ru.hogwarts.School.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    Student getStudent(Long id);

    Student updateStudent(Student student);

    Student deleteStudent(Long id);

    List<Student> sortByAge(int age);
}
