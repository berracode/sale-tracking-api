package com.inerxia.saletrackingapi.exception;

public class UserNotEnabledLoginException extends GeneralRuntimeException{

    private static final long serialVersionUID = 1L;

    public UserNotEnabledLoginException(String message){
        super(UserNotEnabledLoginException.class, message);
    }

}
