package com.entity;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-17
 */

public class ErrorMsgObject {

    private String status;
    private String statusCode;
    private String msg;
    private String url;
    private Object field;
    private String error;
    private String errorMsg;
    private Object errorObj;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Exception e;

    public ErrorMsgObject() {

    }

    public ErrorMsgObject(String msg, HttpServletRequest httpServletRequest,Exception e) {
        this.msg = msg;
        this.httpServletRequest = httpServletRequest;
        this.e = e;
    }

    public ErrorMsgObject(String statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }

    public String getMsg() {
        return msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Object getField() {
        return field;
    }

    public void setField(Object field) {
        this.field = field;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getErrorObj() {
        return errorObj;
    }

    public void setErrorObj(Object errorObj) {
        this.errorObj = errorObj;
    }
}