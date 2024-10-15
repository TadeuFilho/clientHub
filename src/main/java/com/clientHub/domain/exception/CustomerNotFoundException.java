package com.clientHub.domain.exception;

public class CustomerNotFoundException extends EntityNotFoundException{

    public CustomerNotFoundException(String mensagem) {
        super(mensagem);
    }

    public CustomerNotFoundException(Long customerId) {
        this(String.format("Does not exist a customer with id %d ", customerId));
    }

}
