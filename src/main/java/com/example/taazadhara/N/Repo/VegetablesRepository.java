package com.example.taazadhara.N.Repo;

import com.example.taazadhara.N.Entity.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface VegetablesRepository extends JpaRepository<Vegetables, Long>{
    Optional<Vegetables> findByvegetableName(String vegetableName);
}