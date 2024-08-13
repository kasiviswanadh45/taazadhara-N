package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.StagingVegetable;
import com.example.taazadhara.N.Repo.StagingVegetableRepository;
import com.example.taazadhara.N.exception.StagingVegetableNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StagingVegetableServiceImpl implements StagingVegetableService {

    @Autowired
    private StagingVegetableRepository stagingVegetableRepository;

    @Override
    public List<StagingVegetable> getAllStagingVegetables() {
        return stagingVegetableRepository.findAll();
    }

    @Override
    public Optional<StagingVegetable> getStagingVegetableById(Long id) {
        return Optional.ofNullable(stagingVegetableRepository.findById(id).orElse(null));
    }

    @Override
    public StagingVegetable createStagingVegetable(StagingVegetable stagingVegetable) {
        return stagingVegetableRepository.save(stagingVegetable);
    }

    @Override
    public StagingVegetable updateStagingVegetable(Long id, StagingVegetable stagingVegetable) throws StagingVegetableNotFoundException {
        return stagingVegetableRepository.findById(id).map(existingStagingVegetable -> {
            existingStagingVegetable.setUnits(stagingVegetable.getUnits());
            existingStagingVegetable.setState(stagingVegetable.getState());
            existingStagingVegetable.setDistrict(stagingVegetable.getDistrict());
            existingStagingVegetable.setArea(stagingVegetable.getArea());
            existingStagingVegetable.setVegetableName(stagingVegetable.getVegetableName());
            existingStagingVegetable.setPrice(stagingVegetable.getPrice());
            existingStagingVegetable.setLocationName(stagingVegetable.getLocationName());
            return stagingVegetableRepository.save(existingStagingVegetable);
        }).orElseThrow(() -> new StagingVegetableNotFoundException("Vegetable not found with Vegetable name:"));
    }

    @Override
    public void deleteStagingVegetableById(Long id) throws StagingVegetableNotFoundException {
        try {
            stagingVegetableRepository.deleteById(id);
        } catch (Exception e) {
            throw new StagingVegetableNotFoundException("StagingVegetable not found for this id: " + id);
        }
    }
}

