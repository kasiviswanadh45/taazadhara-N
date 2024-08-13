package com.example.taazadhara.N.Controller;

import com.example.taazadhara.N.Entity.StagingVegetable2;
import com.example.taazadhara.N.Service.StagingVegetable2Service;
import com.example.taazadhara.N.exception.StagingVegetable2NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stagingvegetable2")
public class StagingVegetable2Controller {

    @Autowired
    private StagingVegetable2Service stagingVegetable2Service;

    @PostMapping("/create")
    public ResponseEntity<StagingVegetable2> createStagingVegetable2(@RequestBody StagingVegetable2 stagingVegetable2) {
        StagingVegetable2 createdStagingVegetable2 = stagingVegetable2Service.createStagingVegetable2(stagingVegetable2);
        return new ResponseEntity<>(createdStagingVegetable2, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<StagingVegetable2> getStagingVegetable2ById(@PathVariable Long id) {
        Optional<StagingVegetable2> stagingVegetable2 = stagingVegetable2Service.getStagingVegetable2ById(id);
        return stagingVegetable2
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StagingVegetable2>> getAllStagingVegetable2() {
        List<StagingVegetable2> stagingVegetable2List = stagingVegetable2Service.getAllStagingVegetable2();
        return new ResponseEntity<>(stagingVegetable2List, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StagingVegetable2> updateStagingVegetable2ById(@PathVariable Long id, @RequestBody StagingVegetable2 stagingVegetable2) {
        try {
            Optional<StagingVegetable2> updatedStagingVegetable2ById = stagingVegetable2Service.updateStagingVegetable2ById(id, stagingVegetable2);
            return updatedStagingVegetable2ById
                    .map(vegetable -> new ResponseEntity<>(vegetable, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (StagingVegetable2NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStagingVegetable2(@PathVariable Long id) throws StagingVegetable2NotFoundException {
        try {
            stagingVegetable2Service.deleteStagingVegetable2ById(id);
            return ResponseEntity.ok("StagingVegetable2 successfully deleted");
        } catch (StagingVegetable2NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllStagingVegetable2() throws StagingVegetable2NotFoundException{
        try {
            stagingVegetable2Service.deleteAllStagingVegetable2();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StagingVegetable2NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/export")
    public String exportToCsv(@RequestParam String filePath)  {
        try {
            stagingVegetable2Service.exportStagingVegetable2ToCsv(filePath);
            return "Data exported successfully";
        } catch (IOException e) {
            return "Error during export: " + e.getMessage();
        }
    }

    @PostMapping("/import")
    public String importFromCsv(@RequestParam String filePath) {
        try {
            stagingVegetable2Service.importStagingVegetable2FromCsv(filePath);
            return "Data imported successfully";
        } catch (IOException e) {
            return "Error during import: " + e.getMessage();
        }
    }
}

