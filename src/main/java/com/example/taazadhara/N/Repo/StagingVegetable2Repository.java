package com.example.taazadhara.N.Repo;

import com.example.taazadhara.N.Entity.StagingVegetable2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StagingVegetable2Repository extends JpaRepository<StagingVegetable2, Long>, JpaSpecificationExecutor<StagingVegetable2> {

}