package com.example.shop.controller;

import com.example.shop.entities.Clients;
import com.example.shop.entities.Products;
import com.example.shop.repositories.ClientsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clients")
public class ClientsController {

    @Autowired
    ClientsRepositories clientsRepositories;

    @GetMapping
    public ResponseEntity<List<Clients>> getAll(){
        return new ResponseEntity<> (clientsRepositories.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Clients> getById(UUID id) {
        return new ResponseEntity<>(clientsRepositories.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Clients> createClients (@RequestBody Clients clients){
        return new ResponseEntity<>(clientsRepositories.save(clients),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id){
        clientsRepositories.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Clients> update(@PathVariable UUID id, @RequestBody Clients newClients){
        newClients.setId(id);
        return new ResponseEntity<>(clientsRepositories.save(newClients),HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<Clients> updateName (@PathVariable UUID id, @RequestBody Products newClients){
        Clients clients = clientsRepositories.findById(id).get();
        clients.setName (newClients.getName());
        return new ResponseEntity<>(clientsRepositories.save(clients), HttpStatus.OK);
    }
}
