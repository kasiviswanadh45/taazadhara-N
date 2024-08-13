package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.exception.LocationNotFoundException;
import com.example.taazadhara.N.Entity.Location;
import com.example.taazadhara.N.Repo.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public Optional<Location> updateLocation(Long id, Location locationDetails) throws LocationNotFoundException {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("It is invalid"));
        existingLocation.setLocationName(locationDetails.getLocationName());
        existingLocation.setState(locationDetails.getState());
        existingLocation.setDistrict(locationDetails.getDistrict());
        existingLocation.setArea(locationDetails.getArea());
        Location updatedLocation = locationRepository.save(existingLocation);
        return Optional.of(updatedLocation);
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void deleteLocationById(Long id) throws LocationNotFoundException {
        try {
            locationRepository.deleteById(id);
        } catch (Exception e) {
            throw new LocationNotFoundException("Location not found for this id: " + id);
        }
    }
}
