package com.example.taazadhara.N.Service;


import com.example.taazadhara.N.Entity.Price;
import com.example.taazadhara.N.exception.PriceNotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PriceService {


    Price createPrice(Price price) throws IOException;

    Optional<Price> updatePriceById(Long id, Price priceDetails) throws PriceNotFoundException;

    Optional<Price> getPriceById(Long id);

    List<Price> getAllPrices();

    void deletePriceById(Long id) throws PriceNotFoundException;



}