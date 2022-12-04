package service.impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.Collection;
import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> showAll() {
        return iProductRepository.showAll();
    }
}
