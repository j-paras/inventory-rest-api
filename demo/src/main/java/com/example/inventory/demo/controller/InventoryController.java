package com.example.inventory.demo.controller;

import com.example.inventory.demo.entity.Inventory;
import com.example.inventory.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory){
        Inventory savedInventory=inventoryService.saveInventory(inventory);
        return ResponseEntity.ok(savedInventory);
    }

    @GetMapping("/")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> inventories=inventoryService.getAllInventory();
        return ResponseEntity.ok(inventories);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable("id") Long id, @RequestBody Inventory inventory){
        Optional<Inventory> inventoryOptional=inventoryService.updateInventory(id, inventory);
        return inventoryOptional.isPresent()?ResponseEntity.ok(inventoryOptional.get()):ResponseEntity.notFound().build();
    }

}
