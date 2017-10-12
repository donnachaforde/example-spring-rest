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

    // GPS longitude, in decimal format
    private double longitude;

    // GPS latitude, in decimal format
    private double latitude;


    //-------------------------------------------------------------------------
    // construction

    public GPSCoordinates(double longitude, double latitude)
    {
        this.longitude = longitude;
        this.latitude = latitude;
    }


    //-------------------------------------------------------------------------
    // interface implementation


    public double getLongitude()
    {
        return this.longitude;
    }

    public double getLatitude()
    {
        return this.latitude;
    }
}
