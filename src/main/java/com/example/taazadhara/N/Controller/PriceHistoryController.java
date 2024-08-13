package com.example.taazadhara.N.Controller;

import com.example.taazadhara.N.Entity.PriceHistory;
import com.example.taazadhara.N.Service.PriceHistoryService;
import com.example.taazadhara.N.exception.PriceHistoryNotFoundException;
import com.example.taazadhara.N.exception.PriceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/PriceHistory/")
public class PriceHistoryController {

    @Autowired
    private PriceHistoryService priceHistoryService;

    @PostMapping("/create")
    public ResponseEntity<PriceHistory> createPriceHistory(@RequestBody PriceHistory priceHistory) {
        try {
            PriceHistory createdPriceHistory = priceHistoryService.createPriceHistory(priceHistory);
            return new ResponseEntity<>(createdPriceHistory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PriceHistory> updatePriceHistoryById(@PathVariable Long id, @RequestBody PriceHistory priceHistoryDetails) throws PriceHistoryNotFoundException {
        try {
            Optional<PriceHistory> updatedPriceHistory = priceHistoryService.updatePriceHistoryById(id, priceHistoryDetails);
            return updatedPriceHistory
                    .map(priceHistory -> new ResponseEntity<>(priceHistory, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceHistory> getPriceHistoryById(@PathVariable Long id) {
        Optional<PriceHistory> priceHistory = priceHistoryService.getPriceHistoryById(id);
        return priceHistory
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PriceHistory>> getAllPriceHistories() {
        try {
            List<PriceHistory> priceHistories = priceHistoryService.getAllPriceHistories();
            if (priceHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(priceHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePriceHistory(@PathVariable Long id) throws PriceHistoryNotFoundException {
        try {
            priceHistoryService.deletePriceHistoryById(id);
            return ResponseEntity.ok("Price History successfully deleted");
        } catch (PriceHistoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
