package io.demo.rest;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */

import io.demo.model.ILocation;
import io.demo.model.Location;
import io.demo.store.Store;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
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

    /**
     * getPanelIds - Get a list of the Panel UUIDs
     *
     * @return Collection of unique UUID code.
     */

    @ApiOperation(value = "Get list of all panels IDs")
    @RequestMapping(value = "/keys", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<UUID> getPanelIds()
    {
        return store.getKeys();
    }

    /**
     * Get Location details by unique panel ID
     *
     * @param panelId Unique panel ID in the form of a UUID
     *
     * @return Location details
     */
    @ApiOperation(value = "Get the location of a panel by ID")
    @RequestMapping(value = "/panels/{panelId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Location getLocationByPanelId(@PathVariable(value = "panelId") String panelId)
    {
        // perform lookup by uuid
        UUID uuid = UUID.fromString(panelId);
        return (Location)store.getLocation(uuid);
    }

    /**
     * Get all Location details
     *
     * @return Collection of Location details
     */
    @ApiOperation(value = "Get list of all locations")
    @RequestMapping(value = "/values", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<ILocation> getValues()
    {
        // query the store for the list of all locations
        Collection<ILocation> locations;
        locations = store.getValues();

        return locations;
    }


    /**
     * Get all Location details
     *
     * @return Map of PanelID to Location details
     */
    @ApiOperation(value = "Get key/value data")
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map<UUID, ILocation> getAllLocations()
    {
        return store.getLocations();
    }


}
