package com.techsctock.techstockcontrol.repository;

import com.techsctock.techstockcontrol.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}