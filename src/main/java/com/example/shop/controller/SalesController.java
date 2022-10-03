package com.example.shop.controller;

import com.example.shop.entities.Sales;
import com.example.shop.entities.Shop;
import com.example.shop.repositories.SalesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("sales")
public class SalesController {

    @Autowired
    SalesRepositories salesRepositories;

    @GetMapping
    public ResponseEntity<List<Sales>> getAll() {
        return new ResponseEntity<>(salesRepositories.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Sales> getBiId(@PathVariable UUID id) {
        return new ResponseEntity<>(salesRepositories.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Sales> createSales(@RequestBody Sales sales){
        return new ResponseEntity<> (salesRepositories.save(sales), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<UUID> deleteById (@PathVariable UUID id){
        salesRepositories.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Sales> update (@PathVariable UUID id, @RequestBody Sales newSales){
        newSales.setId(id);
        return new ResponseEntity<>(salesRepositories.save(newSales), HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<Sales> updateName (@PathVariable UUID id, @RequestBody Sales newSales) {
        Sales sales = salesRepositories.findById(id).get();
        sales.setNameSales(newSales.getNameSales());
        return new ResponseEntity<>(salesRepositories.save(sales), HttpStatus.OK);
    }

}
