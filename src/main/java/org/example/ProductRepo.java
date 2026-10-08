package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {

    private List<Product> products = new ArrayList<>();

    public void add(Product product){
        products.add(product);
    }

    public void remove(Product product){
        products.remove(product);
    }

    public List<Product> getAll(){
        return products;
    }

    public Optional<Product> getById(int id){
        for (Product product : products){
            if (product.id() == id){
                return Optional.of(product);
            }
        }
        return  Optional.empty();
    }
}
