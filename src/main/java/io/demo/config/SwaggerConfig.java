package io.demo.config;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * SwaggerConfig - Boilerplate Swagger REST Config class
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements EnvironmentAware
{
    // ----------------------------------------------------------------------------
    // meta data

    // shorthand ref to our class name
    private static final String className = SwaggerConfig.class.getSimpleName();

    // ref to our log mechanism
    private static final Logger Log = LoggerFactory.getLogger(SwaggerConfig.class);


    //-------------------------------------------------------------------------
    // member vars

    // target REST interface URIs
    public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";

    // hook to properties
    private RelaxedPropertyResolver propertyResolver;

    //-------------------------------------------------------------------------
    // construction

    /**
     * Default constructor - required for serialization purposes.
     * <p>
     * Note: This ctor is not intended to be used directly.
     */
    public SwaggerConfig()
    {
    }


    //-------------------------------------------------------------------------
    // interface implementations


    @Override
    public void setEnvironment(Environment environment)
    {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "swagger.");
    }

    /**
     * Swagger Springfox configuration.
     */
    @Bean
    public Docket swaggerSpringfoxDocket()
    {
        Log.debug("Starting Swagger");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                            .apiInfo(apiInfo())
                            //.globalOperationParameters(httpHeader())
                            .genericModelSubstitutes(ResponseEntity.class)
                            .forCodeGeneration(true)
                            .genericModelSubstitutes(ResponseEntity.class)
                            .directModelSubstitute(org.joda.time.LocalDate.class, String.class)
                            .directModelSubstitute(org.joda.time.LocalDateTime.class, Date.class)
                            .directModelSubstitute(org.joda.time.DateTime.class, Date.class)
                            .select()
                            .paths(regex(DEFAULT_INCLUDE_PATTERN))
                            .build();
        stopWatch.stop();
        Log.debug("Started Swagger in {} ms", stopWatch.getTotalTimeMillis());
        return docket;
    }

    /**
     * API Info as it appears on the swagger-ui page.
     */
    private ApiInfo apiInfo()
    {
        return new ApiInfo( propertyResolver.getProperty("title"),
                            propertyResolver.getProperty("description"),
                            propertyResolver.getProperty("version"),
                            propertyResolver.getProperty("termsOfServiceUrl"),
                            propertyResolver.getProperty("contact"),
                            propertyResolver.getProperty("license"),
                            propertyResolver.getProperty("licenseUrl"));
    }

    /**
     * Global header for REST API's
     */
    private List<Parameter> httpHeader()
    {
        Parameter header = new ParameterBuilder()
                                .name("token")
                                .description("Single sign-on token")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build();
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(header);

        return parameters;
    }

}
