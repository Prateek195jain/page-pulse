package com.prateek.pagepulse.dto;

public class AuditResponse {

    private boolean success;
    private AuditData data;

    public AuditResponse() {
    }

    public AuditResponse(boolean success, AuditData data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public AuditData getData() {
        return data;
    }

    public void setData(AuditData data) {
        this.data = data;
    }
}