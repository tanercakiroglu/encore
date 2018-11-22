package com.encore.services;

import com.encore.entities.Product;
import com.encore.irepos.IProductRepo;
import com.encore.iservices.IProductService;
import com.encore.requests.AddProductRequest;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductRepo productRepo;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public List<Product> getAllProduct() {
        return  productRepo.findAll();
    }

    @Override
    public boolean addProduct(AddProductRequest req) {
        Product product = mapper.map(req, Product.class);
        productRepo.save(product);
        return false;
    }

    @Override
    public boolean removeProduct(String id) {
        productRepo.deleteById(Long.valueOf(id));
        return true;
    }
}
