package com.example.inventory.demo.controller;

import com.example.inventory.demo.entity.Inventory;
import com.example.inventory.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/inventory/create")
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory){
        Inventory savedInventory=inventoryService.saveInventory(inventory);
        return ResponseEntity.ok(savedInventory);
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> inventories=inventoryService.getAllInventory();
        return ResponseEntity.ok(inventories);
    }
}
