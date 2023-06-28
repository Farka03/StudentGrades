package com.profile.studentgrades.entities;

import jakarta.persistence.*;

//Entity-класс оценки, который может быть сохранен в бд
@Entity
@Table(name = "grade")
public class Grade {
    //Id
    @Id //Первичный ключ, который будет автоматически генерироваться при сохранении объекта в бд
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    //Предмет, по которому выставлена оценка
    @Column(name = "subject")
    private String subject;
    //Числовая оценка, полученная студентом
    @Column(name = "grade_value")
    private int gradeValue;
    //Номер семестра, в котором была выставлена оценка
    @Column(name = "semester")
    private int semester;
    //Имя преподавателя, который выставил оценку
    @Column(name = "teacher")
    private String teacher;
    //Комментарии, оставленные учителем по работе студента
    @Column(name = "comments")
    private String comments;

    public Grade() {
    }

    public Grade(String subject, int gradeValue, int semester, String teacher, String comments) {
        this.subject = subject;
        this.gradeValue = gradeValue;
        this.semester = semester;
        this.teacher = teacher;
        this.comments = comments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public int getSemester() {
        return semester;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getComments() {
        return comments;
    }
}
