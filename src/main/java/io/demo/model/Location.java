package io.demo.model;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */


/**
 * Location - 3D location plus relative location
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
public class Location implements ILocation
{
    //-------------------------------------------------------------------------
    // member vars

    // GPS coordiantes of panel
    private GPSCoordinates coordinates;

    // altitude above sea level
    private double altitude;

    // the 'relative' location of the panel in free form text
    private String strRelativeLocation;


    //-------------------------------------------------------------------------
    // construction

    /**
     * Default constructor - required for serialization purposes.
     */
    public Location()
    {
    }

    public Location(GPSCoordinates coordinates, double altitude, String strRelativeLocation)
    {
        this.coordinates = coordinates;
        this.altitude = altitude;
        this.strRelativeLocation = strRelativeLocation;
    }

    /**
     * Factory method - create an instance of this class.
     *
     * @return - new Location instance.
     */
    public static Location createInstance(GPSCoordinates coordinates, double altitude, String strRelativeLocation)
    {
        return new Location(coordinates, altitude, strRelativeLocation);
    }


    //-------------------------------------------------------------------------
    // setters & getters

    /**
     * Get the GPS coordinates associated with this location
     *
     * @return coordinates of location
     */
    @Override
    public GPSCoordinates getCoordinates()
    {
        return this.coordinates;
    }

    /**
     * Get the altitude above sea-level of this location
     *
     * @return altitude of location
     */
    @Override
    public double getAltitude()
    {
        return this.altitude;
    }

    /**
     * Get the free format string describing the relative location of
     * @return string containing 'relative' location
     */
    @Override
    public String getRelativeLocation()
    {
        return this.strRelativeLocation;
    }
}
