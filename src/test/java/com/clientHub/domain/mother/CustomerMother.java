package com.clientHub.domain.mother;

import com.clientHub.api.model.request.CustomerRequest;
import com.clientHub.domain.entity.Customer;

public class CustomerMother {

    public static Customer getCustomer() {
        return Customer.builder().id(1L).build();
    }

    public static CustomerRequest getCustomerRequest() {
        return CustomerRequest.builder().build();
    }

}
