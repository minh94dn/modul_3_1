package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bàn", "abc", 100));
        productList.add(new Product(2, "Ghế", "xyz", 50));
        productList.add(new Product(3, "Tủ", "abc", 200));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void add(Product product) {
        productList.add(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        productList.add(id, product);
    }
}
