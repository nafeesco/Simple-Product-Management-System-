package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //Autowired injects repository in the service
    @Autowired
    private ProductRepository repository;

    //This post method will take the argument as product object and save it
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    //This post method will take list of argument as product objects and save it
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //get all products
    public List<Product> getProducts(){
        return repository.findAll();
    }

    //This method will return product by id or null if the product does not get found
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed!! "+id;
    }


    //Because there is no update method in springdataJPA updates has to be done using set,get and save
    public Product updateProduct(Product product){

        //based on id fetch existing product available on db using get
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        //the fetched values will be populated in existingProduct object and set new values
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        //after setting new values save the existingProduct object
        return repository.save(existingProduct);
    }

}
