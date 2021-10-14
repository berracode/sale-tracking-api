package com.inerxia.saletrackingapi.exception;

public class GeneralRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String message;


    public <T extends GeneralRuntimeException> GeneralRuntimeException(Class<T> className, String message) {
        super(message);
        this.message = getDefaulMessage(className) + message;
    }

    public <T extends GeneralRuntimeException> GeneralRuntimeException(Class<T> className, String message,
                                                                       Throwable throwable) {
        super(message, throwable);
        this.message = getDefaulMessage(className) + message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private <T extends GeneralRuntimeException> String getDefaulMessage(Class<T> t) {
        return "[" + t.getSimpleName() + "] ";
    }
}
