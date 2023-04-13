package com.example.digitalwishlist.service;

import com.example.digitalwishlist.model.Item;
import com.example.digitalwishlist.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public void addItem(String item_name, int item_price) {
        itemRepo.addItem(item_name, item_price);
    }
    public List<Item> getItems() {
        return itemRepo.getItems();
    }

    public int getNewestItemId() {
        return itemRepo.getNewestItemId();
    }
}
