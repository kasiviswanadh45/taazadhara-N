package com.example.taazadhara.N.Repo;

import com.example.taazadhara.N.Entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PriceRepository extends JpaRepository<Price, Long>, JpaSpecificationExecutor<Price> {

}