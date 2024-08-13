package com.example.taazadhara.N.Repo;

import com.example.taazadhara.N.Entity.Location;
import com.example.taazadhara.N.Entity.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface    LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findBylocationName(String locationName);
}