package com.example.taazadhara.N.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "staging_vegetable")
public class StagingVegetable  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staging_vegetable_id", nullable = false)
    private Long stagingVegetableId;



    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "area")
    private String area;

    @Column(name = "vegetable_name")
    private String vegetableName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "units")
    private String units;

    @Column(name = "location_name")
    private String locationName;


}
