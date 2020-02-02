package com.tutorialq.exceptions;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;

    private String errorCode;
    private int httpStatusCode;
    private String message;
    private String errorDetails;

    public CustomException(String errorCode) {
        this.errorCode = errorCode;
        this.message = "";
    }

    public CustomException(String errorCode, Throwable th) {
        super(th);
        this.errorCode = errorCode;
        this.message = "";
    }

    public CustomException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public CustomException(String errorCode, String message, Throwable th) {
        super(th);
        this.errorCode = errorCode;
        this.message = message;
    }

    public CustomException(Throwable ex) {
        super(ex);
    }

    public CustomException errorCode(String errorCode) {
        setErrorCode(errorCode);
        return this;
    }

    public CustomException message(String errorMessage) {
        setMessage(errorMessage);
        return this;
    }

    public CustomException errorDetails(String errorDetails) {
        setErrorDetails(errorDetails);
        return this;
    }

    public CustomException httpStatusCode(int httpStatusCode) {
        setHttpStatusCode(httpStatusCode);
        return this;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
    
}