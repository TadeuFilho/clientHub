package com.clientHub.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class AddressExternalResponse {

    @JsonProperty("cep")
    public String zipcode;

    @JsonProperty("logradouro")
    public String street;

    @JsonProperty("complemento")
    public String additional;

    @JsonProperty("unidade")
    public String number;

    @JsonProperty("bairro")
    public String neighborhood;

    @JsonProperty("localidade")
    public String city;

    @JsonProperty("uf")
    public String state;

    @JsonProperty("regiao")
    public String region;


}
