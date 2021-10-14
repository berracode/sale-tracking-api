package com.inerxia.saletrackingapi.util;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StandardResponse<T> {
    public static final String FORMTATO_FECHA_HORA = "dd/MM/yyyy HH:mm:ss";
    private String status;
    private String message;
    private String dateTime;
    private T body;

    public StandardResponse(StatusStandardResponse status, T body){
        this.status = status.getStatus();
        this.dateTime = new SimpleDateFormat(FORMTATO_FECHA_HORA).format(Calendar.getInstance().getTime());
        this.body = body;
    }

    public StandardResponse(StatusStandardResponse status, String message){
        this.status = status.getStatus();
        this.dateTime = new SimpleDateFormat(FORMTATO_FECHA_HORA).format(Calendar.getInstance().getTime());
        this.message = message;
    }

    public StandardResponse(StatusStandardResponse status, String message, T body){
        this.status = status.getStatus();
        this.dateTime = new SimpleDateFormat(FORMTATO_FECHA_HORA).format(Calendar.getInstance().getTime());
        this.message = message;
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public enum StatusStandardResponse {
        OK("CORRECT_TRANSACTION"),
        ERROR("INCORRECT_TRANSACTION");

        private String status;

        StatusStandardResponse(String status){
            this.status = status;
        }

        public String getStatus(){
            return status;
        }
    }

}
