package com.inerxia.saletrackingapi.exception;

public class InsufficientStockException extends GeneralRuntimeException{

    private static final long serialVersionUID = 1L;

    public InsufficientStockException(String message){
        super(InsufficientStockException.class, message);
    }
}
