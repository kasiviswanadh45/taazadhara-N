package com.example.taazadhara.N.Repo;

import com.example.taazadhara.N.Entity.StagingVegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StagingVegetableRepository extends JpaRepository<StagingVegetable, Long> {
}
