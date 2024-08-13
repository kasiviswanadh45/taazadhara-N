package com.example.taazadhara.N.Service;


import com.example.taazadhara.N.Entity.PriceHistory;
import com.example.taazadhara.N.exception.PriceHistoryNotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PriceHistoryService {

    Optional<PriceHistory> updatePriceHistoryById(Long id, PriceHistory priceHistory) throws PriceHistoryNotFoundException;

    PriceHistory createPriceHistory(PriceHistory priceHistory) throws IOException;

    Optional<PriceHistory> getPriceHistoryById(Long id);

    List<PriceHistory> getAllPriceHistories();

    void deletePriceHistoryById(Long id) throws PriceHistoryNotFoundException;

}
