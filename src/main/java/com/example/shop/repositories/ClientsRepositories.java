package com.example.shop.repositories;

import com.example.shop.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientsRepositories extends JpaRepository<Clients, UUID> {
}
