package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void add(Product product);
    void edit(int id, Product product);
    Product findById(int id);
}
