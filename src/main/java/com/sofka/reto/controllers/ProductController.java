package com.sofka.reto.controllers;

import com.sofka.reto.models.ProductModel;
import com.sofka.reto.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ArrayList<ProductModel> getProducts(){
        return productService.getProducts();
    }

    @PostMapping()
    public ProductModel saveProduct(@RequestBody ProductModel product){
        return productService.saveProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductModel> getById(@PathVariable("id") Long id){
        return productService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean productDeleted = productService.deleteById(id);
        if(productDeleted) {
            return "Se eliminó el producto con id: " + id;
        }else{
            return "No se pudo eliminar el producto con id: " + id;
        }
    }

}
