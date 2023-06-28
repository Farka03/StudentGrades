package com.profile.studentgrades.services;

import com.profile.studentgrades.entities.Grade;

import java.util.List;

//Интерфейс для сервиса для оценок
public interface GradeService {
    //Получение всех оценок
    public List<Grade> getAllGrades();

    //Изменение оценки
    public void updateGrade(Grade grade);

    //Получение оценки по id
    public Grade getGrade(int id);

    //Удаление оценки по id
    public void deleteGrade(int id);
}
