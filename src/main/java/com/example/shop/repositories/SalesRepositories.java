package com.example.shop.repositories;

import com.example.shop.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalesRepositories extends JpaRepository<Sales, UUID> {
}
