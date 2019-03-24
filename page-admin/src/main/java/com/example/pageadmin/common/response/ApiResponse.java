package com.example.pageadmin.common.response;

import java.util.HashMap;
import java.util.Map;

/**
 * api返回数据
 * @param <T>
 */
public class ApiResponse<T> {

    private int code; // 状态码
    private String message; // 消息
    private T data; // 返回的数据

    public ApiResponse() {

    }

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", this.code);
        result.put("message", this.message);
        result.put("data", this.data);
        return result;
    }

    /**
     * 定义常用静态方法
     */
    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), data);
    }

    public static ApiResponse ofSuccess() {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), null);
    }

    public static ApiResponse ofFail(){
        return new ApiResponse(Status.INTERNAL_SERVER_ERROR.getCode(),Status.SUCCESS.getMessage(),null);
    }

    public static ApiResponse ofMessage(int code, String message) {
        return new ApiResponse(code, message, null);
    }

    public static ApiResponse ofMessage(int code, String message,Object data) {
        return new ApiResponse(code, message, data);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.getCode(), status.getMessage(), null);
    }

    /**
     * 定义状态枚举
     */
    public enum Status {


        SUCCESS(200, "ok"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "resource not found"),
        INTERNAL_SERVER_ERROR(500, "server internal error"),


        QYERY_NOT_EXIST(10000, "query not exist"),
        INVALID_PARAM(10001, "invalid parameter"),
        UPLOAD_SIZE_TOO_BIG(10003, "file too big");


        private int code;
        private String message;

        Status(int code, String standardMessage) {
            this.code = code;
            this.message = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String standardMessage) {
            this.message = standardMessage;
        }
    }
}
