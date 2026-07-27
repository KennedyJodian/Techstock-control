package com.techsctock.techstockcontrol.repository;

import com.techsctock.techstockcontrol.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}