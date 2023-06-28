package com.profile.studentgrades.controllers;

import com.profile.studentgrades.entities.Grade;
import com.profile.studentgrades.exception_handling.ResourceNotFoundException;
import com.profile.studentgrades.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Класс-контроллер (для оценки), который обрабатывает веб-запросы
@RestController
@RequestMapping("/api") //Базовый путь для всех эндпоинтов данного контроллера
public class GradeController {
    //Внедрение gradeService
    @Autowired
    private GradeService gradeService;

    //Получение всех оценок
    @GetMapping("/grades")
    public List<Grade> showAllGrades() {
        List<Grade> allGrades = gradeService.getAllGrades();
        return allGrades;
    }

    //Получение оценки по id
    @GetMapping("/grades/{id}")
    public Grade getGrade(@PathVariable int id) {
        Grade grade = gradeService.getGrade(id);
        if (grade == null) {
            throw new ResourceNotFoundException("There is no grade with ID = " + id + " in Database");
        }
        return grade;
    }

    //Изменение оценки
    @PutMapping("/grades")
    public Grade updateGrade(@RequestBody Grade grade) {
        gradeService.updateGrade(grade);
        return grade;
    }

    //Удаление оценки по id
    @DeleteMapping("/grades/{id}")
    public String deleteGrade(@PathVariable int id) {
        Grade grade = gradeService.getGrade(id);
        gradeService.deleteGrade(id);
        return "Grade with ID = " + id + " was deleted";
    }
}
