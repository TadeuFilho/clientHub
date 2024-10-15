package com.clientHub.domain.mother;

import com.clientHub.api.model.response.AddressExternalResponse;
import com.clientHub.domain.entity.Address;

public class AddressMother {

    public static Address getAddress() {
        return Address.builder().build();
    }

    public static AddressExternalResponse getValidAddressByCode() {
        return AddressExternalResponse
                .builder()
                .city("TESTE")
                .neighborhood("TESTE")
                .state("TESTE")
                .additional("TESTE")
                .number("TESTE")
                .region("TESTE")
                .build();
    }
}
