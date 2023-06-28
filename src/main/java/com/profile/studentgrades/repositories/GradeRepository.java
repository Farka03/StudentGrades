package com.profile.studentgrades.repositories;

import com.profile.studentgrades.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Интерфейс-репозиторий оценки, который обеспечивает доступ к бд
//При расширении JpaRepository, указывается тип сущности и тип идентификатора сущности
@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    //Параметр Grade - класс Entity проекта
    //Параметр Integer - тип id
}
