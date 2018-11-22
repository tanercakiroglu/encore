package com.encore.iservices;

import com.encore.entities.Product;
import com.encore.requests.AddProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    boolean addProduct(AddProductRequest req);
    boolean removeProduct(String id);
}
