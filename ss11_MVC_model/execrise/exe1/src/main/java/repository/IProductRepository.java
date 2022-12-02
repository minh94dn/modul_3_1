package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findByName(String name);

    void add(Product product);

    void delete(int id);

    Product findById(int id);

    void edit(int id, Product product);
}
