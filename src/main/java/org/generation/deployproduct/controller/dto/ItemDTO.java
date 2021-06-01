package org.generation.deployproduct.controller.dto;

public class ItemDTO {
    private String name;
    private String description;
    private String imageUrl;
    private String category;
    private double price;
    private int quantity;

    public ItemDTO(String name, String description, String imageUrl, String category, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
}
