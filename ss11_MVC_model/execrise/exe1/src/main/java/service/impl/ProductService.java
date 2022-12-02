package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void add(Product product) {
        iProductRepository.add(product);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void edit(Product product) {

    }
}
