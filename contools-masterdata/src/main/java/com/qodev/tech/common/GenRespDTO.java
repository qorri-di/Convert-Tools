package com.qodev.tech.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GenRespDTO<T>{
    private ResponseStatus status;
    private int code;
    private String message;
    private T data;

    @JsonIgnore
    public GenRespDTO<T> successResponse(String message) {
        GenRespDTO<T> resp = new GenRespDTO<>();
        resp.setStatus(ResponseStatus.S);
        resp.setCode(201);
        resp.setMessage(message);
        return resp;
    }

    @JsonIgnore
    public GenRespDTO<T> successResponse(T t, String message) {
        GenRespDTO<T> resp = new GenRespDTO<>();
        resp.setStatus(ResponseStatus.S);
        resp.setCode(201);
        resp.setData(t);
        resp.setMessage(message);
        return resp;
    }

    @JsonIgnore
    public GenRespDTO<T> noDataFoundResponse(T t, String message) {
        GenRespDTO<T> resp = new GenRespDTO<>();
        resp.setStatus(ResponseStatus.S);
        resp.setCode(204);
        resp.setData(t);
        resp.setMessage(message);
        return resp;
    }

    @JsonIgnore
    public GenRespDTO<T> noDataFoundResponse(String message) {
        GenRespDTO<T> resp = new GenRespDTO<>();
        resp.setStatus(ResponseStatus.S);
        resp.setCode(204);
        resp.setMessage(message);
        return resp;
    }

    @JsonIgnore
    public GenRespDTO<T> errorResponse(int code, String message) {
        GenRespDTO<T> resp = new GenRespDTO<>();
        resp.setStatus(ResponseStatus.F);
        resp.setCode(code);
        resp.setMessage(message);
        return resp;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return this.status;
    }


    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public GenRespDTO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public GenRespDTO(ResponseStatus status, int code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
