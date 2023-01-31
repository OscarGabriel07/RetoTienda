package com.sofka.reto.services;

import com.sofka.reto.models.ProductModel;
import com.sofka.reto.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<ProductModel> getProducts(){
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel saveProduct(ProductModel product){
        return productRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id){
        return productRepository.findById(id);
    }

    public boolean deleteById(Long id){
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
