package com.project.comercio.exceptions;

public class StockConflictException extends ConflictException{
    public StockConflictException(String detail){
        super(detail);
    }
}
