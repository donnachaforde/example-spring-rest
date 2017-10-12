package io.demo.store;
/**
 * Copyright (c) 2017 Donnacha Forde - All rights reserved.
 */


import io.demo.model.GPSCoordinates;
import io.demo.model.ILocation;
import io.demo.model.Location;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * InMemoryStore - Simulated in-memory datastore
 *
 * @author Donnacha Forde
 * @version Version 0.1.0
 */
@Component
public class InMemoryStore implements Store
{
    //-------------------------------------------------------------------------
    // member vars

    // store of panel locations
    private Map<UUID, ILocation> panelLocations = new HashMap<UUID, ILocation>();


    //-------------------------------------------------------------------------
    // construction

    /**
     * Default constructor - required for serialization purposes.
     *
     * Note: This ctor is not intended to be used directly.
     */
    public InMemoryStore()
    {
        /*
         * Populate the store
         */

        // CIT locations
        this.insertRecord("580ddc98-0db9-473d-a721-348f353f1d2b", 100.0, 51.884827, -8.533947, "CIT Library West Wing Entry Doors, Cork, Ireland");
        this.insertRecord("7907775e-15ac-415f-a99c-e978856c8ec0", 100.0, 51.884969, -8.533235, "CIT Library North Ground Exit, Cork, Ireland");
        this.insertRecord("5506c98c-7619-4cb4-ac6c-e38fec15cef2", 100.0, 51.883165, -8.532648, "Main Building, Ground Floor East Exit, Cork, Ireland");
        this.insertRecord("e95cffe9-f7cf-4a58-92ac-733a7350092f", 110.0, 51.883165, -8.532648, "Main Building, First Floor East Exit, Cork, Ireland");
        this.insertRecord("df58fcd9-2374-406e-8c49-911bbea976ee", 090.0, 51.886325, -8.535620, "Rubicon Building, Main Door, Cork, Ireland");
        this.insertRecord("d50f91a5-6f2b-4a70-ab6c-e0fec58c866e", 090.0, 51.886403, -8.533580, "Old Tyco Building, Main Door, Cork, Ireland");
        this.insertRecord("1a9c03a2-1ab7-4879-8d28-a4ea76e1da5b", 095.0, 51.886400, -8.533581, "Old Tyco Building, First Floor, Cork, Ireland");

        // UCL
        this.insertRecord("1fe7dbf9-7305-491b-a5bc-7f5cfc4b0351", 150.0, 51.524885, -0.133873, "UCL, North Cloisters Entrance, London, UK");
        this.insertRecord("123b33e8-63b9-4c04-838b-f65aacbeab42", 150.0, 51.525280, -0.133313, "UCL, Department of Physics & Astronomy Main Entrance, London, UK");
        this.insertRecord("ad9611b0-c759-4714-872e-2ed55e70ec80", 150.0, 51.524774, -0.131913, "UCL, Institute of Archaeology, South Entrance, London, UK");
        this.insertRecord("f0429b5e-fa0f-4a1f-a5df-6020ba5bfc48", 150.0, 51.521726, -0.130196, "Birkbeck UCL, Malet Street Entrance, London, UK");
        this.insertRecord("a35c7873-b875-4685-91ac-188244509a03", 160.0, 51.521723, -0.130194, "Birkbeck UCL, First Floor, London, UK");

        // Stanford University
        this.insertRecord("745c3d99-ab54-4b69-bbfa-33d929578e21", 250.0, 37.428348, -122.160999, "Stanford Graduate School of Business, Faculty Building East, Main entrance, CA, USA");
        this.insertRecord("287d07d6-e243-4947-807d-74ec80f57427", 250.0, 37.428798, -122.163708, "Stanford Ford Center, Arguello Way, Main entrance, CA, USA");
        this.insertRecord("bc6271c1-b539-4ece-9f5e-acc122af9fe4", 250.0, 37.428637, -122.165954, "Stanford Department of Economics, Serra Mall, West Entrance, CA, USA");
        this.insertRecord("5e11d5ee-7715-4080-bfe6-25c66d8ce821", 260.0, 37.428637, -122.165954, "Stanford Department of Economics, 1st Floor, West Wing, CA, USA");
        this.insertRecord("3a253fa0-456e-4254-a871-5d660c5950ae", 270.0, 37.428636, -122.165953, "Stanford Department of Economics, 2nd Floor, West Wing, CA, USA");
        this.insertRecord("5ae6dbcd-9166-4d80-99d9-069e69bead15", 280.0, 37.428638, -122.165955, "Stanford Department of Economics, 3rd Floor, West Wing, CA, USA");

        // Harvard University
        this.insertRecord("efa66c50-1327-4aec-9661-ef7531235420", 050.0, 42.373921, -71.116374, "Widener Library, Harvard University, Main Entrance, MA, USA");
        this.insertRecord("066e6fd3-49a4-4e08-8793-eb87bd323408", 051.0, 42.373916, -71.115494, "Emerson Hall, Harvard University, Main Entrance, MA, USA");
        this.insertRecord("3fc92a17-f774-49c2-9026-437214222ee0", 051.0, 42.374967, -71.116676, "Thayer Hall, Harvard University, Main Entrance, MA, USA");
    }

    private void insertRecord(String strUUID, double altitude, double longitude, double latitude, String strRelativeLocation)
    {
        // populate the store
        UUID uuid = UUID.fromString(strUUID);
        GPSCoordinates coordinates = new GPSCoordinates(longitude, latitude);
        Location panelLocation = new Location(coordinates, altitude, strRelativeLocation);

        this.panelLocations.put(uuid, panelLocation);
    }


    //-------------------------------------------------------------------------
    // interface implementations

    /**
     * Get location by UUID
     *
     * @param uuid UUID
     * @return ILocation for the given uuid.
     */
    @Override
    public ILocation getLocation(UUID uuid)
    {
        return this.panelLocations.get(uuid);
    }

    /**
     * Get a list of all locations
     *
     * @return list of all locations, or an empty collection if none recorded
     */
    @Override
    public Collection<ILocation> getAllLocations()
    {
        return this.panelLocations.values();
    }

    /**
     * Get a list of all the unique identifers
     *
     * @return list of UUIDs stored on the system
     */
    @Override
    public Collection<UUID> getAllIds()
    {
        return this.panelLocations.keySet();
    }

}
