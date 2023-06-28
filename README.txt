# Приложение "Студент и оценки"
Данное приложение, разработанное на Java 17, предоставляет REST API для управления данными о студентах и их оценках. Оно позволяет выполнять операции CRUD (Create, Read, Update, Delete) над объектами студентов и оценок, а также взаимодействовать с API в формате JSON. Приложение взаимодействует с базой данных - MySQL.

## Функциональность
Приложение предоставляет следующие основные возможности:
- Добавление, считывание, редактирование, удаление данных о студенте.
- Cчитывание, редактирование, удаление данных об отметке (функция добавления отметки встроена при добавлении студента).

## Зависимости
В этом проекте используются следующие зависимости:
- [spring-boot-starter-data-jpa]: предоставляет интеграцию с Java Persistence API (JPA) для работы с реляционными базами данных.
- [spring-boot-starter-web]: предоставляет основные компоненты и функциональность для разработки веб-приложений.
- [mysql-connector-j]: драйвер для подключения к базе данных MySQL из приложений Java.
- [spring-boot-starter-test]: предоставляет удобные инструменты для написания и выполнения тестов в приложениях, созданных с использованием Spring Boot.

## Установка и использование
Github:
1) Клонируйте репозиторий с Github.
2) Соберите приложение с помощью maven.
3) Установите/запустите базу данных MySQL.
4) Создайте новую базу данных для приложения (в моем случае - это student_db), в которой необходимо создать две таблицы с отношением One-To-Many (советую указывать те же названия таблиц и столбцов, которые прописаны при аннотациях @Table и @Column в Entity-классах проекта).
5) Запустите приложение.
6) Теперь вы можете взаимодействовать с API приложения с помощью HTTP-запросов c помощью Postman. Примерные запросы для Postman приведены ниже:

*ПРИМЕЧАНИЕ - ваш хост может отличаться и не обязательно быть 8080!*

Для Student:
GET (получение всех студентов и их оценок) - http://localhost:8080/api/students
GET (получение конкретного студента и его/ее оценок) - http://localhost:8080/api/students/{id студента} 
POST (добавление нового студента с оценками) - http://localhost:8080/api/students + в Body -> raw для примера можно ввести: 
{
    "name": "John",
    "surname": "Doe",
    "age": 20,
    "nationality": "American",
    "maritalStatus": "Single",
    "gradeList": [
        {
            "subject": "Informatics",
            "gradeValue": 10,
            "semester": 1,
            "teacher": "Mr. Johnson",
            "comments": "Awesome"
        },
        {
            "subject": "Physics",
            "gradeValue": 9,
            "semester": 2,
            "teacher": "Mr. Jackson",
            "comments": "Good"
        }
    ]
}
PUT (изменение существующего студента без изменения его/ее оценок (изменение оценок реализовано в отдельном контроллере)) - http://localhost:8080/api/students + в Body -> raw указываем пары "ключ-значение", id существующего студента и меняем значения, к примеру если id студента - 33, то:
{
    "id" : 33,
    "name": "John",
    "surname": "Mitchell",
    "age": 21,
    "nationality": "American",
    "maritalStatus": "Single",
    "gradeList": [
        {
            "subject": "Informatics",
            "gradeValue": 10,
            "semester": 1,
            "teacher": "Mr. Johnson",
            "comments": "Awesome"
        },
        {
            "subject": "Physics",
            "gradeValue": 9,
            "semester": 2,
            "teacher": "Mr. Jackson",
            "comments": "Good"
        }
    ]
}
DELETE (удаление существующего студента с его/ее оценками) - http://localhost:8080/api/students/{id студента}

Для Grade:
GET (получение всех оценок) - http://localhost:8080/api/grades
GET (получение конкретной оценки) - http://localhost:8080/api/grades/{id оценки} 
PUT (изменение существующей оценки) - http://localhost:8080/api/grades + в Body -> raw указываем пары "ключ-значение", id существующей оценки и меняем значения. К примеру если id оценки - 74, то:
{
    "id" : 74,
    "subject": "English",
    "gradeValue": 10,
    "semester": 1,
    "teacher": "Mr. Johnson",
    "comments": "Awesome"
}
DELETE (удаление существующей оценки) - http://localhost:8080/api/grades/{id оценки}
