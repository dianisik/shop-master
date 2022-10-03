package com.example.shop.controller;

import com.example.shop.entities.Shop;
import com.example.shop.repositories.ShopRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("shop")
public class ShopController {
    @Autowired
    ShopRepositories shopRepositories;

    @GetMapping
    public ResponseEntity<List<Shop>> getAll() {
        return new ResponseEntity<>(shopRepositories.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Shop> getById(@PathVariable UUID id) {
        return new ResponseEntity<>(shopRepositories.findById(id).get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){
        return new ResponseEntity<>(shopRepositories.save(shop),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id){
        shopRepositories.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Shop> update(@PathVariable UUID id, @RequestBody Shop newShop){
      newShop.setId(id);
      return new ResponseEntity<>(shopRepositories.save(newShop),HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<Shop> updateName (@PathVariable UUID id, @RequestBody Shop newShop){
        Shop shop = shopRepositories.findById(id).get();
        shop.setNameShop(newShop.getNameShop());
        return new ResponseEntity<>(shopRepositories.save(shop), HttpStatus.OK);
    }


}
