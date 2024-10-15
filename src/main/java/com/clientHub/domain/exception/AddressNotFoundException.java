package com.clientHub.domain.exception;

public class AddressNotFoundException extends EntityNotFoundException {

    public AddressNotFoundException(String zip) {
        super(String.format("Does not exist an address with ZIP code %s", zip));
    }

}
