package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.Price;
import com.example.taazadhara.N.Repo.PriceRepository;
import com.example.taazadhara.N.exception.PriceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;


    @Override
    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }


    @Override
    public Optional<Price> updatePriceById(Long id, Price priceDetails) {
        return priceRepository.findById(id).map(existingPrice -> {
            existingPrice.setUnits(priceDetails.getUnits());
            existingPrice.setEffectiveDate(priceDetails.getEffectiveDate());
            existingPrice.setCurrentUnitprice(priceDetails.getCurrentUnitprice());
            return priceRepository.save(existingPrice);
        });
    }

    @Override
    public Optional<Price> getPriceById(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    @Override
    public void deletePriceById(Long id) throws PriceNotFoundException {
        if (priceRepository.existsById(id)) {
            priceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Price with ID " + id + " not found");
        }
    }
}






