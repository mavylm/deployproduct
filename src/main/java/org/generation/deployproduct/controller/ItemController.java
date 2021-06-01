package org.generation.deployproduct.controller;

import org.generation.deployproduct.controller.dto.ItemDTO;
import org.generation.deployproduct.repository.Entity.Item;
import org.generation.deployproduct.component.FileUploadUtil;
import org.generation.deployproduct.service.ItemService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    // Proper way using the Services to access
    final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        return itemService.all();
    }

    // Passing ItemDTO class object into the save method
    // Received data passed from fetch/Ajax method in our frontend js
    // ItemDTO class object pass data to Item class (Entity) through Service layer
    @CrossOrigin
    @PostMapping("/add")
    public Item save(@RequestParam(name="name", required = true) String name,
                     @RequestParam(name="description", required = true) String description,
                     @RequestParam(name="imageUrl", required = true) String imageUrl,
                     @RequestParam(name="category", required = true) String category,
                     @RequestParam(name="price", required = true) double price,
                     @RequestParam(name="quantity", required = true) int quantity,
                     @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {
        String uploadDir1 = "productImages/images";
        // String uploadDir2 = "build/resources/main/static/images";

        System.out.println("Inside");

        System.out.println("aaaa :" + multipartFile.getOriginalFilename());

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(uploadDir1, fileName, multipartFile);

        Item itemDto = new Item(name, description, imageUrl, category, price, quantity);
        return itemService.save(itemDto);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Item update(@PathVariable Integer id, @RequestBody ItemDTO itemDto) {
        System.out.println("Hello");
        Item item = itemService.findById(id);
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item.setImageUrl(itemDto.getImageUrl());
        item.setCategory(itemDto.getCategory());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        return itemService.save(item);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }
}
