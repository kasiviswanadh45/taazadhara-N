package com.example.taazadhara.N.Controller;
import com.example.taazadhara.N.Entity.Vegetables;
import com.example.taazadhara.N.Service.vegetablesService;
import com.example.taazadhara.N.exception.LocationNotFoundException;
import com.example.taazadhara.N.exception.VegetableNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vegetables")
public class vegetablesController {

    @Autowired
    private vegetablesService vegetablesService;

    @GetMapping("/veg/all")
    public ResponseEntity<List<Vegetables>> getAllVegetables() {
        return ResponseEntity.ok(vegetablesService.getAllVegetables());
    }

    @GetMapping("/veg/{id}")
    public ResponseEntity<Vegetables> getVegetableById(@PathVariable Long id) {
        Vegetables vegetables = vegetablesService.getVegetableById(id);
        if (vegetables != null) {
            return ResponseEntity.ok(vegetables);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/veg/create")
    public ResponseEntity<Vegetables> createVegetable(@RequestBody Vegetables vegetables) {
        if (vegetables.getVegetableName() == null || vegetables.getVegetableName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(vegetablesService.createVegetable(vegetables));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vegetables> updateVegetableById(@PathVariable Long id, @RequestBody Vegetables vegetableDetails) {
        try {
            Optional<Vegetables> updatedVegetables = vegetablesService.updateVegetableById(id, vegetableDetails);
            return updatedVegetables
                    .map(vegetable -> new ResponseEntity<>(vegetable, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (VegetableNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVegetable(@PathVariable Long id) throws VegetableNotFoundException {
        try {
            vegetablesService.deleteVegetable(id);
            return ResponseEntity.ok("Vegetable successfully deleted");
        } catch (VegetableNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
