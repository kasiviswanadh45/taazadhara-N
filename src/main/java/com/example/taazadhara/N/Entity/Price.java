package com.example.taazadhara.N.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "price")
public class Price  {



    @Id
    @Column(name = "price_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;

    @Column(name = "vegetable_id")
    private Long vegetableId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "current_unitprice")
    private BigDecimal currentUnitprice;


    @Column(name = "effective_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date effectiveDate;

    @Column(name = "units")
    private String units;

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public Long getPriceId() {
        return priceId;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    public String getUnits() {
        return units;
    }

    public Long getLocationId() {
        return locationId;
    }

    public BigDecimal getCurrentUnitprice() {
        return currentUnitprice;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setCurrentUnitprice(BigDecimal currentUnitprice) {
        this.currentUnitprice = currentUnitprice;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
