package io.demo.model;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */


/**
 * GPSCoordinates - class representation of GPS co-ordinates
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
public class GPSCoordinates
{

    //-------------------------------------------------------------------------
    // member vars

    // GPS latitude, in decimal format
    private double latitude;

    // GPS longitude, in decimal format
    private double longitude;


    //-------------------------------------------------------------------------
    // construction

    public GPSCoordinates(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    //-------------------------------------------------------------------------
    // interface implementation

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }

}
