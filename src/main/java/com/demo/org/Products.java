package com.demo.org;

import java.util.Objects;

public class Products {
    // parameters for this class
    private Integer id;
    private String name;
    private String description;
    private Float price;

    // constructor
    public Products(Integer id, String name, String description, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // no args constructor
    public Products() {
    }

    // getter and setter for "id"
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // getter and setter for "name"
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // getter and setter for "description"
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // getter and setter for "price"
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(id, products.id) && Objects.equals(name, products.name) && Objects.equals(description, products.description) && Objects.equals(price, products.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
