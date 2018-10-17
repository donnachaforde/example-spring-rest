package io.demo.store;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */

import io.demo.model.ILocation;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Store - Interface to describe data access for security checks
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
public interface Store
{
    /**
     * Get a list of all the unique identifiers
     *
     * @return list of UUIDs stored on the system
     */
    Collection<UUID> getKeys();


    /**
     * Get a list of all locations
     *
     * @return list of all locations, or an empty collection if none recorded
     */
    Collection<ILocation> getValues();


    /**
     * Get location by UUID
     *
     * @param uuid UUID
     *
     * @return ILocation for the given uuid.
     */
    ILocation getLocation(UUID uuid);


    /**
     * Get the list of key/value id/locations for panels
     *
     * @return Map of ID to location
     */
    Map<UUID, ILocation> getLocations();
}
