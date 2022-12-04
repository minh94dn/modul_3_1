package model;

public class Product {
    private int id;
    private String name;
    private String brand;
    private Double price;

    public Product() {
    }

    public Product(String name, String brand, Double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Product(int id, String name, String brand, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
