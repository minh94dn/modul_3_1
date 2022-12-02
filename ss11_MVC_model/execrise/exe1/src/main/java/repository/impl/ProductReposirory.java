package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductReposirory implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bàn", "abc", 100));
        productList.add(new Product(2, "Ghế", "xyz", 50));
        productList.add(new Product(3, "Tủ", "abc", 200));
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.set(id, product);
            }
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product p :
                productList) {
            product = p;
            break;
        }
        return product;
    }
}

