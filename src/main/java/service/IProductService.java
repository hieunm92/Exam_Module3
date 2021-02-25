package service;

import model.Product;

import java.util.List;

public interface IProductService extends IGenaricService<Product>{
    List<Product> findByName(String name);
}
