package org.generation.deployproduct.repository.Entity;

import org.generation.deployproduct.controller.dto.ItemDTO;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
    private String category;
    private double price;
    private int quantity;

    public Item() {}

    public Item(ItemDTO itemDto) {
        this.name = itemDto.getName();
        this.description = itemDto.getDescription();
        this.imageUrl = itemDto.getImageUrl();
        this.category = itemDto.getCategory();
        this.price = itemDto.getPrice();
        this.quantity = itemDto.getQuantity();
    }

    // Overloading constructor
    public Item(String name, String description, String imageUrl, String category, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getImageUrl() {return "productImages/" + imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageUrl='"
                + imageUrl + '\'' + ", category='" + category + '\'' + ", price='"  + price + '\'' + ", quantity='"  + quantity + '}';
    }

}
