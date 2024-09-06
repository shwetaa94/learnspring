package com.learn.javabackend.response;

public class Response<T> {
    private String status;
    private String message;
    private T data;

    // Constructors
    public Response(String status, String message,T data) {
        this.status = status;
        this.message = message;
        this.data = data;

    }

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
