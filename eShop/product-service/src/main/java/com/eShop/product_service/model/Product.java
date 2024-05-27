package com.eShop.product_service.model;

public class Product {

    private int id; // TODO; is primitive or wrapper better

    private Integer version;

    private String name;

    private int quantity;

    public Product() {
    }

    public Product(int id, String productName, int quantity, int version) {
        this.id = id;
        this.name = productName;
        this.quantity = quantity;
        this.version = version;
    }

    public Product(String productName, int quantity) {
        this(0, productName, quantity, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
