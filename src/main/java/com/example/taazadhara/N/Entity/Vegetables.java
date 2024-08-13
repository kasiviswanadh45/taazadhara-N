package com.example.taazadhara.N.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "vegetables")
public class Vegetables  {


    @Id
    @Column(name = "vegetable_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vegetableId;

    @Column(name = "vegetable_name", nullable = false)
    private String vegetableName;


    public String getVegetableName() {
        return vegetableName;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }
}

