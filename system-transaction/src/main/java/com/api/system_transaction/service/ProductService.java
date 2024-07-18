package com.api.system_transaction.service;

import com.api.system_transaction.DTOS.ProductDTO;
import com.api.system_transaction.domain.product.Product;
import com.api.system_transaction.infra.exceptions.NotFoundIdException;
import com.api.system_transaction.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(Long id){

        return this.productRepository.findById(id).orElseThrow(()-> new RuntimeException(new NotFoundIdException(id)));

    }

    public Product createProduct(ProductDTO productDTO){

        Product newProduct =  new Product(productDTO);
        this.saveProduct(newProduct);
        return newProduct;

    }

    public void saveProduct(Product product){

        this.productRepository.save(product);

    }

    public List<Product> getAllProducts(){

        return this.productRepository.findAll();

    }

}
