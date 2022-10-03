package com.example.shop.controller;

import com.example.shop.entities.Products;
import com.example.shop.entities.Sales;
import com.example.shop.entities.Shop;
import com.example.shop.repositories.ProductsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductsController {

    @Autowired
    ProductsRepositories productsRepositories;

    @GetMapping
    public ResponseEntity<List<Products>> getAll() {
        return new ResponseEntity<>(productsRepositories.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Products> getById(UUID id){
        return new ResponseEntity<>(productsRepositories.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products products){
        return new ResponseEntity<>(productsRepositories.save(products),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id){
        productsRepositories.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Products> update(@PathVariable UUID id, @RequestBody Products newProducts){
        newProducts.setId(id);
        return new ResponseEntity<>(productsRepositories.save(newProducts),HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<Products> updateName (@PathVariable UUID id, @RequestBody Products newProducts){
        Products products = productsRepositories.findById(id).get();
        products.setName (newProducts.getName());
        return new ResponseEntity<>(productsRepositories.save(products), HttpStatus.OK);
    }

}
