package io.demo.model;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */


/**
 * ILocation - interface definition for 3D location
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
public interface ILocation
{
    /**
     * Get the GPS coordinates associated with this location
     *
     * @return coordinates of location
     */
    GPSCoordinates getCoordinates();

    /**
     * Get the altitude above sea-level of this location
     *
     * @return altitude of location
     */
    double getAltitude();

    /**
     * Get the free format string describing the relative location of
     * @return string containing 'relative' location
     */
    String getRelativeLocation();
}
