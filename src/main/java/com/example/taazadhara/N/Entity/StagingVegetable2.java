package com.example.taazadhara.N.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "staging_vegetable2")
public class StagingVegetable2  {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "vegetable_id")
    private Long vegetableId;

    @Column(name = "location_price_id")
    private Long locationPriceId;


    public String getArea() {
        return area;
    }

    public String getState() {
        return state;
    }

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public Long getLocationPriceId() {
        return locationPriceId;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    public String getUnits() {
        return units;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public void setLocationPriceId(Long locationPriceId) {
        this.locationPriceId = locationPriceId;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getDistrict() {
        return district;
    }
}
