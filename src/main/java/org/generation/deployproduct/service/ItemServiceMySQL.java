package org.generation.deployproduct.service;

import org.generation.deployproduct.repository.Entity.Item;
import org.generation.deployproduct.repository.ItemRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(int itemId) {itemRepository.deleteById(itemId);}

    @Override
    public List<Item> all() {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Item findById(int itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        Item itemResponse = item.get();
        return itemResponse;
    }

}
