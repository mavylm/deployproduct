package org.generation.deployproduct.service;

import org.generation.deployproduct.repository.Entity.Item;

import java.util.List;

public interface ItemService {
    Item save(Item item);

    void delete(int itemId);

    List<Item> all();

    Item findById(int itemId);
}
