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
@Table(name = "price_history")
public class PriceHistory  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_history_id", nullable = false)
    private Long priceHistoryId;

    @Column(name = "price_id")
    private Long priceId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "effective_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date effectiveDate;

    public BigDecimal getPrice() {
        return price;
    }

    public Long getPriceHistoryId() {
        return priceHistoryId;
    }

    public Long getPriceId() {
        return priceId;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPriceHistoryId(Long priceHistoryId) {
        this.priceHistoryId = priceHistoryId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
