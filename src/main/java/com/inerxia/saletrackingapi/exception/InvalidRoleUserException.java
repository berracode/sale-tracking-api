package com.inerxia.saletrackingapi.exception;

public class InvalidRoleUserException extends GeneralRuntimeException{

    private static final long serialVersionUID = 1L;

    public InvalidRoleUserException(String message){
        super(InvalidRoleUserException.class, message);
    }

}
