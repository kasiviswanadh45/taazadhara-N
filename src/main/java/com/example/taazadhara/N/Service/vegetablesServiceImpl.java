package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.Vegetables;
import com.example.taazadhara.N.Repo.VegetablesRepository;
import com.example.taazadhara.N.exception.VegetableNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class vegetablesServiceImpl implements vegetablesService {

    @Autowired
    private VegetablesRepository vegetablesRepository;

    @Override
    public List<Vegetables> getAllVegetables() {
        return vegetablesRepository.findAll();
    }

    @Override
    public Vegetables getVegetableById(Long id) {
        Optional<Vegetables> vegetables = vegetablesRepository.findById(id);
        return vegetables.orElse(null);
    }

    @Override
    public Vegetables createVegetable(Vegetables vegetables) {
        return vegetablesRepository.save(vegetables);
    }

    @Override
    public Optional<Vegetables> updateVegetableById(Long id, Vegetables vegetableDetails) throws VegetableNotFoundException {
        Optional<Vegetables> existingVegetable = vegetablesRepository.findById(id);
        if (existingVegetable.isPresent()) {
            Vegetables vegetable = existingVegetable.get();
            vegetable.setVegetableName(vegetableDetails.getVegetableName());
            vegetablesRepository.save(vegetable);
            return Optional.of(vegetable);
        } else {
            throw new VegetableNotFoundException("Vegetable not found with id: " + id);
        }
    }

    @Override
    public Optional<Vegetables> updateVegetableByName(String vegetableName, Vegetables vegetableDetails) throws VegetableNotFoundException {
        Optional<Vegetables> optionalVegetable = vegetablesRepository.findByvegetableName(vegetableName);
        if (optionalVegetable.isPresent()) {
            Vegetables vegetable = optionalVegetable.get();
            vegetable.setVegetableName(vegetableDetails.getVegetableName());
            // set other fields as necessary
            vegetablesRepository.save(vegetable);
            return Optional.of(vegetable);
        } else {
            throw new VegetableNotFoundException("Not found with that vegetableName " );
        }
    }

    @Override
    public void deleteVegetable(Long id) throws VegetableNotFoundException {
        if (!vegetablesRepository.existsById(id)) {
            throw new VegetableNotFoundException("Vegetable with ID " + id + " not found");
        }
        vegetablesRepository.deleteById(id);
    }
}

