package com.sreeram.blog.Blog.Exception;

public class ErrorDto {
    private int statusCode;
    private String message;
    private String developerMessage;

    public ErrorDto() {} //No arg constructor

    public ErrorDto(int statusCode, String message, String developerMessage) {
        this.statusCode = statusCode;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
}