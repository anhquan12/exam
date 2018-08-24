package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRest {
    @Autowired
    private ProductRepository productRepository;

    //Get All
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    //Get By Id
    @RequestMapping(value = "/products/{id}" , method = RequestMethod.GET)
    public Product getByProductId(@PathVariable(value = "id") int productId) {
        return productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product" , "id" , productId));

    }



    //Create a new
    @RequestMapping(value="/products" , method = RequestMethod.POST)
    public Product createdProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

//    @RequestMapping(value = "/products/{id}" , method = RequestMethod.GET)
//    public Product getByProductId(@PathVariable(value = "id") int productId) {
//        return productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product" , "id" , productId));
//
//    }

    // Update
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Product sellProduct(@PathVariable(value = "id") int productId, @Valid @RequestBody Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());

        Product updateProduct = productRepository.save(product);
        return updateProduct;
    }

}
