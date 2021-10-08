package com.inerxia.saletrackingapi.util;

public class StandardResponse<T> {

    private int status;
    private String message;
    private T body;

    public StandardResponse(EstadoStandardResponse status, T body){
        this.status = status.getEstado();
        this.body = body;
    }

    public StandardResponse(EstadoStandardResponse status, String message){
        this.status = status.getEstado();
        this.message = message;
    }

    public StandardResponse(EstadoStandardResponse status, String message, T body){
        this.status = status.getEstado();
        this.message = message;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public enum EstadoStandardResponse{
        OK(1),
        ERROR(0);

        private int estado;

        EstadoStandardResponse(int estado){
            this.estado = estado;
        }

        public int getEstado(){
            return estado;
        }
    }

}
