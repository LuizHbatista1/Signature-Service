package com.api.system_transaction.controller;

import com.api.system_transaction.DTOS.ProductDTO;
import com.api.system_transaction.domain.product.Product;
import com.api.system_transaction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/create")
    public ResponseEntity<Product>createProduct(@RequestBody ProductDTO productDTO){

        Product newProduct =  productService.createProduct(productDTO);
        return new ResponseEntity<>(newProduct , HttpStatus.OK);


    }


    @GetMapping("/plans")
    public ResponseEntity<List<Product>>getAllProducts(@RequestBody ProductDTO productDTO){

        List<Product> newProduct = productService.getAllProducts();
        return new ResponseEntity<>(newProduct , HttpStatus.OK);


    }



}
