package io.demo.rest;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */

import io.demo.model.Location;
import io.demo.store.Store;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

/**
 * LocationController - Spring REST Controller
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
@Api(value = "/panels", description = "Operations for Swipe Panel Locations")
@RestController
@RequestMapping("/api")
public class LocationController
{
    //-------------------------------------------------------------------------
    // member vars

    // internal store
    @Autowired
    private Store store;


    //-------------------------------------------------------------------------
    // construction

    /**
     * Default constructor
     *
     */
    public LocationController()
    {
    }



    //-------------------------------------------------------------------------
    // REST endpoints

    @ApiOperation(value = "Get list of all panels IDs")
    @RequestMapping(value = "/panels", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<UUID> getPanelIds()
    {
        return store.getAllIds();
    }

    @ApiOperation(value = "Get the location of a panel by ID")
    @RequestMapping(value = "/panels/{panelId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Location getLocationByPanelId(@PathVariable(value = "panelId") String panelId)
    {
        // perform lookup by uuid
        UUID uuid = UUID.fromString(panelId);
        return (Location)store.getLocation(uuid);
    }

}
