package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.StagingVegetable;
import com.example.taazadhara.N.exception.StagingVegetableNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StagingVegetableService {

    List<StagingVegetable> getAllStagingVegetables();

    Optional<StagingVegetable> getStagingVegetableById(Long id);

    StagingVegetable createStagingVegetable(StagingVegetable stagingVegetable);

    StagingVegetable updateStagingVegetable(Long id, StagingVegetable stagingVegetable) throws StagingVegetableNotFoundException;


    void deleteStagingVegetableById(Long id) throws StagingVegetableNotFoundException;
}
