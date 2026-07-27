package com.techsctock.techstockcontrol.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product name is required")
    private String productName;

    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than $0")
    private BigDecimal price;

    @NotBlank(message = "Model number is required")
    private String modelNumber;

    @NotNull(message = "Warranty date is required")
    @Future(message = "Warranty date must be in the future")
    private LocalDate warrantyDate;

    @NotNull(message = "Brand is required")
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @NotBlank(message = "Product type is required")
    private String productType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;



    public Product() {
    }


    public Long getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }


    public String getDescription() {
        return description;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public String getModelNumber() {
        return modelNumber;
    }


    public LocalDate getWarrantyDate() {
        return warrantyDate;
    }


    public Brand getBrand() {
        return brand;
    }


    public String getProductType() {
        return productType;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }


    public void setWarrantyDate(LocalDate warrantyDate) {
        this.warrantyDate = warrantyDate;
    }


    public void setBrand(Brand brand) {
        this.brand = brand;
    }


    public void setProductType(String productType) {
        this.productType = productType;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

