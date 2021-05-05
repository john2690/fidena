package com.example.fidena.app.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.fidena.app.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo())


    private fun apiInfo() = ApiInfo(
        "Rest api FIDENA",
        "CRUD of a User",
        "V1.0.0",
        "Terms ",
        Contact("Edgar Jonathan Miranda Nava", "https://github.com/john2690/fidena", "emiranda26@hotmail.com"),
        "License of FIDENA", "API license URL", mutableListOf()
    )
}