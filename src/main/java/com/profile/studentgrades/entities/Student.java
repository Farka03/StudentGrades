package com.profile.studentgrades.entities;

import jakarta.persistence.*;

import java.util.List;

//Entity-класс студента, который может быть сохранен в бд
@Entity
@Table(name = "student")
public class Student {
    //Id
    @Id //Первичный ключ, который будет автоматически генерироваться при сохранении объекта в бд
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    //Имя
    @Column(name = "name")
    private String name;
    //Фамилия
    @Column(name = "surname")
    private String surname;
    //Возраст
    @Column(name = "age")
    private int age;
    //Национальность
    @Column(name = "nationality")
    private String nationality;
    //Семейное положение
    @Column(name = "marital_status")
    private String maritalStatus;
    //Отношение "один-ко-многим" между объектами этого класса и объектами класса Grade.
    //"cascade" означает, что если студент будет удален, все связанные с ним оценки также будут удалены из бд
    //Используется Uni-directional связь
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private List<Grade> gradeList;

    public Student() {
    }

    public Student(String name, String surname, int age, String nationality, String maritalStatus) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
    }

    /*public void addGradeToStudent(Grade grade) {
        if (gradeList == null) {
            gradeList = new ArrayList<>();
        }
        gradeList.add(grade);
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }
}
