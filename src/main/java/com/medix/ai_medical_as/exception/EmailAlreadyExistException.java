package com.medix.ai_medical_as.exception;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException(String message)
    {
        super(message);
    }
}
