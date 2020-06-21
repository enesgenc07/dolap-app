package com.trendyol.dolapapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//    ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Dolap App Operation API Reference - TRENDYOL")
//                .version("1.0.0")
//                .build();
//    }
//
//    @Bean
//    public Docket customImplementation() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select().paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.trendyol"))
//                .build()
//                .pathMapping("/")
//                .useDefaultResponseMessages(false)
//                .directModelSubstitute(LocalDate.class, String.class)
//                .genericModelSubstitutes(ResponseEntity.class);
//    }

    @Bean
    public Docket api() {
        ParameterBuilder paramBuilder = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        paramBuilder.name("Authorization").modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        params.add(paramBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(params)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trendyol"))
                .build()
                .apiInfo(apiInfo())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dolap App Operation API Reference - TRENDYOL",
                "Dolap App Trendyol Workshop API",
                "1.0",
                "Terms of service",
                new Contact("enesgenc", "", ""),
                "License of API", "API license URL", Collections.emptyList());
    }
}
