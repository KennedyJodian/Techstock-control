package com.techsctock.techstockcontrol.entity;

import jakarta.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    private String brandName;

    private String madeInOrigin;

    public Brand() {
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getMadeInOrigin() {
        return madeInOrigin;
    }

    public void setMadeInOrigin(String madeInOrigin) {
        this.madeInOrigin = madeInOrigin;
    }
}