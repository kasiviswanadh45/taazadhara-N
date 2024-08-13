package com.example.taazadhara.N.Controller;

import com.example.taazadhara.N.Entity.Price;
import com.example.taazadhara.N.Service.PriceService;
import com.example.taazadhara.N.exception.PriceHistoryNotFoundException;
import com.example.taazadhara.N.exception.PriceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Price")
public class PriceController {


    @Autowired
    private PriceService priceService;

    @PostMapping("/create")
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {
        try {
            Price createdPrice = priceService.createPrice(price);
            return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long id, @RequestBody Price priceDetails) throws PriceNotFoundException {
        try {
            Optional<Price> updatedPrice = priceService.updatePriceById(id, priceDetails);
            if (updatedPrice.isPresent()) {
                return new ResponseEntity<>(updatedPrice.get(), HttpStatus.OK);
            } else {
                throw new PriceHistoryNotFoundException("Price history not found for ID: " + id);
            }
        } catch (PriceHistoryNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long id) {
        Optional<Price> price = priceService.getPriceById(id);
        return price
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Price>> getAllPrices() {
        try {
            List<Price> prices = priceService.getAllPrices();
            if (prices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(prices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePrice(@PathVariable Long id) throws PriceNotFoundException {
        try {
            priceService.deletePriceById(id);
            return ResponseEntity.ok("Prices successfully deleted");
        } catch (PriceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}



