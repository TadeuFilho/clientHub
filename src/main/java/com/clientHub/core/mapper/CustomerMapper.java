package com.clientHub.core.mapper;

import com.clientHub.api.model.request.CustomerRequest;
import com.clientHub.api.model.response.AddressExternalResponse;
import com.clientHub.api.model.response.CustomerResponse;
import com.clientHub.domain.entity.Address;
import com.clientHub.domain.entity.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerMapper {

    public static CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse
                .builder()
                .id(customer.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .address(AddressMapper.toResponse(customer.getAddress()))
                .build();
    }

    public static List<CustomerResponse> toCustomerResponseList(List<Customer> customers) {
        return customers
                .stream()
                .map(CustomerMapper::toCustomerResponse)
                .toList();
    }

    public static Customer toCustomerEntity(CustomerRequest request, Address address) {
        return Customer
                .builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .address(address)
                .build();
    }


    public static Customer toUpdateFull(Customer currentCustomer, CustomerRequest request, AddressExternalResponse address) {
        currentCustomer.setName(request.getName());
        currentCustomer.setPhone(request.getPhone());
        currentCustomer.setEmail(request.getEmail());
        currentCustomer.setAddress(AddressMapper.toUpdateAddress(currentCustomer.getAddress(),address));
        return currentCustomer;
    }
}
