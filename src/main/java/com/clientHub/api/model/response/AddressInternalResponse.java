package com.clientHub.api.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressInternalResponse {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;

}
