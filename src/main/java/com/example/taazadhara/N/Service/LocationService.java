package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.Location;
import com.example.taazadhara.N.exception.LocationNotFoundException;


import java.io.IOException;
import java.util.List;
import java.util.Optional;



public interface LocationService {


    Optional<Location> updateLocation(Long id, Location locationDetails) throws LocationNotFoundException;

    Location createLocation(Location location) throws IOException;

    Optional<Location> getLocationById(Long id);

    List<Location> getAllLocations();

    void deleteLocationById(Long id) throws LocationNotFoundException;


}