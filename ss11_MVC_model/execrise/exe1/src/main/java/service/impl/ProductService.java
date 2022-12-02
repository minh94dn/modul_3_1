package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductReposirory;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductReposirory();

    @Override
    public List<Product> showAll() {
        return iProductRepository.showAll();
    }

    @Override
    public void add(Product product) {
        iProductRepository.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        iProductRepository.edit(id, product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }
}
