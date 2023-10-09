package com.task.backend.service;
import com.task.backend.models.Item;
import com.task.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;




    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }


    public Item createItem(Item item) {
        return itemRepository.save(item);
    }


    public Item updateItem(Long id, Item updatedItem) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found");
        }
        updatedItem.setId(id);
        return itemRepository.save(updatedItem);
    }


    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found");
        }
        itemRepository.deleteById(id);
    }
}
