package io.demo.rest;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * SwaggerController - Boilerplate Swagger REST Controller integration
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
@Controller
@RequestMapping("/")
public class SwaggerController
{
    //-------------------------------------------------------------------------
    // construction

    /**
     * Default constructor
     *
     */
    public SwaggerController()
    {
    }

    //-------------------------------------------------------------------------
    // interface implementations

    @RequestMapping(method = RequestMethod.GET)
    public String swagger()
    {
        return "redirect:/swagger-ui.html";
    }

}
