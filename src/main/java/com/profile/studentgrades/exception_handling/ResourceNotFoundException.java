package com.profile.studentgrades.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Пользовательское исключение для GET-запроса по id (в случае, если не будет найден продукт)
@ResponseStatus(HttpStatus.NOT_FOUND) //При возникновении исключения должен быть возвращен HTTP-статус "404 Not Found"
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
