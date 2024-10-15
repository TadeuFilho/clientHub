package com.clientHub.core.mapper;

import com.clientHub.api.model.response.AddressExternalResponse;
import com.clientHub.api.model.response.AddressInternalResponse;
import com.clientHub.domain.entity.Address;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressMapper {

    public static Address toAddressEntity(AddressExternalResponse response) {
        return Address
                .builder()
                .state(response.getState())
                .city(response.getCity())
                .street(response.getStreet())
                .zip(response.getZipcode())
                .build();
    }

    public static AddressInternalResponse toResponse(Address address) {
        return AddressInternalResponse
                .builder()
                .id(address.getId())
                .city(address.getCity())
                .state(address.getState())
                .street(address.getStreet())
                .zip(address.getZip())
                .build();
    }

    public static Address toUpdateAddress(Address address, AddressExternalResponse newAddress) {
        address.setCity(newAddress.getCity());
        address.setZip(newAddress.getZipcode());
        address.setStreet(newAddress.getStreet());
        address.setState(newAddress.getState());
        return address;
    }
}
