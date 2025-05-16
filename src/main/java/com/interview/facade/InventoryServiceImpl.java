package com.interview.facade;

import org.springframework.stereotype.Component;

@Component
public class InventoryServiceImpl implements InventoryService {
    @Override
    public boolean isInventoryEmpty() {
        System.out.println("Inventory is now empty");
        return true;
    }
}
