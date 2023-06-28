package com.profile.studentgrades.services;

import com.profile.studentgrades.entities.Student;

import java.util.List;

////Интерфейс для сервиса для студентов
public interface StudentService {
    //Получение всех студентов
    public List<Student> getAllStudents();

    //Добавление нового студента или изменение информации существующего
    public void saveOrUpdateStudent(Student student);

    //Получение конретного студента по id
    public Student getStudent(int id);

    //Удаление студента по id
    public void deleteStudent(int id);
}
