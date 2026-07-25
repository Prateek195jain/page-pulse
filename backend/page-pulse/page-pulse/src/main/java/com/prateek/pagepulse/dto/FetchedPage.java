package com.prateek.pagepulse.dto;

import org.jsoup.nodes.Document;

public class FetchedPage {

    private Document document;
    private int httpStatus;
    private long responseTimeMs;
    private String contentType;

    public FetchedPage() {
    }

    public FetchedPage(Document document,
                       int httpStatus,
                       long responseTimeMs,
                       String contentType) {
        this.document = document;
        this.httpStatus = httpStatus;
        this.responseTimeMs = responseTimeMs;
        this.contentType = contentType;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public long getResponseTimeMs() {
        return responseTimeMs;
    }

    public void setResponseTimeMs(long responseTimeMs) {
        this.responseTimeMs = responseTimeMs;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}