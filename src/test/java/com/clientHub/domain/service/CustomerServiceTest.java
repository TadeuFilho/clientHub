package com.clientHub.domain.service;

import com.clientHub.api.model.request.CustomerRequest;
import com.clientHub.domain.entity.Address;
import com.clientHub.domain.entity.Customer;
import com.clientHub.domain.mother.AddressMother;
import com.clientHub.domain.mother.CustomerMother;
import com.clientHub.infrastructure.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
    }

    @Test
    public void getAllCustomersTest() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(CustomerMother.getCustomer()));

        customerService.findAll();

        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void getCustomerByIdTest() {
        when(customerRepository.findById(any())).thenReturn(Optional.of(CustomerMother.getCustomer()));

        customerService.findById(any());

        verify(customerRepository, times(1)).findById(any());
    }

    @Test
    public void createCustomerTest() {
        CustomerRequest customerRequest = CustomerMother.getCustomerRequest();
        Address address = AddressMother.getAddress();
        Customer customerSaved = CustomerMother.getCustomer();

        when(customerRepository.save(any(Customer.class))).thenReturn(customerSaved);

        Customer saved = customerService.save(customerRequest, address);

        assertEquals(customerSaved, saved);

        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void updateCustomerTest() {
        Customer customerFound = CustomerMother.getCustomer();

        when(customerRepository.findById(any())).thenReturn(Optional.of(customerFound));

        customerService.updateFull(customerFound);

        verify(customerRepository, times(1)).save(customerFound);
    }

    @Test
    public void deleteByIdTest() {
        Customer customerFound = CustomerMother.getCustomer();

        when(customerRepository.findById(any())).thenReturn(Optional.of(customerFound));

        customerService.delete(any());

        verify(customerRepository, times(1)).delete(any());
    }

}
