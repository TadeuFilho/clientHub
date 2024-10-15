package com.clientHub.domain.service;

import com.clientHub.api.model.response.AddressExternalResponse;
import com.clientHub.infrastructure.feign.AddressFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressFeign addressFeign;

    public AddressExternalResponse findAddressByZipCode(String zipCode) {
        return addressFeign.findAddressByZip(zipCode);
    }


}
