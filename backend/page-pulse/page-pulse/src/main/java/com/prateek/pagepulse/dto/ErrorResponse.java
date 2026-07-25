package com.prateek.pagepulse.dto;

public class ErrorResponse {

    private boolean success;
    private ErrorData error;

    public ErrorResponse() {
    }

    public ErrorResponse(boolean success, ErrorData error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorData getError() {
        return error;
    }

    public void setError(ErrorData error) {
        this.error = error;
    }
}