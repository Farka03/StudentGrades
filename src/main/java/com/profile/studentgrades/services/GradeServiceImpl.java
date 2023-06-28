package com.profile.studentgrades.services;

import com.profile.studentgrades.entities.Grade;
import com.profile.studentgrades.repositories.GradeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Класс-сервис для оценок
public class GradeServiceImpl implements GradeService {
    //Внедрение репозитория
    @Autowired
    private GradeRepository gradeRepository;

    //Получение всех оценок
    @Override
    @Transactional
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    //Изменение оценки
    @Override
    @Transactional
    public void updateGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    //Получение оценки по id
    @Override
    @Transactional
    public Grade getGrade(int id) {
        Grade grade = null;
        Optional<Grade> optional = gradeRepository.findById(id);
        if (optional.isPresent()) { //Если присутствует студент, то назначим его переменной student
            grade = optional.get();
        }
        return grade;
    }

    //Удаление оценки по id
    @Override
    @Transactional
    public void deleteGrade(int id) {
        gradeRepository.deleteById(id);
    }
}
