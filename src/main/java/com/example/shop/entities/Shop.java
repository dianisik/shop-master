package com.example.shop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Shop {

    @Id
    private UUID id = UUID.randomUUID();

    private String nameShop;

    private String addressShop;


}
