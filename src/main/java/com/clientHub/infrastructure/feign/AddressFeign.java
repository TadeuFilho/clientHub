package com.clientHub.infrastructure.feign;

import com.clientHub.api.model.response.AddressExternalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${feign.client.address.integration.name}",
             url =  "${feign.client.address.integration.url}",
             configuration = FeignConfiguration.class)
public interface AddressFeign {

    @GetMapping("{cep}/json/")
    AddressExternalResponse findAddressByZip(@PathVariable("cep") String zipCode);
}
