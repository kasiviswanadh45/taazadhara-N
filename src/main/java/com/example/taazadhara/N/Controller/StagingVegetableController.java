package com.example.taazadhara.N.Controller;

import com.example.taazadhara.N.Entity.StagingVegetable;
import com.example.taazadhara.N.Service.StagingVegetableService;
import com.example.taazadhara.N.exception.StagingVegetableNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/staging-vegetables")
public class StagingVegetableController {

    @Autowired
    private StagingVegetableService stagingVegetableService;


    @PostMapping("/create")
    public ResponseEntity<StagingVegetable> createStagingVegetable(@RequestBody StagingVegetable stagingVegetable) throws IOException {
        StagingVegetable createdStagingVegetable = stagingVegetableService.createStagingVegetable(stagingVegetable);
        return ResponseEntity.ok(createdStagingVegetable);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StagingVegetable> getStagingVegetableById(@PathVariable Long id) {
        Optional<StagingVegetable> stagingVegetable = stagingVegetableService.getStagingVegetableById(id);
        return stagingVegetable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<StagingVegetable> updateStagingVegetableById(@PathVariable Long id, @RequestBody StagingVegetable stagingVegetableDetails) throws StagingVegetableNotFoundException {
        Optional<StagingVegetable> updatedStagingVegetable = Optional.ofNullable(stagingVegetableService.updateStagingVegetable(id, stagingVegetableDetails));
        return updatedStagingVegetable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/all")
    public ResponseEntity<List<StagingVegetable>> getAllStagingVegetables() {
        return ResponseEntity.ok(stagingVegetableService.getAllStagingVegetables());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStagingVegetable(@PathVariable Long id) throws StagingVegetableNotFoundException {
        try {
            stagingVegetableService.deleteStagingVegetableById(id);
            return ResponseEntity.ok("StagingVegetable successfully deleted");
        } catch (StagingVegetableNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}








































