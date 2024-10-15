package com.clientHub.api.controller;

import com.clientHub.api.model.request.CustomerRequest;
import com.clientHub.api.model.response.AddressExternalResponse;
import com.clientHub.api.model.response.CustomerResponse;
import com.clientHub.core.mapper.AddressMapper;
import com.clientHub.core.mapper.CustomerMapper;
import com.clientHub.domain.entity.Customer;
import com.clientHub.domain.service.AddressService;
import com.clientHub.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(CustomerMapper.toCustomerResponseList(customerService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable Long id)  {
        return ResponseEntity.ok(CustomerMapper.toCustomerResponse(customerService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request) {
        AddressExternalResponse fullAddress = addressService.findAddressByZipCode(request.getZipcode());
        return new ResponseEntity<>(CustomerMapper.toCustomerResponse(customerService.save(request,AddressMapper.toAddressEntity(fullAddress))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody CustomerRequest request) {
        Customer currentCustomer = customerService.findById(id);
        AddressExternalResponse fullAddress = addressService.findAddressByZipCode(request.getZipcode());
        Customer customer = CustomerMapper.toUpdateFull(currentCustomer, request, fullAddress);
        return ResponseEntity.ok(CustomerMapper.toCustomerResponse(customerService.updateFull(customer)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
       customerService.delete(id);
            return ResponseEntity.noContent().build();
    }

}