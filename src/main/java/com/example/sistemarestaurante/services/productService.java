package com.example.sistemarestaurante.services;


import com.example.sistemarestaurante.models.productId;
import com.example.sistemarestaurante.models.productModel;
import com.example.sistemarestaurante.repositories.productRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class productService {

    final productRepository ProductRepository;

    public productService(productRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    @Transactional
    public productModel save(productModel ProductModel) {
        return ProductRepository.save(ProductModel);
    }

    public boolean existsByproductName(String ProductName) {
        return ProductRepository.existsByproductName(ProductName);
    }

    public boolean existsByproductCode(int ProductCode) {
        return ProductRepository.existsByproductCode(ProductCode);
    }

    public List<productModel> findAll() {
        return ProductRepository.findAll();
    }

    public Optional<productModel> findByIdN(productId productName) {
        return ProductRepository.findById(productName);
    }


    public Optional<productModel> findByIdC(productId productCode) {
        return ProductRepository.findById(productCode);
    }

    public void delete(productModel ProductModel) {
        ProductRepository.delete(ProductModel);
    }
}
