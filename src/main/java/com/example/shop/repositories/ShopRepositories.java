package com.example.shop.repositories;

import com.example.shop.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShopRepositories extends JpaRepository<Shop, UUID> {
}
