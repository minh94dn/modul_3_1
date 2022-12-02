package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findByName(String name);
    void add(Product product);
    boolean delete(int id);
    Product findById(int id);
    void edit(Product product);
}
