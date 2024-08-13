package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.Vegetables;
import com.example.taazadhara.N.exception.VegetableNotFoundException;
import java.util.List;
import java.util.Optional;

public interface vegetablesService {

    List<Vegetables> getAllVegetables();

    Vegetables getVegetableById(Long id);

    Vegetables createVegetable(Vegetables vegetables);

    Optional<Vegetables> updateVegetableById(Long id, Vegetables vegetableName) throws VegetableNotFoundException;

    Optional<Vegetables> updateVegetableByName(String vegetableName, Vegetables vegetableDetails) throws VegetableNotFoundException;

    void deleteVegetable(Long id) throws  VegetableNotFoundException;
}