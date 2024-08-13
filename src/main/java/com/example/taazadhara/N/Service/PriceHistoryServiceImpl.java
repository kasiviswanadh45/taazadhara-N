package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.PriceHistory;
import com.example.taazadhara.N.Repo.PriceHistoryRepository;

import com.example.taazadhara.N.exception.PriceHistoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {


    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Override
    public PriceHistory createPriceHistory(PriceHistory priceHistory) {
        return priceHistoryRepository.save(priceHistory);
    }


    public Optional<PriceHistory> updatePriceHistoryById(Long id, PriceHistory priceHistoryDetails) throws PriceHistoryNotFoundException {
        PriceHistory existingPriceHistory = priceHistoryRepository.findById(id)
                .orElseThrow(() -> new PriceHistoryNotFoundException("PriceHistory with id " + id + " not found"));

        existingPriceHistory.setPrice(priceHistoryDetails.getPrice());
        existingPriceHistory.setEffectiveDate(priceHistoryDetails.getEffectiveDate());
        // Set other fields as needed

        return Optional.of(priceHistoryRepository.save(existingPriceHistory));
    }

    @Override
    public Optional<PriceHistory> getPriceHistoryById(Long id) {
        return priceHistoryRepository.findById(id);
    }

    public List<PriceHistory> getAllPriceHistories() {
        return priceHistoryRepository.findAll();
    }

    @Override
    public void deletePriceHistoryById(Long id) throws PriceHistoryNotFoundException {
        try {
            priceHistoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new PriceHistoryNotFoundException("Location not found for this id: " + id);
        }
    }
}
