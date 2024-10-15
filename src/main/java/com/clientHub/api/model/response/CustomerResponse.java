package com.clientHub.api.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private AddressInternalResponse address;

}
