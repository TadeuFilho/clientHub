package com.clientHub.domain.service;

import com.clientHub.api.model.request.CustomerRequest;
import com.clientHub.core.mapper.CustomerMapper;
import com.clientHub.domain.entity.Address;
import com.clientHub.domain.entity.Customer;
import com.clientHub.domain.exception.CustomerNotFoundException;
import com.clientHub.infrastructure.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer save(CustomerRequest request, Address address) {
        return customerRepository.save(CustomerMapper.toCustomerEntity(request, address));
    }

    public Customer updateFull(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Long id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }
}