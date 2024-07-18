package com.api.system_transaction.infra.exceptions;

public class NotFoundIdException extends RuntimeException{
    public NotFoundIdException(Long id){

        super("could not found" + id);

    }
}
