package com.example.febandroid;

public class ResponseModel {

    String message;
    Boolean error;
    int otp;

    public ResponseModel(String message, Boolean error, int otp) {
        this.message = message;
        this.error = error;
        this.otp = otp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
