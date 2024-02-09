package org.ameda.kevin.cachingredis.exceptions;/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.exceptions
*
*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -5274604505720526425L;

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
