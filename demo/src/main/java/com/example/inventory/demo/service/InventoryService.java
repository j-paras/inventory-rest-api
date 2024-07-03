package com.example.inventory.demo.service;

import com.example.inventory.demo.entity.Inventory;
import com.example.inventory.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

//    InventoryService(InventoryRepository inventoryRepository){
//        this.inventoryRepository=inventoryRepository;
//    }

    public Inventory saveInventory(Inventory inventory){
        try{
//            if (inventory.getId()) {
//                inventory.setId(generateUniqueId());
//            }
            if(inventory.getStatus()==null){
                inventory.setStatus("CREATED");
            }
            if(inventory.getCreatedAt()==null){
                inventory.setCreatedAt(LocalDateTime.now());
            }
            if(inventory.getUpdatedAt()==null){
                inventory.setUpdatedAt(LocalDateTime.now());
            }
            if(inventory.getCreatedBy()==null){
                inventory.setCreatedBy("admin");
            }
            return inventoryRepository.save(inventory);
        }catch (Exception e){
            throw new RuntimeException("Failed to save the inventory:" + e.getMessage());
        }
    }

    public List<Inventory> getAllInventory(){
        try {
            return inventoryRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Failed to fetch all inventory:" + e.getMessage());
        }
    }
    public Optional<Inventory> getInventoryById(Long id){
        try{
            return inventoryRepository.findById(id);
        }catch (Exception e){
            throw new RuntimeException("Failed to fetch inventory by id:" + e.getMessage());
        }
    }
    public Optional<Inventory> updateInventory(Long id, Inventory updateInventory){
        try{
            Optional<Inventory> existingInventoryOptional=inventoryRepository.findById(id);
            if(existingInventoryOptional.isPresent()){
                Inventory existingInventory = existingInventoryOptional.get();
                existingInventory.setSellingPrice(updateInventory.getSellingPrice());
                existingInventory.setLocation(updateInventory.getLocation());
                existingInventory.setAttributes(updateInventory.getAttributes());
                existingInventory.setStatus("MODIFIED");
                existingInventory.setUpdatedAt(LocalDateTime.now());
                Inventory saveInventory=inventoryRepository.save(existingInventory);
                return Optional.of(saveInventory);
            }else {
                return Optional.empty();
            }
        }catch (Exception e){
            throw new RuntimeException("Failed to update the inventory:" + e.getMessage());
        }
    }

}
