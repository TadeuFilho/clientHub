package com.clientHub.core.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Value("${swagger.license.url}")
    private String licenseUrl;

    @Value("${swagger.external.docs.url}")
    private String externalDocsUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Client Hub API")
                        .description("API for managing customers")
                        .version("v1.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url(licenseUrl)))
                .externalDocs(new ExternalDocumentation()
                        .description("Customer Wiki Documentation")
                        .url(externalDocsUrl));

    }

    @Bean
    public GroupedOpenApi customerOpenApi() {
        return GroupedOpenApi.builder()
                .group("customers")
                .pathsToMatch("/customers/**")
                .build();
    }

}
