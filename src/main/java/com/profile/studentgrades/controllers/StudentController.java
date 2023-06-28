package com.profile.studentgrades.controllers;

import com.profile.studentgrades.entities.Student;
import com.profile.studentgrades.exception_handling.ResourceNotFoundException;
import com.profile.studentgrades.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Класс-контроллер (для студента), который обрабатывает веб-запросы
@RestController
@RequestMapping("/api") //Базовый путь для всех эндпоинтов данного контроллера
public class StudentController {
    //Внедрение studentService
    @Autowired
    private StudentService studentService;

    //Получение всех студентов
    @GetMapping("/students")
    public List<Student> showAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    //Получение конкретного студента по id
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            throw new ResourceNotFoundException("There is no student with ID = " + id + " in Database");
        }
        return student;
    }

    //Добавление нового студента
    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {
        studentService.saveOrUpdateStudent(student);
        return student;
    }

    //Изменение информации о студенте
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveOrUpdateStudent(student);
        return student;
    }

    //Удаление студента по id
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        studentService.deleteStudent(id);
        return "Student with ID = " + id + " was deleted";
    }
}
