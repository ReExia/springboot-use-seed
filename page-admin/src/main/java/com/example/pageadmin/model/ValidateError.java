package com.example.pageadmin.model;

public class ValidateError {

    private String errorField;

    private Object message;

    public ValidateError(){
    }

    public ValidateError(String errorField, Object message){
        this.errorField = errorField;
        this.message = message;
    }

    public static ValidateError build(String errorField, Object message){
        return new ValidateError(errorField, message);
    }

    public String getErrorField() {
        return errorField;
    }

    public void setErrorField(String errorField) {
        this.errorField = errorField;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
