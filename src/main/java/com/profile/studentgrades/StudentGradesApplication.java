package com.profile.studentgrades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Точка входа в приложение
//Аннотация @SpringBootApplication уже объединяет в себе @Configuration, @EnableAutoConfiguration и @ComponentScan
@SpringBootApplication
public class StudentGradesApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentGradesApplication.class, args);
    }
}
