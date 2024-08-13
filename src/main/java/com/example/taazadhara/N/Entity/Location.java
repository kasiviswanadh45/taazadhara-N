package com.example.taazadhara.N.Entity;

import jakarta.persistence.*;
import lombok.Data;


/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "location")
public class Location {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_price_id", nullable = false)
    private Long locationPriceId;


    @Column(name = "location_name", nullable = false)
    private String locationName;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "area", nullable = false)
    private String area;

    public Long getLocationPriceId() {
        return locationPriceId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getState() {
        return state;
    }

    public String getArea() {
        return area;
    }


    public String getDistrict() {
        return district;
    }

    public void setLocationPriceId(Long locationPriceId) {
        this.locationPriceId = locationPriceId;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setDistrict(String district) {
        this.district = district;
    }



    public void setArea(String area) {
        this.area = area;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Location{" +
                "area='" + area + '\'' +
                ", state=" +state +
                ", district='" + district + '\'' +
                ", locationName='" +locationName + '\'' +
                ", locationPriceId='" + locationPriceId + '\'' +
                '}';
    }
}
