package com.techsctock.techstockcontrol.repository;

import com.techsctock.techstockcontrol.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByProductNameContainingIgnoreCase(
            String productName,
            Pageable pageable
    );

    Page<Product> findByBrand_BrandNameIgnoreCase(
            String brandName,
            Pageable pageable
    );

    Page<Product> findByProductTypeIgnoreCase(
            String productType,
            Pageable pageable
    );

    Page<Product> findByProductNameContainingIgnoreCaseAndBrand_BrandNameIgnoreCase(
            String productName,
            String brandName,
            Pageable pageable
    );
}