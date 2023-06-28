package com.profile.studentgrades.repositories;

import com.profile.studentgrades.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Интерфейс-репозиторий студента, который обеспечивает доступ к бд
//При расширении JpaRepository, указывается тип сущности и тип идентификатора сущности
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Параметр Student - класс Entity проекта
    //Параметр Integer - тип id
}
