package com.profile.studentgrades.services;

import com.profile.studentgrades.entities.Student;
import com.profile.studentgrades.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Класс-сервис для студентов
public class StudentServiceImpl implements StudentService {
    //Внедрение репозитория
    @Autowired
    private StudentRepository studentRepository;

    //Получение всех студентов
    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Получение конкретного студента по id
    @Override
    @Transactional
    public Student getStudent(int id) {
        Student student = null;
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) { //Если присутствует студент, то назначим его переменной student
            student = optional.get();
        }
        return student;
    }

    //Добавление нового студента или изменение информации существующего
    @Override
    @Transactional
    public void saveOrUpdateStudent(Student student) {
        studentRepository.save(student);
    }

    //Удаление студента по id
    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
