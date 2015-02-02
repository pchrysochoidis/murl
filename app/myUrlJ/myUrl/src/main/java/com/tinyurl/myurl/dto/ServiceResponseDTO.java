package com.tinyurl.myurl.dto;

import java.io.Serializable;

public class ServiceResponseDTO implements Serializable {
    public ServiceResponseDTO() {
    }

    public ServiceResponseDTO( boolean isError, String error_code, Object data) {
        this.error = isError;
        this.error_code = error_code;
        this.data = data;
    }

    private static final long serialVersionUID = 7341657330739101868L;

    private boolean error;
    private String error_code;
    private Object data;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String errorCode) {
        this.error_code = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
