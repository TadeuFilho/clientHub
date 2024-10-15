package com.clientHub.domain.service;

import com.clientHub.domain.mother.AddressMother;
import com.clientHub.infrastructure.feign.AddressFeign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AddressServiceTest {

    private AddressFeign addressFeign;
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        addressFeign = mock(AddressFeign.class);
        addressService = new AddressService(addressFeign);
    }

    @Test
    public void findAddressByZipCodeTest() {
        when(addressFeign.findAddressByZip(any())).thenReturn(AddressMother.getValidAddressByCode());

        addressService.findAddressByZipCode(any());

        verify(addressFeign, times(1)).findAddressByZip(any());
    }

}
